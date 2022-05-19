package com.example.ny.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.example.ny.domain.BoardDTO;

public class BoardRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private String sql;

	public List<BoardDTO> selectBoardList() {
		sql = "SELECT NO, WRITER, TITLE, CONTENT, CREATED, LASTMODIFIED FROM BOARD";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(BoardDTO.class));
	}

	public BoardDTO selectBoardByNo(long no) {
		sql = "SELECT NO, WRITER, TITLE, CONTENT, CREATED, LASTMODIFIED FROM BOARD WHERE NO = ?";
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(BoardDTO.class), no);
	}

	public int insertBoard(BoardDTO board) {
		return jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				sql = "INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL, ?, ?, ?, TO_CHAR(SYSDATE, 'YYYY-MM-DD'), TO_CHAR(SYSDATE, 'YYYY-MM-DD'))";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, board.getWriter());
				ps.setString(2, board.getTitle());
				ps.setString(3, board.getContent());
				return ps;
			}
		});
	}

	public int updateBoard(BoardDTO board) {
		sql = "UPDATE BOARD SET TITLE = ?, CONTENT = ?, WHERE NO = ?";
		return jdbcTemplate.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, board.getTitle());
				ps.setString(2, board.getContent());
				ps.setLong(3, board.getNo());
			}
		});
	}

	public int removeBoard(long no) {
		sql = "DELETE FROM BOARD WHERE NO = ?";
		return jdbcTemplate.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setLong(1, no);
			}
		});
	}
}