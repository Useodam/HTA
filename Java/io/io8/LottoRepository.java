package io8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class LottoRepository {

	private List<Lotto> lottos = new ArrayList<Lotto>();
	
	public LottoRepository () {
		load();
	}
	
	private void load(){
		try {
			String path = "src/io8/lotto.csv";
			BufferedReader reader = new BufferedReader(new FileReader(path));
			String text = null;
			while( (text = reader.readLine())!= null) {
				Lotto lotto = Lotto.toLotto(text);
				lottos.add(lotto);
			}
			reader.close();
			
		} catch (IOException e) {
			throw new RuntimeException("파일을 읽어오는 중 오류가 발생하였습니다");
		}
	}
	
	
	
	/**
	 * 로또 당첨번호 정보를 파일에 저장한다 
	 */
	private void stored() {
		try {
			String path = "src/io8/lotto.csv";
			PrintWriter writer = new PrintWriter(path);
			
			for(Lotto lotto : lottos) {
				writer.println(lotto.toText());
			}
			
			writer.flush();
			writer.close();
			
		} catch (IOException e) {
			throw new RuntimeException("파일을 찾을 수 없습니다",e);
		}
	}
	
	public void save(Lotto lotto) {
		lottos.add(lotto);
		stored();
	}
	
	
	/**
	 * 회차번호에 해당하는 로또당첨번호정보를 반한한다
	 * @param lottoNo 회차번호
	 * @return 당첨번호 정보
	 */
	public Lotto getLotto(int lottoNo) {
		for(Lotto l : lottos) {
			if(l.getNo() == lottoNo) {
				return l;
			}
		}
		
		return null;
	}
}
