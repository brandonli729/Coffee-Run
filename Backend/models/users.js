const uniqid = require('uniqid');
const dateTime = require('get-date');
const db = require('firebase-admin').database();
const path = require('path');


module.exports = class users{

    /*Create a user*/
    constructor(data){
        this.userId = data.userId;
        this.password = data.password;
        this.userFirst = data.userFirst;
        this.userLast = data.userLast;
        this.bio = data.bio;
        this.friends = data.friends;
        this.dateCreated = dateTime();
    }

    serialize(){
        return {
            userId: this.userId,
            password: this.password,
            userFirst: this.userFirst,
            userLast: this.userLast,
            bio: this.bio,
            dateCreated: this.dateCreated
        }
    }

};