// break문을 이용해서 반복문 탈출하기

// 1 ~ 100까지 숫자를 더해갈 때, 그 합계가 2000을 넘는 순간의 숫자를 출력하기

let total =0;

for(let num=1; num<=100; num++){
    total += num;

    if(total>2000){
        console.log("최대숫자 : "+num);
        break;
    }
}
console.log("합계 : "+total);
