// 국어, 영어, 수학 점수를 전달받아서 총점을 계산하는 함수
function totalScore(kor, eng, math){
    let total = kor + eng + math;
    console.log("총점 : "+total);
}

// 국어, 영어, 수학 점수를 전달받아서 평균을 계산하는 함수
function average(kor, eng, math){
    let total = kor + eng + math;
    let average = total/3;
    console.log("평균 : "+average)
}

// 총점
totalScore(100, 100, );
totalScore(70, 90, 80);
totalScore(50, 35, 77);

console.log();

// 평균     
average(100, 100, 100);
average(70, 90, 80);
average(50, 35, 77);
