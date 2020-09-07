const assert = require('assert')
const isSelfCrossing = require('./solution')

function test() {
  assert(isSelfCrossing([2, 1, 1, 2]))

  assert(!isSelfCrossing([1, 2, 3, 4]))

  // 口字型，相交
  assert(isSelfCrossing([1, 1, 1, 1]))

  // 环，相交
  assert(isSelfCrossing([1,1,2,1,1]))

  // 凹字型，不相交
  assert(!isSelfCrossing([1, 1, 2, 3, 2, 1, 1]))

  // 凹字型，相交
  assert(isSelfCrossing([1, 1, 2, 3, 2, 1, 2]))

  // 凹字型，相交
  assert(isSelfCrossing([1, 1, 2, 3, 2, 1, 3]))

  // 不均匀的凹字型，不相交
  assert(!isSelfCrossing([2, 1, 3, 4, 1, 1]))

  // 不均匀的凹字型，不相交
  assert(!isSelfCrossing([2, 1, 3, 4, 1, 2]))

  // 不均匀的凹字型，相交
  assert(isSelfCrossing([2, 1, 3, 4, 1, 3]))

  // 不均匀的凹字型，相交
  assert(isSelfCrossing([2, 1, 3, 4, 1, 4]))

  // 不均匀的凹字型，相交
  assert(isSelfCrossing([2, 1, 3, 4, 1, 1, 2]))

  // 不均匀的凹字型，不相交
  assert(!isSelfCrossing([2, 1, 3, 5, 3, 2, 2]))

  // 不均匀的凹字型，不相交
  assert(!isSelfCrossing([2, 1, 3, 5, 3, 2, 2, 1]))

  // 不均匀的凹字型，不相交
  assert(!isSelfCrossing([2, 1, 3, 5, 3, 2, 2, 1, 1]))

  // 不均匀的凹字型，相交
  assert(isSelfCrossing([2, 1, 3, 5, 3, 2, 2, 1, 2]))

  // 不均匀的凹字型，相交
  assert(isSelfCrossing([2, 1, 3, 5, 3, 2, 2, 1, 1, 1]))

  // 渐开螺旋线，不相交
  assert(!isSelfCrossing([1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16]))
  assert(!isSelfCrossing([1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30]))

  // 渐开螺旋线，相交
  assert(isSelfCrossing([1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 14, 2]))

  // 渐收螺旋线，不相交
  assert(!isSelfCrossing([16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1]))

  console.log('all tests passed')
}

test()