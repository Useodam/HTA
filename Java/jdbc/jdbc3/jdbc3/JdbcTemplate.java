package jdbc3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

/**
 * JdbcTemplate 클래스는 JDBC를 활용한 데이터베이스 엑세스 작업을 지원하는 클래스다.
 * <p>
 * <pre>
 * 주요 기능
 * 	조회기능
 * 		조회결과가 여러 행일 때 사용하는 기능이다.
 * 		List<T> selectList(String sql, RowMapper<T> rowMapper)
 * 		List<T> selectList(String sql, RowMapper<T> rowMapper, Object... params)
 * 
 * 		조회결과가 한 행일 때 사용하는 기능이다.
 * 		T selectOne(String sql, RowMapper<T> rowMapper)
 * 		T selectOne(String sql, RowMapper<T> rowMapper, Object... params)
 * 	추가기능
 * 		void insert(String sql)
 * 		void insert(String sql, Object... params)
 * 	수정기능
 * 		void update(String sql)
 * 		void update(String sql, Object... params)
 * 	삭제기능
 * 		void delete(String sql)
 * 		void delete(String sql, Object... params)
 * </pre>
 * 
 */
public class JdbcTemplate {

	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "hr";
	private static final String PASSWORD = "zxcv1234";
	
	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException ex) {
			System.err.println("Oracle JDBC 드라이버를 로드할 수 없습니다.");
		}
	}
	
	private static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
	
	private static <T> List<T> executeQuery(String sql, RowMapper<T> rowMapper, Object...params) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			List<T> list = new ArrayList<T>();
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			setParams(pstmt, params);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(rowMapper.mapRow(rs));
			}
			return list;
		} catch (SQLException ex) {
			throw new RuntimeException(ex.getMessage(), ex.getCause());
		} finally {
			try {if (rs != null) rs.close(); } catch (SQLException ex) {}
			try {if (pstmt != null) pstmt.close(); } catch (SQLException ex) {}
			try {if (con != null) con.close(); } catch (SQLException ex) {}
		}		
	}
	
	private static int executeUpdate(String sql, Object...params) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			setParams(pstmt, params);
			return pstmt.executeUpdate();
		} catch (SQLException ex) {
			throw new RuntimeException(ex.getMessage(), ex.getCause());
		} finally {
			try {if (pstmt != null) pstmt.close(); } catch (SQLException ex) {}
			try {if (con != null) con.close(); } catch (SQLException ex) {}
		}
		
	}
	
	private static void setParams(PreparedStatement pstmt, Object[] params) throws SQLException {
		int index = 1;
		
		for (Object param : params) {
			if (param == null) {
				pstmt.setObject(index, null);
				continue;
			}
			
			if (param instanceof String value) {
				pstmt.setString(index, value);
			} else if (param instanceof Integer value) {
				pstmt.setInt(index, value);
			} else if (param instanceof Long value) {
				pstmt.setLong(index, value);
			} else if (param instanceof Double value) {
				pstmt.setDouble(index, value);
			} else if (param instanceof java.sql.Date value) {
				pstmt.setDate(index, value);
			} else if (param instanceof java.util.Date value) {
				pstmt.setDate(index, new java.sql.Date(value.getTime()));
			} else if (param instanceof LocalDate value) {
				pstmt.setDate(index, new java.sql.Date(value.atStartOfDay(ZoneId.systemDefault()).toEpochSecond()));
			} else if (param instanceof LocalDateTime value) {
				pstmt.setDate(index, new java.sql.Date(value.atZone(ZoneId.systemDefault()).toEpochSecond()));
			} 
			
			index++;
		}
	}
	
	/**
	 * <strong>SELECT</strong>문을 실행하고 결과를 반환한다.<br>
	 * 조회결과 <strong style="color:red;">한 건</strong>인 경우 사용한다.
	 * @param <T> 조회된 행의 정보를 저장하는 객체의 타입
	 * @param sql SQL문을 지정한다.
	 * @param rowMapper 조회된 행을 객체에 매핑시키는 RowMapper 인터페이스 구현객체
	 * @return 조회된 행의 정보를 포함하는 객체
	 */
	public static <T> T selectOne(String sql, RowMapper<T> rowMapper) {
		List<T> items = executeQuery(sql, rowMapper);
		if (items.size() > 1) {
			throw new RuntimeException("조회결과가 1개 이상 조회됩니다.");
		}
		if (items.isEmpty()) {
			return null;
		}
		return items.get(0);
	}
	
	/**
	 * <strong>SELECT</strong>문을 실행하고 결과를 반환한다.<br>
	 * 조회결과 <strong style="color:red;">한 건</strong>인 경우 사용한다.
	 * @param <T> 조회된 행의 정보를 저장하는 객체의 타입
	 * @param sql SQL문을 지정한다.
	 * @param rowMapper 조회된 행을 객체에 매핑시키는 RowMapper 인터페이스 구현객체
	 * @param params SQL문의 ?에 바인딩되는 값들
	 * @return 조회된 행의 정보를 포함하는 객체
	 */
	public static <T> T selectOne(String sql, RowMapper<T> rowMapper, Object...params) {
		List<T> items = executeQuery(sql, rowMapper, params);
		if (items.size() > 1) {
			throw new RuntimeException("조회결과가 1개 이상 조회됩니다.");
		}
		if (items.isEmpty()) {
			return null;
		}
		return items.get(0);
	}

	/**
	  * <strong>SELECT</strong>문을 실행하고 결과를 반환한다.<br>
	 * 조회결과 <strong style="color:red;">여러 건</strong>인 경우 사용한다.
	 * @param <T> 조회된 행의 정보를 저장하는 객체의 타입
	 * @param sql SQL문을 지정한다.
	 * @param rowMapper 조회된 행을 객체에 매핑시키는 RowMapper 인터페이스 구현객체
	 * @return 조회된 행의 정보를 포함하는 객체가 여러 개 저장된 List객체
	 */
	public static <T> List<T> selectList(String sql, RowMapper<T> rowMapper) {
		return executeQuery(sql, rowMapper);
	}
	
	/**
	 * <strong>SELECT</strong>문을 실행하고 결과를 반환한다.<br>
	 * 조회결과 <strong style="color:red;">여러 건</strong>인 경우 사용한다.
	 * @param <T> 조회된 행의 정보를 저장하는 객체의 타입
	 * @param sql SQL문을 지정한다.
	 * @param rowMapper 조회된 행을 객체에 매핑시키는 RowMapper 인터페이스 구현객체
	 * @param params SQL문의 ?에 바인딩되는 값들
	 * @return 조회된 행의 정보를 포함하는 객체가 여러 개 저장된 List객체
	 */
	public static <T> List<T> selectList(String sql, RowMapper<T> rowMapper, Object...params) {
		return executeQuery(sql, rowMapper, params);
	}
	
	/**
	 * <strong>INSERT</strong>문을 실행한다.<br>
	 * @param sql 실행할 SQL을 지정한다.
	 * @return 저장된 행의 갯수를 반환한다.
	 */
	public static int insert(String sql) {
		return executeUpdate(sql);
	}
	
	/**
	 * <strong>INSERT</strong>문을 실행한다.<br>
	 * @param sql 실행할 SQL을 지정한다.
	 * @param params SQL문의 ?에 바인딩되는 값들
	 * @return 저장된 행의 갯수를 반환한다.
	 */
	public static int insert(String sql, Object...params) {
		return executeUpdate(sql, params);
	}

	/**
	 * <strong>UPDATE</strong>문을 실행한다.<br>
	 * @param sql 실행할 SQL을 지정한다.
	 * @return 수정된 행의 갯수를 반환한다.
	 */
	public static int update(String sql) {
		return executeUpdate(sql);
	}
	
	/**
	 * <strong>UPDATE</strong>문을 실행한다.<br>
	 * @param sql 실행할 SQL을 지정한다.
	 * @param params SQL문의 ?에 바인딩되는 값들
	 * @return 수정된 행의 갯수를 반환한다.
	 */
	public static int update(String sql, Object...params) {
		return executeUpdate(sql, params);
	}
	
	/**
	 * <strong>DELETE</strong>문을 실행한다.<br>
	 * @param sql 실행할 SQL을 지정한다.
	 * @return 삭제된 행의 갯수를 반환한다.
	 */
	public static int delete(String sql) {
		return executeUpdate(sql);
	}
	
	/**
	 * <strong>DELETE</strong>문을 실행한다.<br>
	 * @param sql 실행할 SQL을 지정한다.
	 * @param params SQL문의 ?에 바인딩되는 값들
	 * @return 삭제된 행의 갯수를 반환한다.
	 */
	public static int delete(String sql, Object...params) {
		return executeUpdate(sql, params);
	}
	
}
