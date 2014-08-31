/**
 * Created by anavarro on 30/08/14.
 */
var assert = require('assert');
var database = require('../data/database');
var CollectionDriver = require('../data/collectionDriver').CollectionDriver;
var collectionDriver;

describe('Suite database', function () {
    it('getOnePrototype', function (done) {
        database.getConnection().then(function (db) {
            collectionDriver = new CollectionDriver(db);
            collectionDriver.get('test', {x: 1}, {}).then(
                function (data) {
                    console.log('success:' + JSON.stringify(data));
                    done();
                }
            ).catch(function (error) {
                    console.log('fail 2: ' + JSON.stringify(error));
                    done();
                });
        }).catch(function (error) {
            console.log('fail 1: ' + JSON.stringify(error));
            done();
        });
    });

    it('getAllPrototype', function (done) {
        database.getConnection().then(function (db) {
            collectionDriver = new CollectionDriver(db);
            var options = {
                sort: [
                    ['x', 'desc']
                ]
            };
            collectionDriver.findAll('test', options).then(
                function (data) {
                    console.log('success:' + JSON.stringify(data));
                    done();
                }
            ).catch(function (error) {
                    console.log('fail 2: ' + JSON.stringify(error));
                    done();
                });
        }).catch(function (error) {
            console.log('fail 1: ' + JSON.stringify(error));
            done();
        });
    });
});