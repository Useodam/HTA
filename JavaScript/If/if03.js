/*
    합격 기준
        평균점수가 60점이상이면 합격이다.
        각 과목의 점수가 40점 미만이 하나라도 존재하면 불합격이다.
*/

let kor = 30;
let eng = 30;
let math = 50;
let 과락여부 = false;
let 합격여부 = "불합격";

// 과락여부를 판정한다.
if( kor < 40 || eng < 40 || math < 40){
    과락여부 = true;
}

let total = kor + eng + math;
let average = total/3;

// 평균점수로 합격여부를 판정 
if (과락여부 == false && average >= 60) {
    합격여부 = "합격";
}

console.log("평균점수 : "+ average);
console.log("최종판정 : "+ 합격여부);

if (과락여부){
    console.log("과목 과락으로 인한 불합격입니다.");
} else {
    console.log("평균점수가 60점 이하이기 때문에 불합격입니다");
}