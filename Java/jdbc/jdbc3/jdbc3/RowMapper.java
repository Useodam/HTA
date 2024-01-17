package jdbc3;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * SELECT 문 실행 후 조회된 조회결과를 객체에 매핑시키는 기능이 정의된 인터페이스다.
 * @param <T> 조회결과의 한 행을 저장하는 객체의 타입
 */
@FunctionalInterface
public interface RowMapper<T> {

	/**
	 * ResultSet객체에서 현재 커서가 위치한 행의 데이터를 객체로 변환한다.
	 * @param rs ResultSet객체에서 현재 커서가 위치한 행
	 * @return 현재 행의 데이터를 담고 있는 객체
	 * @throws SQLException
	 */
	T mapRow(ResultSet rs) throws SQLException;
}
