const db = require('firebase-admin').database();
const path = require('path');

module.exports = class database {

    /*Add a user to the database*/
    static addUser(user){
        const ref = db.ref(path.join('users',user.userId));
        ref.set(user.serialize())
    }

    /*Add a run to the database*/
    static addRun(run){
        const ref = db.ref(path.join('activeRuns',run.runId));
        ref.set(run.serialize())
    }

    static editUser(data){
        for(let el in data.toChange){
            if(el.length !== 0) {
                const ref = db.ref(path.join('users', data.identifier.userId, el));
                ref.set(data.toChange[el])
            }
        }
    }

};