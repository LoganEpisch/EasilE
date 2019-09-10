// YOU CAN USE THIS FILE AS REFERENCE FOR SERVER DEVELOPMENT

// include the express module
var express = require("express");

// create an express application
var app = express();

// helps in extracting the body portion of an incoming request stream
var bodyparser = require('body-parser');

// fs module - provides an API for interacting with the file system
var fs = require("fs");

// helps in managing user sessions
var session = require('express-session');

// native js function for hashing messages with the SHA-1 algorithm
var sha1 = require('sha1');

// include the mysql module
var mysql = require("mysql");

//include xml2js module
var xml2js = require('xml2js');

// apply the body-parser middleware to all incoming requests
app.use(bodyparser());

// server listens on port 9007 for incoming connections
app.listen(8100, () => console.log('Listening on port 8100!'));
 
var parser = new xml2js.Parser();

app.get('/',function(req, res) {
	
	res.sendFile(__dirname + '/index.html');
});

// GET method route for the login page.
// It serves login.html present in client folder
app.post('/servePortNumber',function(req, res) {
  var portNumber =req.body.portNumber;
  app.listen(portNumber, () => console.log('listening on port ' + portNumber));
});

// middle ware to server static files
app.use('/client', express.static(__dirname + '/client'));
