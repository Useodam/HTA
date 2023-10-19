// 배열의 값 탐색하기
// 최대값, 최소값 구하기

let arr = [10, 100, 79, 40, 80, 200, 396, 200, 206, 506];

// 배열의 저장된 값 중에서 최대값을 구하기
/*
    1. 최대값을 저장하는 변수 max를 생성하고, 배열의 0번째 값을 저장한다.
    2. 반복시작
        - index는 1번째부터 시작한다.
        - 배열에서 index번째의 값을 조회해서 변수 num에 대입한다
        - 비교연산자를 이용해서 num > max를 수행해서 true로 판정되면
        num의 값을 max에 대입한다.
    3. 반복종료
    4. 최대값 출력
*/

let max = arr[0]; // 배열의 첫번째 값을 가장 큰값이라고 가정.
for (let index=1; index<=arr.length; index++){
    let num = arr[index];
    if(num > max){
        max = num;
    }
}
console.log("배열의 최대값 : ", max);

// 배열의 저장된 값 중에서 최소값을 구하기
/*
    1. 최소값을 저장하는 변수 min을 생성하고, 배열의 0번째 값을 저장한다.
    2. 반복시작
        - index는 1번째부터 시작한다.
        - 배열에서 index번째의 값을 조회해서 변수 num에 대입한다
        - 비교연산자를 이용해서 num < min를 수행해서 true로 판정되면
        num의 값을 min에 대입한다.
    3. 반복종료
    4. 최대값 출력
*/

let min = arr[0];
for (let index=1; index<=arr.length; index++){
    let num = arr[index];
    if(num < min){
        min = num;
    }
}
console.log("배열의 최소값 : ", min);