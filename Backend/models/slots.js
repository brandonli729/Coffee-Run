const uniqid = require('uniqid');

module.exports = class slots {

    constructor(data) {
        this.runId = data.runId;
        this.userId = data.userId;
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