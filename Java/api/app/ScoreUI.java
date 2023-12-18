package app;

import java.util.List;
import java.util.Scanner;

public class ScoreUI {
	ScoreService service = new ScoreService();
	Scanner sc = new Scanner(System.in);

				
		// 모든 성적정보 조회해서 출력하기
		public void 전체조회() {
			System.out.println("[전체 성적 조회]");
			
			List<Score> scores = service.getAllScores();
			System.out.println("----------------------------------------------------");
			System.out.println("학번\t이름\t국어\t영어\t수학\t총점\t평균");
			System.out.println("----------------------------------------------------");

			for(Score s : scores) {
				System.out.print(s.getNo()+"\t");
				System.out.print(s.getName()+"\t");
				System.out.print(s.getKor()+"\t");
				System.out.print(s.getEng()+"\t");
				System.out.print(s.getMath()+"\t");
				System.out.print(s.getTotal()+"\t");
				System.out.println(s.getAverage()+"\t");
			}
			
			System.out.println("----------------------------------------------------");

		}
		
		public void 성적순조회() {
			
			System.out.println("[성적순 조회]");
			List<Score> scores = service.getSortedScores();
			System.out.println("----------------------------------------------------");
			System.out.println("학번\t이름\t국어\t영어\t수학\t총점\t평균");
			System.out.println("----------------------------------------------------");

			for(Score s : scores) {
				System.out.print(s.getNo()+"\t");
				System.out.print(s.getName()+"\t");
				System.out.print(s.getKor()+"\t");
				System.out.print(s.getEng()+"\t");
				System.out.print(s.getMath()+"\t");
				System.out.print(s.getTotal()+"\t");
				System.out.println(s.getAverage()+"\t");
			}
			
			System.out.println("----------------------------------------------------");
			
		}
		
		public void 신규등록() {
			
			System.out.println("[성적 정보 등록]");
			
			System.out.print("학번입력: ");
			int no = sc.nextInt();
			System.out.print("이름입력: ");
			String name = sc.next();
			System.out.print("국어입력: ");
			int kor = sc.nextInt();
			System.out.print("영어입력: ");
			int eng = sc.nextInt();
			System.out.print("수학입력: ");
			int math = sc.nextInt();
			
			Score score = new Score(no, name, kor, eng, math);
			
			service.addNewScore(score);
		}
		
		public void 성적수정하기() {
			System.out.println("[성적 정보 수정하기]");
			
			System.out.println("학번과 성적정보를 입력하세요");
			
			System.out.println("학번입력: ");
			int no = sc.nextInt();
			System.out.println("국어점수 입력: ");
			int kor = sc.nextInt();
			System.out.println("영어점수 입력: ");
			int eng = sc.nextInt();
			System.out.println("수학점수 입력: ");
			int math = sc.nextInt();
			
			service.updateScore(no,kor,eng,math);
			
		}
		
		
		public static void main(String[] args) {
			ScoreUI ui = new ScoreUI();
//			ui.신규등록();
			
//			ui.전체조회();
			ui.성적수정하기();
			ui.성적순조회();
			
	}
}
