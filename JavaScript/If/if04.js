/*
    합격 및 장학금 기준 지급
        - 평균점수가 60점 이상이면 합격이다.
        - 평균점수가 95점 이상이면 장학금을 지급한다
*/

let kor = 70;
let eng = 70;
let math = 70;

let passed = "불합격";
let scalarship = "미지급";

let total = kor + eng + math;
let average = total/3;

if (average >= 60) {
    passed = "합격";

    // 내포된 if문
    if (average >= 95){
        scalarship = "지급";
    }
    
}

console.log("평균점수 : "+average);
console.log("합격여부 : " + passed);
console.log("장학금 지급여부 : " + scalarship);