// 생성자 함수를 정의하고, 이를 이용해서 객체 생성하기

// 생성자 함수의 첫글자는 항상 대문자
// 상수는 대문자
function Score(name, kor, en, math){
    // 프로퍼티를 생성하고, 매개변수로 전달받은 값을 프로퍼티에 대입.
    this.name = name;
    this.kor = kor;
    this.en = en;
    this.math = math;

    // 메소드 정의하기
    this.getTotal = function() {
        let total = this.kor + this.en + this.math;
        return total;
    }

    this.getAverage = function() {
        let avg = this.getTotal()/3;
        return avg;
    }

    this.print = function() {
        console.log("--- 성적정보 ---");
        console.log("이름 : ", this.name);
        console.log("국어점수 : ", this.kor);
        console.log("영어점수 : ", this.en);
        console.log("수학점수 : ", this.math);
        console.log("총점 : ", this.getTotal());
        console.log("평균 : ", this.getAverage());
    }
}

let s1 = new Score("이름",50,60,70);
let s2 = new Score("이아름",80,60,90);
let s3 = new Score("아름",90,80,40);

console.log(s1); // 객체의 현재 모습만 보는 코드
console.log(s2);
console.log(s3);

s1.print();









// 생성자 함수를 생성자 함수답게 사용하지 못한 케이스
Score("김유신",100,80,75);

// 생성자 함수는 이러한 형식으로 new를 붙여준다
new Score("김유신",100,80,75);