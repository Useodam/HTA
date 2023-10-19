let korScores = [100, 95, 80, 90, 85];

// 반복문으로 배열에 저장된 모든값  출력하기

// 반복의 횟수는 총 10회, 시작값은 0, 끝값은 배열의 길이보다(10)보다 작은 값이다
for(let index=0; index<korScores.length; index++){
  console.log("index : " + index + " korScores : " + korScores[index]);
}



// 국어점수의 합계를 구하기
let total = 0;
for(let index =0; index <korScores.length; index++){
    total += korScores[index];
}
console.log("총점 : ", total);