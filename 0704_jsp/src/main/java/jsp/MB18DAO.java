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

public class MB18DAO {
	
	Context initContext;
	Context envContext;
	DataSource ds;
	Connection con;
	PreparedStatement psmt;
	ResultSet rs;
	
	public MB18DAO () {
		try {
			initContext = new InitialContext(); //InitialContext = 톰캣 실행환경 
			envContext = (Context) initContext.lookup("java:/comp/env"); //lookup : 톰캣 실행환경의 변수들을 찾는 검색 메소드, java:/comp/env : 변수명
			ds = (DataSource) envContext.lookup("jdbc/myoracle"); //톰캣 소스를 자바의 기본 소스로 변경? jdbc/myoracle : context.xml에서 설정해준 이름
			//context, InitialContext  -> javax.naming import 
		
		} catch (NamingException e) {
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
			dto.setBno(rs.getString("bno"));
			dto.setBtitle(rs.getString("btitle"));
			dto.setMno(rs.getString("mno"));
			dto.setMid(rs.getString("mid"));
			dto.setBcnts(rs.getString("bcnts"));
			dto.setBdate(rs.getString("bdate"));
			list.add(dto);
		}//while
		
		rs.close();
		psmt.close();
		con.close();
			
		return list;
	}//list
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









