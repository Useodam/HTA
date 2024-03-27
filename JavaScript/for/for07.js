// break와 continue
// continue는 다음 반복을 수행하러 증감식으로 이동한다.

for(let num=1; num <= 10; num++){
    if(num == 6){
        continue;   // 남아있는 수행문의 실행을 중단하고 다음 번 반복을 하러간다
                    // 남아있는 수행문의 실행을 중단하고 증감식으로 이동한다.
    }
    console.log(num);
}
