package jsp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.eclipse.jdt.internal.compiler.impl.IntConstant;

public class MB18DAO {

	Context initContext;
	Context envContext;
	DataSource ds;
	Connection con;
	PreparedStatement psmt;
	ResultSet rs;

	public MB18DAO() {
		try {
			initContext = new InitialContext();
			envContext = (Context) initContext.lookup("java:/comp/env");
			ds = (DataSource) envContext.lookup("jdbc/myoracle");
		} catch( NamingException e ) {
			e.printStackTrace();
		}
	}//constructor

	public ArrayList<BoardDTO> list() throws SQLException {
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();

		con = ds.getConnection();

		String sql = "select mb.bno, mb.btitle, mb.mno, m.mid, mb.bcnts, mb.bdate"
				+ " from memberboard mb, member m"
				+ " where mb.mno = m.mno";
		psmt = con.prepareStatement(sql);
		rs = psmt.executeQuery();

		while(rs.next()) {
			BoardDTO dto = new BoardDTO();
			dto.setBno( rs.getString("bno") );
			dto.setBtitle( rs.getString("btitle") );
			dto.setMno( rs.getString("mno") );
			dto.setMid( rs.getString("mid") );
			dto.setBcnts( rs.getString("bcnts") );
			dto.setBdate( rs.getString("bdate") );
			list.add(dto);
		}//while

		rs.close();
		psmt.close();
		con.close();

		return list;
	}//list

	public int write(String title, String cnts, String id) throws SQLException {
		int successCount = 0;
		con = ds.getConnection();
		String sql = "insert into memberboard (bno, btitle, mno, bcnts, bdate)"
				+ " values (mno_seq.nextval, ?"
				+ ", (select mno from member where mid = ?), ?, sysdate)";
		psmt = con.prepareStatement(sql);
		psmt.setString(1, title);
		psmt.setString(2, id);
		psmt.setString(3, cnts);
		successCount = psmt.executeUpdate();
		
		psmt.close();
		con.close();
		
		return successCount;
	}//write

	public BoardDTO detail(String bno) throws SQLException {
		
		BoardDTO dto = new BoardDTO();
		con = ds.getConnection();
		String sql = "select mb.bno, mb.btitle, mb.mno, m.mid, mb.bcnts, mb.bdate"
				+ "	from memberboard mb, member m"
				+ "	where bno = ? and mb.mno = m.mno "; //bno = ? and mb.mno = m.mno -> and 앞뒤에 놓인 쿼리 순서 중요. 번호 먼저 찾는 게 효율이 좋다!!
		
		psmt = con.prepareStatement(sql);
		psmt.setString(1, bno);
		rs = psmt.executeQuery();
		rs.next();
		
		dto.setBno(rs.getString("bno"));
		dto.setBtitle(rs.getString("btitle"));
		dto.setMno(rs.getString("mno"));
		dto.setMid(rs.getString("mid"));
		dto.setBcnts(rs.getString("bcnts"));
		dto.setBdate(rs.getString("bdate"));
		
		rs.close();
		psmt.close();
		con.close();
		
		return dto;
	}//detail

	public int delete(String bno, String id) throws SQLException {
		int successCount = 0;
		con = ds.getConnection();
		
		String sql = "delete from memberboard where bno = ?"
				+ " and mno = (select mno from member where mid = ?)"; //본인이 쓴 글만 지울수 있도록 조치.
		psmt = con.prepareStatement(sql);
		psmt.setString(1, bno);
		psmt.setString(2, id);
		
		successCount = psmt.executeUpdate();
		
		psmt.close();
		con.close();
		
		return successCount;
	}//delete

	public int update (String no, String title, String cnts, String id) throws SQLException {
		
		int successCount = 0;
		con = ds.getConnection();
		
		String sql = "update memberboard set btitle = ?, bcnts = ? where bno = ?"
				+ " and mno = (select mno from member where mid = ?)"; //본인이 쓴 글만 수정할 수 있도록 조치.
		
		psmt = con.prepareStatement(sql);
		psmt.setString(1, title);
		psmt.setString(2, cnts);
		psmt.setString(3, no);
		psmt.setString(4, id);
		successCount = psmt.executeUpdate();
		
		psmt.close();
		con.close();

		return successCount;
	}//update
	
}//class


/*
 * create table memberboard(
 *	bno number(5,0) primary key
 *	, btitle varchar2(150)
 *	, mno number(5,0)
 *	, bcnts varchar2(1500)
 *	, bdate date
 *	);
 *
 * insert into memberboard values (MNO_SEQ.nextval, 'ttttt'
 * , (select max(mno) from member), 'cntscnts', sysdate);
 * commit;
 * 
 * select mb.bno, mb.btitle, mb.mno, m.mid, mb.bcnts, mb.bdate
 * from memberboard mb, member m
 * where mb.mno = m.mno;
 */









