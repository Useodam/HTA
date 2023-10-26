// 속성과 기능 모두 포함하는 객체
let score1 = {
    // 속성(프로퍼티 정의)
    name : "홍길동",
    kor : 80,
    eng : 70,
    math : 50,
    // 기능(메소드) 정의
    getTotal : function() {
        let total = this.kor + this.eng + this.math;
        return total;
    },
    getAverage : function() {
        let avg = this.getTotal()/3;
        return avg;
    },
    print : function() {
        console.log("--- 성적정보 ---");
        console.log("이름 : ", this.name);
        console.log("국어점수 : ", this.kor);
        console.log("영어점수 : ", this.eng);
        console.log("수학점수 : ", this.math);
        console.log("총점 : ", this.getTotal());
        console.log("평균 : ", this.getAverage());

    }
}

score1.print();