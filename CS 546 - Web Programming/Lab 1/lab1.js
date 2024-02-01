const questionOne = function questionOne(arr) {
 //    Implement question 1 here
    let a= arr[0] * arr[0];
    let b= arr[1] * arr[1];
    let c= arr[2] * arr[2];
    let r= a + b + c;
    return r;
    }

const questionTwo = function questionTwo(num) { 
  //   Implement question 2 here
    let result
    if(num==0){result =0;}
    else if(num==1){result =1}
    else {result = questionTwo(num-1)+questionTwo(num-2);}
    return result;
    }

const questionThree = function questionThree(string) {
    // Implement question 3 here
    let count=0;
    for(let i=0;i<string.length;i++) {
        if( string.charAt(i) == 'a' || string.charAt(i) == 'e' || string.charAt(i)=='i'|| string.charAt(i) == 'o'||
            string.charAt(i) == 'u' || string.charAt(i) == 'A' || string.charAt(i)=='E'|| string.charAt(i) == 'I' ||
            string.charAt(i) == 'O' || string.charAt(i) == 'U' )
            {
                count++;
            }
        }
            return count;
    
    }

const questionFour = function questionFour(num) {
    // Implement question 4 here
    if(num<0){return NaN;}
    else if(num == 0 || num == 1){return 1;}
    else {
        let result=questionFour(num-1)*num;
            return result;
        }
    }

module.exports = {
    firstName: " ", 
    lastName: " ", 
    studentId: " ",
    questionOne,
    questionTwo,
    questionThree,
    questionFour
};