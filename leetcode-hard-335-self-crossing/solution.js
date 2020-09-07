'use strict'

/**
 * Solve the LeetCode problem "335. Self Crossing" in JavaScript.
 * 
 * Problem Description:
 * https://leetcode.com/problems/self-crossing/
 * 
 * by Zhiyong Pan on Apr 26, 2017.
 * 
 * @param {number[]} x
 * @return {boolean}
 */
function isSelfCrossing(x) {
  // point (x,y): current location
  let px = 0, py = 0

  // recent edges
  const edges = []

  /**
   * Judge if two orthogonal edges cross.
   *
   * @param {number} direction direction of edge |e1|.
   * @param {number[4]} e1 an edge
   * @param {number[4]} e2 another edge
   * @return {boolean}
   */
  const cross = (direction, e1, e2) => {
    if (direction === 0 || direction === 2)
      return Math.sign(e2[0] - e1[0]) * Math.sign(e1[0] - e2[2]) >= 0
        && Math.sign(e1[1] - e2[1]) * Math.sign(e2[1] - e1[3]) >= 0
    else
      return Math.sign(e1[0] - e2[0]) * Math.sign(e2[0] - e1[2]) >= 0
        && Math.sign(e2[1] - e1[1]) * Math.sign(e1[1] - e2[3]) >= 0
  }

  for (let i = 0; i < x.length; ++i) {
    let direction = i % 4

    if (direction === 0) { // up
      edges.push([px, py, px, py + x[i]])
      py += x[i]
    } else if (direction === 1) { // left
      edges.push([px, py, px - x[i], py])
      px -= x[i]
    } else if (direction === 2) { // down
      edges.push([px, py, px, py - x[i]])
      py -= x[i]
    } else if (direction === 3) { // right
      edges.push([px, py, px + x[i], py])
      px += x[i]
    }

    // facts:
    //
    // 1. E[i] never cross E[i-1] by definition
    // 2. E[i] never cross E[i-2] since they're parallel
    // 3. E[i] may cross any E[i-3-k], where k=0,1,2,...
    // 4. for any k >= 3, if E[i] cross E[i-1-2k], E[i] will first cross E[i-3]
    //    or E[i-5].
    // 5. for any k >= 1, if E[i] cross E[i-2-2k], E[i] will also cross
    //    E[i-1-2k] or E[i-3-2k]
    // 5.1. E[4] may cross point (0,0)
    // 6. so for E[i], we only have to check E[i-3] and E[i-5], and point(0,0)
    //    for E[4].

    if (i >= 3) {
      for (let k of [1, 2]) {
        let j = (edges.length - 1) - 1 - 2 * k
        if (j >= 0 && cross(direction, edges[edges.length - 1], edges[j])) {
          //console.log(`cross at ${i}, ${edges[edges.length - 1]} vs ${edges[j]} `)
          return true
        }
      }
    }

    // a single special self crossing case which can't be detected by above
    // rules -- a circle back to origin. e.g.,
    // [1,1,2,1,1]
    if (i === 4) {
      if (px === 0 && py === 0) {
        //console.log('back to start point')
        return true
      }
    }

    // remove too old edges
    if (i > 5) {
      edges.shift()
    }
  }

  //console.log('no crossing')
  return false
}

module.exports = isSelfCrossing