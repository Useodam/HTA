var orderPrice = 700000;

if (orderPrice >= 500000) {
    var point = orderPrice*0.05;
    console.log("적립포인트 : ",point);
}

console.log('적립포인트 : ',point); 

/*
    ---------------------------------------------------
    | 소스코드 내용
    |----------------------------------------------
    | var orderPrice = 700000;
    |
    | if (orderPrice >= 500000) {
    |   var point = orderPrice*0.05;
    |   console.log("적립포인트 : ",point);
    |   }
    |
    | console.log('적립포인트 : ',point); 
    ----------------------------------------------

    ----------------------------------------------
    | 실제로 실행되는 코드 내용
    | ----------------------------------------------
    | var orderPrice, point;
    |
    | orderPrice = 700000;
    |
    | if (orderPrice >= 500000) {
    |   point = orderPrice * 0.05;
    |   console.log("적립포인트 : ",point);
    |   }
    |
    |   console.log("적립포인트 : ", point);
    | ----------------------------------------------
*/