/**
 * @param {number} rowsCount
 * @param {number} colsCount
 * @return {Array<Array<number>>}
 */
Array.prototype.snail = function(rowsCount, colsCount) {
    if (rowsCount * colsCount !== this.length) return [];

    const res = Array.from({ length: rowsCount }, () => Array(colsCount));
    let idx = 0;

    for (let col = 0; col < colsCount; col++) {
        if (col % 2 === 0) {
            // Top to bottom
            for (let row = 0; row < rowsCount; row++) {
                res[row][col] = this[idx++];
            }
        } else {
            // Bottom to top
            for (let row = rowsCount - 1; row >= 0; row--) {
                res[row][col] = this[idx++];
            }
        }
    }

    return res;
};