// 다양한 유형의 매개변수

// 숫자값을 인자로 전달받아서 함수
// 숫자 2개를 전달받아서 더 큰 값을 반환하는 함수
function max(num1, num2){
    if (num1> num2) {
        return num1;
    }
    return num2;
}

let max1 = max(10, 100);
console.log("큰 값 : ", max1);

// 문자값을 인자로 전달받는 함수
// 매개변수에 문자값이 저장된다
// 이름을 전달받아서 두번째 글자를 "*"로 변환한 문자를 반환한다

function hideName(name){
    return name.split("").map(function(value, index){
        if(index == 1){
            return "*";
        }
        return value;
    }).join("");
}
console.log(hideName("홍길동"));
console.log(hideName("이이"));

// 배열을 인자로 전달받는 함수
// 배열객체를 참조하는 주소값을 전달받는다.
// 주소값을 전달받은 매개변수도 주소값에 해당하는 배열객체를 참조한다
function sum(arr){
    let total = 0; 
    for(let index=0; index<arr.length; index++){
        total += arr[index];
    }
    return total;
}

let numbers = [10, 30, 50, 20];
let result = sum(numbers);
console.log("합계 : ",result);

// 이렇게도 가능하다
let result2 = sum([10,30,50,20]);
console.log("합계 : ",result2);

// 객체를 인자로 전달받는 함수
function check(score) {
    let total = score.kor + score.eng + score.math;
    let average = total/3;

    if(average >= 60) {
        return "합격";
    } else {
        return "불합격";
    }
}


let score1 = {kor : 100, eng : 100, math : 90}
let passed1 = check(score1);
console.log("첫번째 시험 결과 :",passed1);

let passed2 = check({kor:80, eng : 65, math : 48});
console.log("두번째 시험 결과 :",passed2);

let passed3 = check({
        kor : 70,
        eng : 85,
        math : 50
    })
console.log("세번째 시험 결과 :",passed3);