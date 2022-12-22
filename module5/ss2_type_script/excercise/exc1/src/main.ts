function fibonacci(number: number): number {
    let a = 0;
    let b = 1;
    let c = a + b;
    let sum = 0;
    let text='';
    for (let i = 0; i <= number; i++) {
        c = b + a;
        a = b;
        b = c;
        sum += c;
        text +=c +'\n';
    }
    console.log(text);
    return sum;
}
console.log("Tổng của số fibonacci: "+fibonacci(10));