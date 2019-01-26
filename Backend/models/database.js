const db = require('firebase-admin').database();
const slots = require('./slots.js')
const path = require('path');

module.exports = class database {

    /*Add a user to the database*/
    static addUser(user){
        const ref = db.ref(path.join('users',user.userId));
        ref.set(user.serialize())
    }

    /*Add a run to the database*/
    static addRun(run){
        let ref = db.ref(path.join('dockedRuns',run.runId));
        ref.set(run.serialize());
        ref = db.ref(path.join('allRuns',run.runId));
        ref.set(run.serialize());
    }

    /*Add a run to the being done database*/
    static addIPRun(run){
        const ref = db.ref(path.join('dockedRuns', run));
        //ref.child('zc06s147jr27sne3').remove();
        ref.once('value').then(function(snapshot){
            db.ref(path.join('inProgressRuns', run)).set(snapshot.val());
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

    static claimSpot(run,data){
        const ref = db.ref(path.join('dockedRuns',run,'slots'))
        const numRef = db.ref(path.join('dockedRuns',run,'slotsLeft'))
        const checkRef = db.ref(path.join('dockedRuns', run))
        checkRef.once('value').then(function (snapshot){
            console.log(checkRef, 'ref')
            console.log(snapshot.val(), 'logged')
            const slotIndex = snapshot.val().numSlots - snapshot.val().slotsLeft;
            if (snapshot.val().slotsLeft==1){
                ref.child(slotIndex).set(new slots(data).serialize());
                checkRef.child('slotsLeft').set(snapshot.val().slotsLeft-1);
                database.addIPRun(run)
            }
            else{
                ref.child(slotIndex).set(new slots(data).serialize());
                checkRef.child('slotsLeft').set(snapshot.val().slotsLeft-1);
            }
        });
    }

};