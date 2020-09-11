const assert = require('assert'); 
const findMin = require('./solution.js');

function test(input, expect) {
  assert.equal(findMin(input), expect);
  console.log('success: ' + JSON.stringify(input) + ' -> ' + expect);
}

test([1,3,5], 1);
test([2,2,2,0,1], 0);