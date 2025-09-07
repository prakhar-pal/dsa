function permutation(permArray,arr,outArr=[],level=0){
    if(arr.length === 0) {
        //console.log(outArr);
        printCount++;
        permArray.push(outArr);
    }
    arr.forEach((el,index)=>{
        const remainingElements = [...arr];
        remainingElements.splice(index,1);
        permutation(permArray, remainingElements, [...outArr,el], level+1);
    });
}
let printCount = 0;
const array = [1,2,3,4,5];
const permutationsArray = [];
permutation(permutationsArray, array);
console.log("pc::",printCount);
console.log("All permutations are::");
console.log(permutationsArray.slice(0,60));

console.log(permutationsArray.slice(61));

