const assert = require('assert'); 
const findMin = require('./solution.js');
const findMin2 = require('./solution2-binarysearch.js');

function test(f, input, expect) {
  assert.equal(f(input), expect);
  console.log('success: ' + JSON.stringify(input) + ' -> ' + expect);
}

[findMin, findMin2].forEach((f, i) => {
  console.log('-------- solution ' + (i + 1) + ' --------------')
  test(f, [1], 1);
  test(f, [2, 1], 1);
  test(f, [2, 1, 1], 1);
  test(f, [2, 1, 1, 1, 1, 1], 1);
  test(f, [1, 3, 5], 1);
  test(f, [2, 2, 2, 0, 1], 0);
  test(f, [2, 2, 2, 2, 2], 2);
  test(f, [2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 4, 5, 6, 0, 2], 0);
  test(f, [2, 2, 2, 4, 5, 6, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2], 0);
});