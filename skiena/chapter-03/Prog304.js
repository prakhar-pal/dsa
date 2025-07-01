class Dict {
    constructor(size){
        this.size = size;
        this._dict = [];
        for(let i=0;i<size;i++){
            this._dict.push(-1);
        }
    }

    add(key){
        this._dict[key] = key;
    }

    search(key){
        return this._dict[key] === key ? key : -1;
    }

    delete(key){
        this._dict[key] = -1;
    }
}

const size = process.env.DICT_SIZE;
console.log('Dictionary size:', size);
let t = new Date();
const dict = new Dict(size);
console.log('Initialization took: ', (new Date() - t)/1000, 'ms');
t = new Date();
for(let i=0;i<size;i++){
    dict.add(i);
}

console.log('adding took ', (new Date() - t)/1000, 'ms');
t = new Date();
for(let i=0;i<size;i++){
    dict.add(i);
}

console.log('deletion took: ', (new Date() - t)/1000, 'ms');

