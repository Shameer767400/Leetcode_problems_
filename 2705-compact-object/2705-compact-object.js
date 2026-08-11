/**
 * @param {Object|Array} obj
 * @return {Object|Array}
 */
var compactObject = function(obj) {
    if (Array.isArray(obj)) {
        return obj
            .map(compactObject)
            .filter(Boolean);
    }

    if (obj !== null && typeof obj === "object") {
        const res = {};
        for (const key in obj) {
            const value = compactObject(obj[key]);
            if (Boolean(value)) {
                res[key] = value;
            }
        }
        return res;
    }

    return obj;
};