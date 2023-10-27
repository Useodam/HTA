// 베스트셀러 정보를 표현하는 배열 생성하기
let books = [
    {
        title : "트렌드 코리아 2024",
        author : "김난도",
        price : 18000,
        discountRate : 0.1
    },
    {
        title : "퓨처 셀프",
        author : "벤저민 하디",
        price : 18000,
        discountRate : 0.2
    },
    {
        title : "도시와 그 불확실한 벽",
        author : "무라카미 하루키",
        price : 17000,
        discountRate : 0.15
    }
];

// 배열에 저장된 베스트셀러 정보 출력하기
for (let index=0; index<books.length; index++){
    let x = books[index];
    console.log(x.title, x.price);
}