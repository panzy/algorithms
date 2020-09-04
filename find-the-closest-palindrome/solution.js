'use strict'

/**
 * Solution of the LeetCode problem: Find the Closest Palindrome.
 * 
 * Create by Zhiyong Pan on Apr 25, 2017.
 * 
 * @param {string} n length <= 18
 * @return {string}
 */
function minPalindrome(n) {
  if (typeof n !== 'string')
    n = (n).toString()

  // define 0 => -1
  if (n == '0')
    return '-1'

  // add 1 to big number
  let add1 = (s) => (parseInt(s) + 1).toString()

  // sub 1 from big number
  let sub1 = (s) => (parseInt(s) - 1).toString()

  /**
   * compare big number
   * @param {string} a
   * @param {string} b
   * @return {boolean}
   */
  let less = (a, b) => {
    if (a.length < b.length)
      return true
    if (a.length > b.length)
      return false

    for (let i = 0; i < a.length; ++i)
      if (a[i] < b[i])
        return true

    return false
  }


  const cnt = n.length

  const hiParts = [], miParts = []

  if (cnt % 2 === 1) {
    if (cnt > 2) {
      let hi = n.substr(0, (cnt - 1) / 2)

      hiParts.push(hi)
      if (hi > 0)
        hiParts.push(sub1(hi))
      hiParts.push(add1(hi))
    }

    let mi = n[(cnt - 1) / 2]

    miParts.push(mi)

    if (mi > 0)
      miParts.push(sub1(mi))
    else
      miParts.push('9')

    if (mi < 9)
      miParts.push(add1(mi))
    else
      miParts.push('0')
  } else {
    let hi = n.substr(0, cnt / 2)

    hiParts.push(hi)
    if (hi > 0)
      hiParts.push(sub1(hi))
    hiParts.push(add1(hi))
  }

  let p

  // is value q better than p?
  let acceptable = (p, q) => (q != n && (typeof p === 'undefined'
          || Math.abs(q - n) < Math.abs(p - n)
          || less(q, p) && Math.abs(q - n) === Math.abs(p - n)))

  if (hiParts.length > 0) {
    for (let hi of hiParts) {
      let lo = new String(hi).split('').reverse().join('')
      if (miParts.length > 0) {
        for (let mi of miParts) {
          let q = `${hi}${mi}${lo}`
          if (acceptable(p, q))
            p = q
        }
      } else {
        // even digits
        let q = ((lo.length == cnt / 2) ? '' + hi + lo : '' + hi + lo.substr(1))
        if (acceptable(p, q))
          p = q
      }
    }
  } else {
    for (let q of miParts) {
      if (acceptable(p, q))
        p = q
    }
  }

  // special, 100 => 99
  if (cnt > 1) {
    let q = '9'.repeat(cnt - 1)
    if (acceptable(p, q))
      p = q
  }

  // special #2, 999 => 1001
  {
    let q = '1' + '0'.repeat(cnt - 1) + '1'
    if (acceptable(p, q))
      p = q
  }

  return p
}

export default minPalindrome;