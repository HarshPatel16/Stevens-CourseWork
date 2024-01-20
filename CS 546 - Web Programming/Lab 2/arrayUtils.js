const mean = function mean(arr){
    if(Array.isArray(arr)==false) throw 'Wrong parameters'
    if (arr==undefined) throw 'Provide an array'
    if (arr.length<1) throw 'Array is empty';
    let sum =0;
    for(let i=0;i<arr.length;i++){
        if(typeof arr[i] != 'number')   throw 'Array doesn`t have a number'        
        sum=sum+arr[i];
    }
  
    let mean = sum/arr.length;
    return mean;
}

const medianSquared = function medianSquared(arr) {
    if(Array.isArray(arr)==false) throw 'Wrong parameters'
    if (arr==undefined) throw 'Provide an array'
    if (arr.length<1) throw 'Array is empty';

    for(let i=0;i<arr.length;i++){
        if(typeof arr[i] != 'number')   throw 'Array doesn`t have a number' 
    }

    arr.sort(function(a, b){return a - b});

    let median
    if(arr.length % 2 !=0){  
        median = arr[((arr.length+1)/2)-1]
    }
    else{
        median = (arr[(arr.length/2)-1]+arr[(arr.length/2)])/2
    }
    return  median * median
}

const maxElement = function maxElement(arr) {
    if(Array.isArray(arr)==false) throw 'Wrong parameters'
    if (arr==undefined) throw 'Provide an array'
    if (arr.length<1) throw 'Array is empty';

    for(let i=0;i<arr.length;i++){
        if(typeof arr[i] != 'number')   throw 'Array doesn`t have a number' 
    }
    let max=0;
    let ind
    for(let i=0;i<arr.length;i++){
        if(arr[i]>max){
            max = arr[i];
            ind=i;
        }
    }
    let obj={}
    obj[max] = ind
    return obj
}

const fill= function fill(end,value){
    if(end==undefined) throw 'Provide end parameter'
    if(typeof end != 'number') throw 'End is not a number'
    if(end<=0) throw 'End should be greater than 0'
    let fill=[]
    if(value==undefined){
    for(let i=0;i<end;i++){
        fill.push(i)
    }}
    else{
        for(let i=0;i<end;i++){
            fill.push(value)
        }   
    }
    return fill
}

const countRepeating = function countRepeating(arr) {
    if (arr==undefined) throw 'Provide an array'
    if(Array.isArray(arr)==false) throw 'An error'
    
    const obj={}
    for(let i=0;i<arr.length;i++){let count =0;
       for(let j=0;j<arr.length;j++){
       if (arr[i]==arr[j]){count++}
    }
    if(count>1){obj[arr[i]]=count}
}
    return obj
}
    
const isEqual = function isEqual(arr1  , arr2){
    if(arr1.length!=arr2.length){return false}
    else{
   arr1.sort()
   arr2.sort()
   for(var i=0; i<arr2.length; ++i) {
    if(arr1[i] instanceof Array && arr2[i] instanceof Array) {
        arr1[i].sort();
        arr2[i].sort();
        for(var j=0; j<arr2[i].length; ++j) {
            if(arr1[i][j] != arr2[i][j]) return false;
        }
    } else if(arr1[i] != arr2[i]) return false;
}
return true;
    
    }
   
}    

module.exports = {
    mean,
    medianSquared,
    maxElement,
    fill,
    countRepeating,
    isEqual
}