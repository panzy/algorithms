const assert = require('assert'); 
const longestConsecutive = require('./solution.js');

function test(input, expect) {
  assert.equal(longestConsecutive(input), expect);
  console.log('success: ' + JSON.stringify(input) + ' -> ' + JSON.stringify(expect));
}

test([], 0);
test([1], 1);
test([100, 4, 200, 1, 3, 2], 4)