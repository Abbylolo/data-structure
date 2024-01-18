/**
 * 1431. 拥有最多糖果的孩子
 * @param {number[]} candies
 * @param {number} extraCandies
 * @return {boolean[]}
 */
const kidsWithCandies = function (candies, extraCandies) {
    const candiesSorted = candies.toSorted((a, b) => b - a)
    const MAX_NUM = candiesSorted[0]
    const res = []
    candies.forEach(item => {
        res.push(item + extraCandies >= MAX_NUM)
    })
    return res
};

/**
 * @param {number[]} candies
 * @param {number} extraCandies
 * @return {boolean[]}
 */
const kidsWithCandies2 = function (candies, extraCandies) {
    const MAX_NUM = Math.max(...candies)
    const items = Array.from(candies, a => a + extraCandies)
    const res = []
    items.forEach(item => {
        res.push(item >= MAX_NUM)
    })
    return res
};

console.log(kidsWithCandies([1,2,3],2))