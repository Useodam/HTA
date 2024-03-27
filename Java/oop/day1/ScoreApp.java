package day1;

public class ScoreApp {
	public static void main(String[] args) {
		
		Score s1 = new Score();
		s1.setup("김철수", 70, 80, 90);
		
		Score s2 = new Score();
		s2.setup("박맹구", 80, 50, 70);
		
		Score s3 = new Score();
		s3.setup("이영우", 90, 100, 80);
		
		// 각 객체에 저장된 성적정보 출력하기
		s1.printScore();
		s2.printScore();
		s3.printScore();
	}
}
