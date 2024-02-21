package controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.el.parser.AstGreaterThanEqual;

import dto.BoardListDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.co.jhta.model2.annotation.Controller;
import kr.co.jhta.model2.annotation.RequestMapping;
import kr.co.jhta.model2.constant.HttpMethod;
import service.BoardService;
import vo.Board;
import vo.User;

@Controller
@RequestMapping(path = "/board")
public class BoardController {
	
	private final BoardService boardService = new BoardService();
	
	@RequestMapping(path = "/detail.do")
	public String detail(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		int no = Integer.parseInt(req.getParameter("no"));
		Board board = boardService.getBoardDetail(no);
		req.setAttribute("board", board);
		
		return "board/detail.jsp";
	}
	
	@RequestMapping(path = "/insert.do")
	public String form(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		return "board/form.jsp";
	}
	
	@RequestMapping(path = "/insert.do", method = HttpMethod.POST)
	public String save(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// 로그인된 사용자정보를 조회한다
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("LOGIN_USER");
		if(user == null) {
			return "redirect:/login.do";
		}
		
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		Board board = new Board();
		board.setTitle(title);
		board.setContent(content);
		board.setUser(user);
		
		boardService.save(board);
		
		return "redirect:list.do?page=1";
	}

	@RequestMapping(path = "/list.do")
	public String list(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		int currentPage = Integer.parseInt(req.getParameter("page"));

		
		Map<String, Object> param = new HashMap<String, Object>();

		
		BoardListDto dto = boardService.getBoardList(currentPage, param);
		req.setAttribute("boardList",dto.getItems());	// List<Board> 객체다
		req.setAttribute("paging",dto.getPagination());	// Pagination
		
		
		return "board/list.jsp";
	}
	
	@RequestMapping(path = "/delete.do")
	public String delete(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// 게시글을 삭제하고, 리스트를 재요청하는 응답을 보낸다
		
		int no = Integer.parseInt(req.getParameter("no"));
		boardService.deleteBoard(no);
		
		return "redirect:list.do?page=1";
	}
	
	@RequestMapping(path = "/modify.do")
	public String modifyform(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		// 게시글 정보를 조회해서 수정화면에 표시한다. 수정화면으로 내부 이동한다
		
		int no = Integer.parseInt(req.getParameter("no"));
		Board board = boardService.getBoardDetail(no);
		req.setAttribute("board", board);
		
		return "board/modifyform.jsp";
	}
	
	@RequestMapping(path = "/modify.do", method = HttpMethod.POST)
	public String modify(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		// 수정화면에 입력한 정보를 제출받아서 게시글 정보를 테이블에서 수정하고, 상세정보를 재요청하는 응답을 보낸다
		
		int no = Integer.parseInt(req.getParameter("no"));
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		boardService.update(no, title, content);
		
		
		
		return "redirect:detail.do?no=" + no;
	}
}
