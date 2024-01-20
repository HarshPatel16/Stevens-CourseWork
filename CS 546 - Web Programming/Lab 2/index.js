const arrayUtils = require('./arrayUtils');
const stringUtils = require('./stringUtils');
const objUtils = require('./objUtils');


// Mean Tests
try {
    // Should Pass
    const meanOne = arrayUtils.mean([1,2,3]);
    console.log(meanOne);
    console.log('mean passed successfully');
   } catch (e) {
    console.error('mean failed test case');
   }

try {
    // Should Fail
    const meanTwo = arrayUtils.mean(1234);
    console.error('mean did not error');
   } catch (e) {
    console.log('mean failed successfully');
}
 
// Median Tests
try {
   // Should Pass
   const median = arrayUtils.medianSquared([4,1,2])
   console.log(median);
   console.log('median passed successfully');
  } catch (e) {
   console.error('median failed test case');
  }

try {
   // Should Fail
   const median2 = arrayUtils.medianSquared(122)
   console.error('median did not error');
  } catch (e) {
   console.log('median failed successfully');
}

// maxElelment Tests
try {
   // Should Pass
   const maxElelment = arrayUtils.maxElement([5,6,7])
   console.log(maxElelment);
   console.log('maxElelment passed successfully');
  } catch (e) {
   console.error('maxElelment failed test case');
  }

try {
   // Should Fail
   const maxElelment2 = arrayUtils.maxElement(122)
   console.error('maxElelment did not error');
  } catch (e) {
   console.log('maxElelment failed successfully');
}

// Fill Tests
try {
   // Should Pass
   const fill = arrayUtils.fill(6)
   console.log(fill);
   console.log('fill passed successfully');
  } catch (e) {
   console.error('fill failed test case');
  }

try {
   // Should Fail
   const fill2 = arrayUtils.fill("test")
   console.error('fill2 did not error');
  } catch (e) {
   console.log('fill2 failed successfully');
}

// countRepeating Tests
try {
   // Should Pass
   const countRepeating1 = arrayUtils.countRepeating([7, '7', 13, true, true, true, "Hello","Hello", "hello"]);
   console.log(countRepeating1);
   console.log('countRepeating passed successfully');
  } catch (e) {
   console.error('countRepeating failed test case');
  }

try {
   // Should Fail
   const countRepeating2 = arrayUtils.countRepeating("test")
   console.error('countRepeating did not error');
  } catch (e) {
   console.log('countRepeating failed successfully');
}

// isEqual(arrayOne, arrayTwo) Tests
try {
   // Should Pass
   const isEqual1 = arrayUtils.isEqual([[ 1, 2, 3 ], [ 4, 5, 6 ], [ 7, 8, 9 ]], [[ 3, 1, 2 ], [ 5, 4, 6 ], [ 9, 7, 8 ]]);
   console.log(isEqual1);
   console.log('isEqual passed successfully');
  } catch (e) {
   console.error('isEqual failed test case');
  }

try {
   // Should Fail
   const isEqual2 = arrayUtils.isEqual("test")
   console.error('isEqual did not error');
  } catch (e) {
   console.log('isEqual failed successfully');
}

// camelCase(string)
try {
   // Should Pass
   const camelcase = stringUtils.camelcase('my function rocks'); // Returns: "myFunctionRocks"
   console.log(camelcase);
   console.log('camelcase passed successfully');
  } catch (e) {
   console.error('camelcase failed test case', e);
  }

try {
   // Should Fail
   const camelcase2 = stringUtils.camelcase("test")
   console.error('camelcase failed successfully');
  } catch (e) {
   console.log('camelcase failed successfully');
}

// replaceChar
try {
   // Should Pass
   const replaceChar = stringUtils.replceChar("Daddy"); 
   console.log(replaceChar);
   console.log('replaceChar passed successfully');
  } catch (e) {
   console.error('replaceChar failed test case', e);
  }

try {
   // Should Fail
   const replaceChar2 = stringUtils.replceChar("test")
   console.error('replaceChar failed successfully');
  } catch (e) {
   console.log('replaceChar failed successfully');
}

// mashUp
try {
   // Should Pass
   const mashUp = stringUtils.mashUp("Patrick", "Hill"); 
   console.log(mashUp);
   console.log('mashUp passed successfully');
  } catch (e) {
   console.error('mashUp failed test case', e);
  }

try {
   // Should Fail
   const mashUp2 = stringUtils.mashUp("test")
   console.error('mashUp did not error');
  } catch (e) {
   console.log('mashUp failed successfully');
}

// makeArrays
try {
   // Should Pass
   const first = { x: 2, y: 3};
   const second = { a: 70, x: 4, z: 5 };
   const third = { x: 0, y: 9, q: 10 };

   const makeArrays = objUtils.makeArrays([first, second, third]);


   console.log(makeArrays);
   console.log('makeArrays passed successfully');
  } catch (e) {
   console.error('makeArrays failed test case', e);
  }

try {
   // Should Fail
   const makeArrays2 = objUtils.makeArrays("test")
   console.error('makeArrays did not error');
  } catch (e) {
   console.log('makeArrays failed successfully');
}

// isDeepEqual
try {
   // Should Pass
   const first = {a: 2, b: 3};
   const second = {a: 2, b: 4};
   const third = {a: 2, b: 3};
   const forth = {a: {sA: "Hello", sB: "There", sC: "Class"}, b: 7, c: true, d: "Test"}
   const fifth  = {c: true, b: 7, d: "Test", a: {sB: "There", sC: "Class", sA: "Hello"}}

   console.log(objUtils.isDeepEqual(first, second));  
   console.log(objUtils.isDeepEqual(forth, fifth));  
   console.log(objUtils.isDeepEqual(forth, third)); 

   console.log('isDeepEqual passed successfully');
  } catch (e) {
   console.error('isDeepEqual failed test case', e);
  }

try {
   // Should Fail
   const isDeepEqual2 = objUtils.makeArrays("test")
   console.error('isDeepEqual did not error');
  } catch (e) {
   console.log('isDeepEqual failed successfully');
}

try {


   console.log(objUtils.computeObject({ a: 3, b: 7, c: 5 }, n => n * 2));


   console.log('computeObject passed successfully');
  } catch (e) {
   console.error('computeObject failed test case', e);
  }

try {
   // Should Fail
   const computeObject2 = objUtils.computeObject("test")
   console.error('computeObject did not error');
  } catch (e) {
   console.log('computeObject failed successfully');
}