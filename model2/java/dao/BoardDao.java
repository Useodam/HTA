package dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import ibatis.IbatisUtil;
import vo.Board;

public class BoardDao {

	private final SqlMapClient ibatis = IbatisUtil.getsqlMapClient();
	
	public int getTotalRows() throws SQLException {
		return (int)ibatis.queryForObject("boards.getTotalRows");
	}
	
	@SuppressWarnings("unchecked")
	public List<Board> getAllBoards(Map<String, Object> param) throws SQLException {
		return (List<Board>) ibatis.queryForList("boards.getAllBoards", param);
	}
	
	public Board getBoardByNo(int no) throws SQLException {
		return (Board) ibatis.queryForObject("boards.getBoardByNo", no);
	}
	
	public void insertBoard(Board board) throws SQLException {
		ibatis.insert("boards.insertBoard", board);
	}
	
	public void updatedBoard(Board board) throws SQLException {
		ibatis.update("boards.updatedBoard",board);
	}
}
