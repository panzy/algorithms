const assert = require('assert'); 
const { ListNode, mergeKLists } = require('./solution.js');

function array2list(a) {
  if (a.length < 1) return null;

  let head = new ListNode(a[0]);
  let p = head;
  for (let i = 1; i < a.length; ++i) {
    p.next = new ListNode(a[i]);
    p = p.next;
  }

  return head;
}

function list2array(head) {
  let a = [];
  let p = head;
  while (p != null) {
    a.push(p.val);
    p = p.next;
  }
  return a;
}

function test(input, expect) {
  assert.deepEqual(list2array(mergeKLists(input.map(array2list))), expect);
  console.log('success: ' + JSON.stringify(input) + ' -> ' + JSON.stringify(expect));
}

test([], []);
test([[]], []);
test([[1,4,5],[1,3,4],[2,6]], [1,1,2,3,4,4,5,6]);