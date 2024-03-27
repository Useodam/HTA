// 책정보를 저장하는 오브젝트 생성하기
let book = {
    title : "자바의정석",
    author : "남궁성",
    price : 32000,
    soldOut : false,
    stock : 5
//  property 
};

// 오브젝트에 저장된 값을 출력하기
/*
    오브젝트에 저장된 값 조회/사용하기
        참조변수.프로퍼티명
        참조변수["프로퍼티명"]
*/
console.log("제목 : ",book.title);
console.log("저자 : ",book['author']);
console.log("가격 : ", book.price);
console.log("판매완료여부 : ", book.soldOut);
console.log("재고수량 : ", book.stock);