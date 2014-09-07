/**
 * Created by anavarro on 30/08/14.
 */
var Promise = require('bluebird');
var logger = require('../loggerConfig/logger')
var log = logger.LOG
var path = require('path')
/**
 * Database connection
 */
var DB;

CollectionDriver = function (db) {
    DB = db;
};

CollectionDriver.prototype.findAll = function (collectionName, options) {
    return new Promise(function (resolve, reject) {
        DB.collection(collectionName).find({}, options).toArray(function (error, results) {
            if (error) {
                throw reject(error);
            }
            log.fatal('test logger fatal')
            log.error('test logger error')
            log.warn('test logger warn')
            var tst = module.filename.slice(__filename.lastIndexOf(path.sep) + 1, module.filename.length - 3)
            log.info(tst + ' test logger info')
            log.debug('test logger info')
            resolve(results);
        });
    });
};
CollectionDriver.prototype.get = function (collectionName, key, options) {
    return new Promise(function (resolve, reject) {
        DB.collection(collectionName).findOne(key, options, function (error, doc) {
            if (error) {
                console.error('Error getting data!!!')
                throw reject(error);
            }
            resolve(doc);
        });
    });
};

exports.CollectionDriver = CollectionDriver;