// 다양한 타입의 값(문자, 숫자, 불린, 배열, 다른 오브젝트)을 가지고 있는 오브젝트 생성하기

/*
    자동차 판매점에서 관리하는 고객정보
        고객명, 
        나이, 
        전화번호,
        보유차량 - 제조사, 모델명, 연식, 가격 
 */

let customer = {
    name : "홍길동",
    age : 50,
    tel : "010-1234-7890",

    car : {
        company : "현대자동차",
        model : "제네시스",
        year : 2023,
        price : 8700
    }
}
console.log("고객명 : ", customer.name);
console.log("고객나이 : ", customer.age);
console.log("고객연락처 : ", customer.tel);
console.log("보유차량 제조사 : ", customer.car.company);    // 오브젝트안에 오브젝트의 프로퍼티를 출력할땐 상위오브젝트.오브젝트.프로퍼티명 으로 출력한다
console.log("보유차량 모델명 : ", customer.car.model);
console.log("보유차량 연식 : ", customer.car.year);
console.log("보유차량 가격 : ", customer.car.price);