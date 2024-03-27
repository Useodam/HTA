function plus(num1, num2) {
    let result = num1 + num2;
    console.log("덧셈결과 : ", result);
}

function minus(num1, num2){
    let result = num1- num2;
    console.log("뺄셈결과 : ",result);
}

operator(100, 200, plus);
operator(100, 200, minus);

// 정의된 함수를 사용하는 것이 아닌 함수를 만들어서도 사용할 수 도있다
operator(100, 200, function(x,y){
    let result = x*y;
    console.log("곱셈결과 :",result);
})

// 매개변수로 다른 함수를 전달받는 함수
/*
    - 함수를 매개변수의 인자로 전달하는 목적은 
      호출되는 함수(operator)가 구체적으로 실행할 기능(fn)을 전달하는 것이 목적이다

    - 호출되는 함수(operator)는 구체적인 구현을 직접 구현하지 않고,
      전달받는 기능(fn)을 실행하기만 하면 된다.
*/ 
function operator(value1, value2, fn){
    fn(value1, value2);
}

/*
    위와 같은 방식으로 사용하는 이유
        - 일반적으로 많은 기능들은 변하지 않는 기능과 매번 변하는 기능으로 코드가 구성되어 있다.
        - 변하지 않는 기능은 함수내에 직접 구현한다
        - 매번 변하는 기능은 외부로부터 실행할 기능을 전달받는다.
        - 아래 함수에서 매개변수의 콜백함수는 실제로 실행할 기능(매번 변하는 기능)이 구현된 함수를 전달받는다.

        function 함수(매개변수1, 매개변수2, 콜백함수) {
            함수의 기능 중에서 변하지 않는 부분
            수행문1;
            수행문2;
            수행문3;

            함수의 기능중에서 매번 변하는 부분
            콜백함수(값1, 값2);

            함수의 기능 중에서 변하지 않는 기능
            수행문4;
            수행문5;
            수행문6;
        }
*/