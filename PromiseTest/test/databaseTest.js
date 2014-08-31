/**
 * Created by anavarro on 30/08/14.
 */
var assert = require('assert');
var database = require('../data/database');


describe('Suite database', function () {
    it('getOne', function (done) {
        database.getOneAsync().then(function (data) {
            console.log('success:' + JSON.stringify(data));
            done();
        }).catch(function (error) {
            console.log('fail: ' + JSON.stringify(error));
            done();
        });
    });

    it('getAll', function (done) {
        var options = {
            sort: [
                ['x', 'desc']
            ]
        };
        database.getAllAsync(options).then(function (test) {
            test.each(function (err, item) {
                if (item === null) {
                    done();
                }
                console.log('success: ' + JSON.stringify(item));
            });
        }).catch(function (test) {
            console.log('fail: ' + JSON.stringify(test));
            done();
        });
    });
});