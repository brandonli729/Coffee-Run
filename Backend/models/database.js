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
        let ref = db.ref(path.join('activeRuns',run.runId));
        ref.set(run.serialize());
        ref = db.ref(path.join('allRuns',run.runId));
        ref.set(run.serialize());
    }

    /*Add a run to the being done database*/
    static addIPRun(run){
        const ref = db.ref(path.join('allRuns', run));
        //ref.child('zc06s147jr27sne3').remove();
        ref.once('value').then(function(snapshot){
            console.log(snapshot.val());
            db.ref(path.join('inProgressRuns')).set(path.join(run,snapshot.val()));
            ref.remove();
        });
    }

    static editUser(data){
        for(let el in data.toChange){
            if(el.length !== 0) {
                const ref = db.ref(path.join('users', data.identifier.userId, el));
                ref.set(data.toChange[el])
            }
        }
    }

    /*Add an order to a run*/
    static takeSlot(data){
        const ref = db.ref(path.join('activeRuns'));
        ref.once('value').then(function (snapshot) {
            if (snapshot.hasChild(data.runId))
            callback(!!snapshot.val() ? snapshot.val() : {});
        });
    }

};