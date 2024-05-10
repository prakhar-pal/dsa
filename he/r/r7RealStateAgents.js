
// Sample code to perform I/O:

process.stdin.resume();
process.stdin.setEncoding("utf-8");
var stdin_input = "";

process.stdin.on("data", function (input) {
    stdin_input += input;                               // Reading input from STDIN
});

process.stdin.on("end", function () {
   main(stdin_input);
});


function main(input) {
    // process.stdout.write("Hi, " + input + ".\n");       // Writing output to STDOUT
    let rows = input.split("\n").map(row => row.split(' ').map(num => parseInt(num)));
    console.log('total rows:', rows.length);
    const [n, m, k] = rows[0];
    const comissions = rows.slice(1, m+1);
    console.log(sol1(n,m,k,comissions));
}

function sol2(n,m,k, comissions){
    let houses = Array(n).map(() => []);
    const hasSold = Array(m).map(() => false);
    for(let i=0;i<m;i++){
        for(let position=left;position<=right;position++){
            houses[position] = [...houses[position], i];
        }
    }
    houses = houses.sort((a,b) => {
        function minComission(houseIndex){
            const comissionForHouse = house[]
        }
        if(a.length === 0 || b.length === 0) return 1;
        else {
            return minComission(a) - minComission(b);
        }
    });
}

function sortComission(comissions){
    return comissions.sort((a,b) => {
        if(a[2] !== b[2]){
            return a[2]-b[2];
        }else {
            return (a[1]+a[0]) - (b[0]+b[1]);
        }
    });
}

function sol1(n,m,k, comissions){
    const houseComission = [];
    for(let i=0;i<n;i++){
        houseComission.push(Infinity);
    }
    comissions.forEach(comission => {
        const [l, r, cost] = comission;
        for(let position = l;position<=r;position++){
            houseComission[position] = (isFinite(houseComission[position]) ? houseComission[position] : 0) + cost;
        }
    });
    houseComission.sort((a,b) => {
        if(!isFinite(a) && !isFinite(b)) return 0;
        else if(isFinite(a) && !isFinite(b)) return -1;
        else if(!isFinite(a) && isFinite(b)) return 1;
        else return a-b;
    });
    let totalComission = 0;
    console.log('housecomission:', houseComission.slice(0,k));
    houseComission.slice(0, k).forEach(comission => {
        totalComission+=comission;
    });
    return totalComission;
}