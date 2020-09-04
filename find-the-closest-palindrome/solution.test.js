'use strict'

import assert from 'assert'
import minPalindrome from './solution.js'

/**
 * Slow but correct, for testing.
 */
function minPalindrome0(n) {
  // define 0 => -1
  if (n == '0')
    return '-1'

  let up = n + 1
  let lo = n - 1

  while (!isPalindrome(up))
    ++up

  while (lo > 0 && !isPalindrome(lo))
    --lo

  return (lo >= 0 && n - lo <= up - n) ? lo : up
}


function getDigits(n) {
  return (n).toString().split('').map(d => parseInt(d))
}

function isPalindrome(n) {
  let digits = getDigits(n)

  for (let i = 0, b = digits.length; i < b; ++i) {
    if (digits[i] !== digits[b - 1 - i])
      return false
  }

  return true
}

describe('minPalindrome0', () => {
  let tests = [
    [0, -1],
    [1, 0],
    [2, 1],
    [20, 22],
    [10, 9],
    [100, 99],
    [99, 101],
    [999, 1001],
    [200, 202],
    [32997, 33033],
    [123, 121],
    [121, 111],
    [321, 323],
    [323, 313],
  ]

  testPairs(tests, minPalindrome0);
})

describe('minPalindrome', () => {

  // each pair is a an input and expected output.
  let tests = [
    ['1', '0'],
    ['1837722381', '1837667381'],
    ['100000000000000000', '99999999999999999'],
    ['807045053224792883', '807045053350540708'],
    ['999999999999999999', '1000000000000000001'],
  ]

  // part #1, special
  let special = [0, 1, 2, 9, 10, 11, 20, 99, 100, 200, 999, 2000, 99999, 70000, 58027, 32997, 1156, 121, 123, 88335]
  special.forEach((n, i) => {
    tests.push([(n).toString(), minPalindrome0(n).toString()])
  })

  // part #2, randoms
  for (let i = special.length; i < 100; ++i) {
    let n = (Math.random() * 1000000000) | 0
    tests.push([(n).toString(), minPalindrome0(n).toString()])
  }

  testPairs(tests, minPalindrome);
})

function testPairs(pairs, func) {
  pairs.forEach(([input, expect]) => {
    let actual = func(input)
    it(`should ${input} -> ${expect}`, () => {
      assert.equal(actual, expect)
    });
  })
}