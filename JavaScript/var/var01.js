// 자바스크립트는 동적 데이터타입을 지원한다.
// 변수에 저장되는 데이터에 따라 변수의 타입이 달라진다

var a;
console.log("a의 데이터 타입 : ",typeof(a));

a = false;
console.log("a의 데이터 타입 : ",typeof(a));

a = 100;
console.log("a의 데이터 타입 : ",typeof(a));

a = 3.14;
console.log("a의 데이터 타입 : ",typeof(a));

a = "hi";
console.log("a의 데이터 타입 : ",typeof(a));

a = [10, 20, 30];
console.log("a의 데이터 타입 : ",typeof(a));

a = {name : "홍길동", kor : 100, eng : 100, math : 40};
console.log("a의 데이터 타입 : ",typeof(a));

a = function() {
    console.log("함수");
}
console.log("a의 데이터 타입 : ",typeof(a));
