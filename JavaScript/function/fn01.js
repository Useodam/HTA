// 함수 정의하기
// 3단 구구단을 출력하는 함수
function gugudan() {
    let dan = 3;
    for (let i =1; i<=9; i++){
        console.log(dan+" * " + i +" = " + dan*i);
    }
}

// 함수의 실행
gugudan();
console.log();

// 매개변수의 값에 따라 달라지는 구구단을 호출하는 함수
function gugu(dan) {
    console.log(dan + "을 출력합니다.");
    for (let i =1; i<=9; i++){
        console.log(dan+" * " + i +" = " + dan*i);
    }
}
gugu(4);
gugu(5);