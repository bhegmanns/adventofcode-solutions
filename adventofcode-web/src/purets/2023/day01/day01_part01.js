"use strict";
exports.__esModule = true;
var fs = require("fs");
var DIGIT_EXPRESSION = /^\d$/;
var isDigit = function (character) {
    return /^[0-9]+$/.test(character);
    ;
};

var words = fs.readFileSync('./day01.txt', 'utf-8').split('\n');
console.log(words);
var summe = 0;
for (var i = 0; i < words.length; i++) {
    var line = words[i];
    var alleZeichen = line.split('');
    var ersteZiffer = '';
    var letzteZiffer = '';
    for (var _i = 0, alleZeichen_1 = alleZeichen; _i < alleZeichen_1.length; _i++) {
        var zeichen = alleZeichen_1[_i];
        if (isDigit(zeichen)) {
            ersteZiffer = zeichen;
            break;
        }
    }
    var umgekehrt = alleZeichen.reverse();
    for (var _a = 0, umgekehrt_1 = umgekehrt; _a < umgekehrt_1.length; _a++) {
        var zeichen = umgekehrt_1[_a];
        if (isDigit(zeichen)) {
            letzteZiffer = zeichen;
            break;
        }
    }
    summe += parseInt('' + ersteZiffer + letzteZiffer);
}
console.log('PART 1: ' + summe);
