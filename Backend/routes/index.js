const express = require('express');
const db = require('../models/database');
const router = express.Router();
const User = require('../models/users');
const Run = require('../models/run');

/* GET home page. */
router.get('/', function(req, res, next) {
    res.render('index', { title: 'Express' });

});

/*Create a new user*/
router.get('/addUser', function(req, res, next) {
    const userId = req.query.userId ? req.query.userId: '';
    const password = req.query.password ? req.query.password: '';
    const userFirst = req.query.userFirst ? req.query.userFirst: '';
    const userLast = req.query.userLast ? req.query.userLast: '';
    const bio = req.query.bio ? req.query.bio: '';

    const data = {userId:userId,password:password,userFirst:userFirst,userLast:userLast,bio:bio};
    const user = new User(data);
    db.addUser(user);
    res.end();
});

/*Create a new run*/
router.get('/addRun', function(req, res, next) {
    const numSlots = req.query.numSlots ? req.query.numSlots: '';
    const privacy = req.query.privacy ? req.query.privacy: '';
    const destination = req.query.destination ? req.query.destination: '';

    const data = {numSlots:numSlots,privacy:privacy,destination:destination};
    const run = new Run(data);
    db.addRun(run);
    res.end();
});

router.get('/claimSpot', function (req,res,next){
    const runId = req.query.runId ? req.query.runId: '';
    const userId = req.query.userId ? req.query.userId: '';
    const items = req.query.items ? req.query.items: '';

    data = {runId:runId,userId:userId,items:items}

    db.claimSpot(runId,data)
    res.end()
});

/*Edit a user*/
router.get('/editUser', function (req, res, next) {
    const userId = req.query.userId ? req.query.userId: '';
    const password = req.query.password ? req.query.password: '';
    const userFirst = req.query.userFirst ? req.query.userFirst: '';
    const userLast = req.query.userLast ? req.query.userLast: '';
    const bio = req.query.bio ? req.query.bio: '';

    const data = {identifier:{userId:userId,password:password}, toChange:{userId:userId,password:password,userFirst:userFirst,userLast:userLast,bio:bio}};
    //console.log(data.toChange);
    db.editUser(data);
    res.end();
});



module.exports = router;