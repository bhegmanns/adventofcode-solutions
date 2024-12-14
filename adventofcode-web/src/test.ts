// Inhalt main.ts
let message: string = 'Hello World';
console.log(message);

import * as fs from 'fs';

const words = fs.readFileSync('./day01_t.txt', 'utf-8');
console.log(words);
