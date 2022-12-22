function fibonacci(number) {
    var a = 0;
    var b = 1;
    var c = a + b;
    var sum = 0;
    var text = '';
    for (var i = 0; i <= number; i++) {
        c = b + a;
        a = b;
        b = c;
        sum += c;
        text += c + '\n';
    }
    console.log(text);
    return sum;
}
console.log("Tổng của số fibonacci: " + fibonacci(10));
