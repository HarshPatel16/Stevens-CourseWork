
function makeArrays(obj) {
    if(!obj) throw 'empty parameter'
    if(!(obj instanceof Array)) throw 'Provide an array!';
    if(obj.length == 0) throw 'object is empty';

    for(var i=0; i<obj.length; ++i) {
        if(!(obj[i] instanceof Object)) throw 'not a object';
        if(Object.keys(obj[i]).length < 2) throw 'length should be greater than 2';
    }

    const arr = [];
    for(const object of obj) {
        for (const str in object) {
            arr.push([str, object[str]]);
        }
    }
    return arr;
}

function isDeepEqual(obj1, obj2) {
    if(!obj1 || !obj2) throw 'empty parameters';
    if(!(obj1 instanceof Object) || !(obj2 instanceof Object) ) throw 'objects are not parameters';
    if(Object.keys(obj1).length != Object.keys(obj2).length) return false;
    for (const str in obj1) {
        if(obj1[str] instanceof Object) return isDeepEqual(obj1[str], obj2[str]);
        if(obj1[str] != obj2[str]) return false;
    }
    return true;
}
  console.log(isDeepEqual({a: {sA: "Hello", sB: "There", sC: "Class"}, b: 7, c: true, d: "Test"},{c: true, b: 7, d: "Test", a: {sB: "There", sC: "Class", sA: "Hello"}}))

function computeObject(obj, func) {
    if(!obj) throw 'object is empty'
    if(!(obj instanceof Object)) throw 'parameters is not a object';
    if(!func) throw 'empty function'
    if(!(func instanceof Function)) throw 'func should be function';
    const res = {};
    for (const str in obj) {
        if(isNaN(obj[str])) throw 'values are not numbers';
        res[str] = func(obj[str]);
    }
    return res;
}

module.exports = {
    makeArrays,
    isDeepEqual,
    computeObject
}