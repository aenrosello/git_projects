/**
 * Created by anavarro on 30/08/14.
 */
var http = require('http');
var express = require('express');
var path = require('path');
var MongoClient = require('mongodb').MongoClient;
var Server = require('mongodb').Server;
var CollectionDriver = require('./data/collectionDriver').CollectionDriver;

var app = express();
var mongoHost = 'localhost'; //A
var mongoPort = 27017;
var collectionDriver;

var mongoClient = new MongoClient(new Server(mongoHost, mongoPort));
mongoClient.open(function (err, mongoClient) {
    if (!mongoClient) {
        console.error("Error! Exiting... Must start MongoDB first");
        process.exit(1);
    }
    var db = mongoClient.db("MyDatabase");
    collectionDriver = new CollectionDriver(db);
});

app.set('port', process.env.PORT || 3000);
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'jade');

app.use(express.static(path.join(__dirname, 'public')));

app.get('/', body);
app.use(errorHandler);
http.createServer(app).listen(app.get('port'), logger);

function body(requess, response) {
    response.send('<html><body><h1>Hello World</h1></body></html>');
}

function logger() {
    console.log('Express server listening on port ' + app.get('port'));
}

function errorHandler(requess, response) {
    response.render('404', {url: requess.url});
}

console.log('Server running on port 3000.');