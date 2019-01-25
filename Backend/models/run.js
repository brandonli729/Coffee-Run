const dateTime = require('get-date');
const uniqid = require('uniqid');

module.exports = class run {

    /* Create a run */
    constructor(data){
        this.runId = uniqid();
        this.numSlots = data.numSlots;
        this.privacy = data.privacy;
        this.destination = data.destination;
        this.timeCreated = dateTime();
        this.slotsLeft = data.numSlots;
    }

    genSlots(){
        let blankJson = {};
        for(let i = 1; i <= this.numSlots; i++){
            blankJson[i] = 0;
        }
        return blankJson;
    }

    /* Serialize the run */
    serialize(){
        return {
            runId: this.runId,
            numSlots: this.numSlots,
            privacy: this.privacy,
            destination: this.destination,
            timeCreated: this.timeCreated,
            slotsLeft: this.slotsLeft
        }
    }

};
