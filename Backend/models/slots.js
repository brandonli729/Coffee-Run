const uniqid = require('uniqid');

module.exports = class slots {

    constructor(data) {
        this.userId = data.userId;
        this.runId = data.runId;
        this.items = data.items;
    }

    serialize(){
        return {
            userId: this.userId,
            runId: this.runId,
            items: this.items
        }
    }

};