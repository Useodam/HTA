package app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ScoreRepositoty {

	private ArrayList<Score> list = new ArrayList<Score>();
	
	public ScoreRepositoty() {
		list.add(new Score(10, "홍길동", 80, 70, 50));
		list.add(new Score(11, "홍은동", 10, 70, 30));
		list.add(new Score(25, "신길동", 80, 40, 20));
		list.add(new Score(47, "연희동", 100, 90, 80));
		list.add(new Score(32, "응암동", 20, 50, 70));
		list.add(new Score(28, "김길동", 80, 90, 50));
		list.add(new Score(18, "김신동", 80, 60, 30));
		list.add(new Score(23, "박박동", 90, 70, 80));
		list.add(new Score(33, "이아동", 60, 70, 50));
		list.add(new Score(26, "최각동", 80, 20, 100));
	}
	
	// 조회는 전체조회와 선택조회
	// 전체조회는 List
	// 선택조회는 조건이 필요 ( 어떠한 기준으로 갖고올건지 )
	
	// 모든 성적정보를 제공하는 메소드
	// 반환타입 : List<Score>
	// 메소드명 : findAll
	// 매개변수 : 없음
	
	@SuppressWarnings("unchecked")
	public List<Score> findAll(){
		return (List<Score>) list.clone();
	}
	
	// 학번을 전달받아서 해당 학번의 성적정보를 제공하는 메소드
	// 반환타입 : Score
	// 메소드명 : findByNo
	// 매개변수 : int no
	
	public Score findByNo(int no) {
		for (Score score : list) {
			if (score.getNo() == no) {
				return score;
			}
		}
		return null;
	}
	
	// 이름을 전달받아서 이름에 해당하는 성적정보를 제공하는 메소드
	// 반환타입 : List<Score>
	// 메소드명 : findByName
	// 매개변수 : String name
	
	public List<Score> findByName(String name){
		List<Score> foundScores = new ArrayList<Score>();
		for(Score score : list) {
			if(score.getName().equals(name)) {
				foundScores.add(score);
			}
		}
		
		return foundScores;
	}
	
	// 저장, 수정, 삭제는 항상 반환타입이 void
	
	// 학번을 전달받아서 해당 학번의 성적정보를 삭제하는 메소드
	// 반환타입 : void
	// 메소드명 : deleteByNo
	// 매개변수 : int no
	
	public void deleteByNo(int no) {
		Iterator<Score> itr = list.iterator();
		while(itr.hasNext()) {
			Score score = itr.next();
			if(score.getNo() == no) {
				itr.remove();
				break;
			}
		}
	}
	
	// 신규 성적정보를 전달받아서 저장하는 메소드
	// 반환타입 : void
	// 메소드명 : save
	// 매개변수 : Score score
	
	public void save(Score score) {
		list.add(score);
	}
}
