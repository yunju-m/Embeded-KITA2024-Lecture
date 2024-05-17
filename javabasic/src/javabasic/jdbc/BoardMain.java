package javabasic.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardMain {

	Connection conn;
	PreparedStatement ps;
	ResultSet rs;

	public BoardMain() {
		conn = ConnectionUtil.getConnection();
	}

	public static void main(String[] args) {

		BoardMain bm = new BoardMain();

		try {
			// 1. 등록
			Board board = new Board(0, "게시물 제목", "게시물 내용", null); // bid, bregdate는 sql에서 생성
			int insertResult = bm.insertBoard(board);
			if (insertResult > 0) {
				System.out.println("게시물 등록 성공!");
			}

			// 2. 목록
			List<Board> boardList = bm.listBoard();
			for (Board b : boardList) {
				System.out.println(b);
			}

			// 3. 수정
			board = new Board(1, "수정된 게시물 제목", "수정된 게시물 내용", null);
			int updateResult = bm.updateBoard(board);
			if (updateResult > 0) {
				System.out.println("게시물 수정 성공!");
			}

			// 4. 삭제
			board = new Board(1, null, null, null);
			int deleteResult = bm.deleteBoard(board);
			if (deleteResult > 0) {
				System.out.println("게시물 삭제 성공!");
			}

			// 5. 한건 조회
			board = new Board(3, null, null, null);
			System.out.println(bm.getBoard(board));

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

	} // main

	// 게시물 목록
	List<Board> listBoard() throws SQLException {
		String sql = " select bid, btitle, bcontent, bregdate from board ";
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery(sql);
		List<Board> boardList = new ArrayList<Board>();
		while (rs.next()) {
			Board board = new Board();
			board.setBid(rs.getInt("bid"));
			board.setBtitle(rs.getString("btitle"));
			board.setBcontent(rs.getString("bcontent"));
			board.setBregdate(rs.getTimestamp("bregdate"));
			boardList.add(board);
		}
		return boardList;
	}

	// 게시물 한건 조회
	Board getBoard(Board board) throws SQLException {
		String sql = " select bid, btitle, bcontent, bregdate from board where bid=? ";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, board.getBid());
		rs = ps.executeQuery();
		Board selectBoard = new Board();
		if (rs.next()) {
			selectBoard.setBid(rs.getInt("bid"));
			selectBoard.setBtitle(rs.getString("btitle"));
			selectBoard.setBcontent(rs.getString("bcontent"));
			selectBoard.setBregdate(rs.getTimestamp("bregdate"));
		}
		return selectBoard;
	}

	// 게시물 등록
	int insertBoard(Board board) throws SQLException {
		String sql = " insert into board values(bid_seq.nextval, ?, ?, sysdate) ";
		ps = conn.prepareStatement(sql);
		ps.setString(1, board.getBtitle());
		ps.setString(2, board.getBcontent());
		return ps.executeUpdate();
	}

	// 게시물 수정
	int updateBoard(Board board) throws SQLException {
		String sql = " update board set btitle=?, bcontent=? where bid=? ";
		ps = conn.prepareStatement(sql);
		ps.setString(1, board.getBtitle());
		ps.setString(2, board.getBcontent());
		ps.setInt(3, board.getBid());
		return ps.executeUpdate();
	}

	// 게시물 삭제
	int deleteBoard(Board board) throws SQLException {
		String sql = " delete board where bid=? ";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, board.getBid());
		return ps.executeUpdate();
	}

} // class
