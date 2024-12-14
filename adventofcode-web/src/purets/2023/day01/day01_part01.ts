import * as fs from 'fs';

const isDigit = (character: string): boolean => {
  return /^[0-9]+$/.test(character);;
};

const words = fs.readFileSync('./day01.txt', 'utf-8').split('\n');
console.log(words);
let summe = 0;
for (let i = 0 ; i < words.length ; i++) {
  let line = words[i];
  let alleZeichen = line.split('');
  let ersteZiffer = '';
  let letzteZiffer = '';
  for (let zeichen of alleZeichen) {
    if (isDigit(zeichen)) {
      ersteZiffer = zeichen;
      break;
    }
  }
  let umgekehrt = alleZeichen.reverse();
  for (let zeichen of umgekehrt) {
    if (isDigit(zeichen)) {
      letzteZiffer = zeichen;
      break;
    }
  }
  summe += parseInt('' + ersteZiffer + letzteZiffer)
}

console.log('PART 1: ' + summe);


