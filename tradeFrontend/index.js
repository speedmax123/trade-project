'use strict';

var rq = require('request');

var task = function () {
    rq('http://localhost/api/trade/user/account/concurrentTest', function (err, rsp, body) {
        console.log('\terror:', err); // Print the error if one occurred
        console.log('\tstatusCode:', rsp && rsp.statusCode); // Print the response status code if a response was received
        console.log('\tbody:', body); // Print the HTML for the Google homepage.
    });
};

var i = 500;
while (i > 0) {
    console.log('concurrent testing\t task id is ' + i);
    task();
    i -= 1;
}
