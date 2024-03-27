/*
    국어, 영어, 수학점수를 전달받아서 총점을 계산하는 함수
    함수명 : totalScore
    매개변수 : kor, eng, math. 각각 국어, 영어, 수학점수를 전달받는다.
*/
function totalScore(kor, eng, math){
    let total = kor + eng + math;
    return total;
}

let result1 = totalScore(100, 100, 100);
let result2 = totalScore(70, 90, 80);
let result3 = totalScore(50, 35, 77);

console.log("첫번째 총점 : "+result1);
console.log("두번째 총점 : "+result2);
console.log("세번째 총점 : "+result3);

console.log();

// 이런식으로도 출력이 가능하다 
console.log("첫번째 총점 : "+ totalScore(100, 100, 100));
console.log("두번째 총점 : "+ totalScore(70, 90, 80));
console.log("세번째 총점 : "+ totalScore(50, 35, 77));