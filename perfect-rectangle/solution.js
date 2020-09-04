'use strict';

/*
Solve the LeetCode problem "391. Perfect Rectangle" in JavaScript.

Problem description:
https://leetcode.com/problems/perfect-rectangle/

by Zhiyong Pan on Apr 24, 2017

---------- SOLUTIN STATUS ---------------
Success
Runtime: 312 ms, faster than 20.83% of JavaScript online submissions for Perfect Rectangle.
Memory Usage: 53.5 MB, less than 33.33% of JavaScript online submissions for Perfect Rectangle.
Next challenges:
*/

Array.prototype.min = function() {
  return Math.min.apply(null, this)
}

Array.prototype.max = function() {
  return Math.max.apply(null, this)
}

Array.prototype.binaryIndexOf = function(searchElement, valueIndex) {

  var minIndex = 0;
  var maxIndex = this.length - 1;
  var currentIndex;
  var currentElement;

  while (minIndex <= maxIndex) {
    currentIndex = (minIndex + maxIndex) / 2 | 0;
    currentElement = this[currentIndex][valueIndex];

    if (currentElement < searchElement) {
      minIndex = currentIndex + 1;
    }
    else if (currentElement > searchElement) {
      maxIndex = currentIndex - 1;
    }
    else {
      while (currentIndex > 0 && this[currentIndex - 1][valueIndex] === searchElement)
        --currentIndex
      return currentIndex
    }
  }

  return -1;
}

/**
 * @param {number[][]} rectangles
 * @return {boolean}
 */
var isRectangleCover = function(rects) {

  if (!rects || rects.length === 0)
    return false

  var x0, y0, x1, y1,
    lRects, bRects, rRects, tRects

  x0 = rects.map(r => r[0]).min()
  y0 = rects.map(r => r[1]).min()
  x1 = rects.map(r => r[2]).max()
  y1 = rects.map(r => r[3]).max()

  lRects = rects.slice()
  lRects.sort((a, b) => a[0] - b[0])

  bRects = rects.slice()
  bRects.sort((a, b) => a[1] - b[1])

  rRects = rects.slice()
  rRects.sort((a, b) => a[2] - b[2])

  tRects = rects.slice()
  tRects.sort((a, b) => a[3] - b[3])

  let area = 0

  // check if left of super rect is covered
  {
    let leftRects = []
    let i = lRects.binaryIndexOf(x0, 0)
    if (i != -1) {
      while (i < lRects.length && x0 === lRects[i][0]) {
        let r2 = lRects[i]
        leftRects.push([r2[1], r2[3]])
        ++i
      }
    }

    if (leftRects.length === 0) {
      return false
    }

    let edges = leftRects.sort((a, b) => a[0] - b[0])
    for (var j = 1; j < edges.length; ++j) {
      if (edges[j][0] !== edges[j - 1][1]) {
        return false
      }
    }

    let a = edges[0][0], b = edges[edges.length - 1][1]
    if (a > y0 || b < y1) {
      return false
    }
  }

  // check if bottom of super rect is covered
  {
    let bottomRects = []
    let i = bRects.binaryIndexOf(y0, 1)
    if (i != -1) {
      while (i < bRects.length && y0 === bRects[i][1]) {
        let r2 = bRects[i]
        bottomRects.push([r2[0], r2[2]])
        ++i
      }
    }

    if (bottomRects.length === 0) {
      return false
    }

    let edges = bottomRects.sort((a, b) => a[0] - b[0])
    for (var j = 1; j < edges.length; ++j) {
      if (edges[j][0] !== edges[j - 1][1]) {
        return false
      }
    }

    let a = edges[0][0], b = edges[edges.length - 1][1]
    if (a > x0 || b < x1) {
      return false
    }
  }


  for (var r of rects) {

    // check if right is covered
    if (r[2] < x1) {
      let rightRects = []
      let i = lRects.binaryIndexOf(r[2], 0)
      if (i != -1) {
        while (i < lRects.length && r[2] === lRects[i][0]) {
          let r2 = lRects[i]
          if (r[3] >= r2[1] && r[1] <= r2[3])
            rightRects.push([r2[1], r2[3]])
          ++i
        }
      }

      if (rightRects.length === 0) {
        return false
      }

      let edges = rightRects.sort((a, b) => a[0] - b[0])
      for (var j = 1; j < edges.length; ++j) {
        if (edges[j][0] !== edges[j - 1][1]) {
          return false
        }
      }

      let a = edges[0][0], b = edges[edges.length - 1][1]
      if (a > r[1] || b < r[3]) {
        return false
      }
    }

    // check if top is covered
    if (r[3] < y1) {
      let topRects = []
      let i = bRects.binaryIndexOf(r[3], 1)
      if (i != -1) {
        while (i < bRects.length && r[3] === bRects[i][1]) {
          let r2 = bRects[i]
          if (r[2] >= r2[0] && r[0] <= r2[2])
            topRects.push([r2[0], r2[2]])
          ++i
        }
      }

      if (topRects.length === 0) {
        return false
      }

      let edges = topRects.sort((a, b) => a[0] - b[0])
      for (var j = 1; j < edges.length; ++j) {
        if (edges[j][0] !== edges[j - 1][1]) {
          return false
        }
      }

      let a = edges[0][0], b = edges[edges.length - 1][1]
      if (a > r[0] || b < r[2]) {
        return false
      }
    }

    area += (r[2] - r[0]) * (r[3] - r[1])
  }

  if (area !== (x1 - x0) * (y1 - y0)) {
    return false
  }

  return true
};

module.exports = isRectangleCover
