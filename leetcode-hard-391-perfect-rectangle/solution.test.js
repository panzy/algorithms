'use strict';

const assert = require('assert')
const isRectangleCover = require('./solution.js')

let bt = new Date().getTime()

var rectangles = []

assert(!isRectangleCover(rectangles))

rectangles = [
  [2,3,3,4]
]
assert(isRectangleCover(rectangles))

rectangles = [[0,0,4,1],[0,0,4,1]]
assert(!isRectangleCover(rectangles))

rectangles = [
  [1,1,4,4],
  [2,2,3,3]
]
assert(!isRectangleCover(rectangles))
// change order
rectangles = [
  [2,2,3,3],
  [1,1,4,4]
]
assert(!isRectangleCover(rectangles))

rectangles = [
  [1,1,3,3],
  [3,1,4,2],
  [3,2,4,4],
  [1,3,2,4],
  [2,3,3,4]
]
assert(isRectangleCover(rectangles))
// change order
rectangles = [
  [1,3,2,4],
  [3,2,4,4],
  [3,1,4,2],
  [2,3,3,4],
  [1,1,3,3]
]
assert(isRectangleCover(rectangles))

rectangles = [
  [1,1,2,3],
  [1,3,2,4],
  [3,1,4,2],
  [3,2,4,4]
]
assert(!isRectangleCover(rectangles))

rectangles = [
  [1,1,3,3],
  [3,1,4,2],
  [1,3,2,4],
  [3,2,4,4]
]
assert(!isRectangleCover(rectangles))

rectangles = [
  [1,1,3,3],
  [3,1,4,2],
  [1,3,2,4],
  [2,2,4,4]
]
assert(!isRectangleCover(rectangles))

rectangles = [[0,0,2,1],[0,1,2,2],[0,2,1,3],[1,0,2,1]]
assert(!isRectangleCover(rectangles))

rectangles = require('./huge-test-case.json')
assert(isRectangleCover(rectangles))

rectangles = require('./huge-test-case2.json')
assert(isRectangleCover(rectangles))

rectangles = require('./huge-test-case3.json')
assert(!isRectangleCover(rectangles))

rectangles = require('./huge-test-case4.json')
assert(isRectangleCover(rectangles))

console.log('elapse', (new Date().getTime() - bt), 'ms')
