function delayedResponse(data) {
    return new Promise((resolve, reject) => {
        const time = Math.random() * 3;
        setTimeout(() => {
            if (time > 2.99) reject(`request timed out, time ${time}`);
            resolve(data);
        }, time);
    });
}

function getDRforData(data){
    delayedResponse(`ans_${Math.random()*100}`).then(res=>{})
    .catch(err=> console.log(`counter ${data}, response ${err}`));
}

let counter = 100;
while (counter--) {
    getDRforData(counter);
}