// 지정된 두 정수의 범위에 해당하는 모든 정수의 합계를 계산해서 출력하기

let a = 10;
let z = 30;
let total=0;

for(let num = a; num <= z; num++){
    total += num;
}

console.log("합계 : "+total);