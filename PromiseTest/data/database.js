/**
 * Created by anavarro on 30/08/14.
 */
var Promise = require('bluebird');
var mongodb = require('mongodb');

var MongoClient = mongodb.MongoClient;

//Promise.promisifyAll(MongoClient);

exports.getConnection = function () {
    return new Promise(function (resolve, reject) {
        MongoClient.connect('mongodb://localhost:27017/test', function (err, db) {
            if (err) {
                console.error('Error!!!')
                throw reject(err);
            }
            console.log('Connected!!!')
            resolve(db);

        });
    });
};

/*exports.getOneAsync = function () {
 return MongoClient.connectAsync('mongodb://localhost:27017/test')
        .then(function (db) {
            console.log("Connected to MongoDB");
            return new Promise(function (resolve, reject) {
                db.collection("test").findOne({x: 1}, function (err, item) {
                    if (err) {
                        throw reject(err);
                    }
                    resolve(item);
                });
            });
        });
};

exports.getAllAsync = function (options) {
    return MongoClient.connectAsync('mongodb://localhost:27017/test')
        .then(function (db) {
            console.log("Connected to MongoDB");
            return new Promise(function (resolve, reject) {
                db.collection('test').find({}, options, function (err, result) {
                    if (err) {
                        throw reject('error');
                    }
                    resolve(result);

                });
            });
        });
 };*/