// 배열에 값이 있는지 확인하기
let names = ["쓴커피","단커피","향커피"];

// 존재하는지 체크할 값은 "강감찬"이라고 가정한다.
/*
    1. 존재여부를 저장하는 변수 exist를 생성하고 초기값으로 false를 입력한다.
    2. 반복시작
        - 배열의 0번째부터 값을 조회해서 변수 name에 대입한다.
        - name의 값과 value의 값이 일치하면, exist에 true를 대입한다.
    3. 반복종료
    4. exist의 값을 출력한다.
*/
let value = "쓴커피";
let exist = false;

for(let index=0; index<=names.length; index++){
    let name = names[index];
    if(value == name){
        exist = true;
        break; // 일치하는 값을 발견하면 더이상 배열의 값을 조사할 필요가 없다.
    }
}
console.log("존재여부 : "+ exist);