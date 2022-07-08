package jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FB17DAO {
	
	public FB17DAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}//constructor (return 타입 없음)
		
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe"; 
	private final String USER = "c##scott";
	private final String PASSWORD = "tiger";
	
	private Connection con;
	private PreparedStatement psmt;
	private ResultSet rs;
	
	public ArrayList<BoardDTO> list() throws SQLException { //받아오는 인자 없이 freeboard의 모든 내용을 담음.-> list 객체 필요.
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>(); 
		String sql = "select bno, btitle, bwriter, bcnts, bdate from freeboard order by bno desc"; //조건 없이 내용 모두 가져오기
		con = DriverManager.getConnection(URL, USER, PASSWORD);
		
		psmt = con.prepareStatement(sql); //sql문에 ?가 없어서 setstring은 안해줘도 됨.
		rs = psmt.executeQuery();
		while( rs.next() ) {
			BoardDTO dto = new BoardDTO();
			dto.setBno( rs.getString("bno") );
			dto.setBtitle( rs.getString("btitle") );
			dto.setBwriter( rs.getString("bwriter") );
			dto.setBcnts( rs.getString("bcnts") );
			dto.setBdate( rs.getString("bdate") );
			list.add(dto); //여기서 dto 1개 = row 한 줄 => list에 한 줄씩 담김. 
		}//while
		rs.close();
		psmt.close();
		con.close();
		
		return list;
	}//list
	
	public int write(BoardDTO dto) throws SQLException {
		int successCount = 0;
		con = DriverManager.getConnection(URL, USER, PASSWORD);
		String sql = "insert into freeboard (bno, btitle, bwriter, bcnts, bdate)"
				+ " values (mno_seq.nextval, ?, ?, ?, sysdate)";
		psmt = con.prepareStatement(sql);
		psmt.setString(1, dto.getBtitle()); //FBList17에서 dto에 담았던 내용들을 psmt로 세팅.(dbms의 freeboard 테이블에 전달)
		psmt.setString(2, dto.getBwriter());
		psmt.setString(3, dto.getBcnts());
		successCount = psmt.executeUpdate();
		psmt.close();
		con.close();

		return successCount; //FBList17로 int값(insert의 성공 건수) 리턴.
	}//write
	
	public BoardDTO detail(String no) throws SQLException{
		BoardDTO dto = new BoardDTO();
		con = DriverManager.getConnection(URL, USER, PASSWORD);
		String sql = "select bno, btitle, bwriter, bcnts, bdate from freeboard "
				+ " where bno=?";
		psmt = con.prepareStatement(sql);
		psmt.setString(1, no); //인자로 받아온 no 세팅
		rs = psmt.executeQuery();
		rs.next(); //beforefirst에서 first로 이동. (결과가 단 한건이어도 이 과정 필요) -> 안 해주면 칼럼행에 있는 거임.
		
		dto.setBno( rs.getString("bno") );
		dto.setBtitle( rs.getString("btitle") );
		dto.setBwriter( rs.getString("bwriter") );
		dto.setBcnts( rs.getString("bcnts") );
		dto.setBdate( rs.getString("bdate") );
		
		rs.close();
		psmt.close();
		con.close();
		
		return dto; //dto를 도출해서 FBList17로 복귀
	}//detail

	public int delete(String no) throws SQLException {
		int successCount = 0;
		con = DriverManager.getConnection(URL, USER, PASSWORD);
		String sql = "delete from freeboard where bno=?";
		psmt = con.prepareStatement(sql);
		psmt.setString(1, no);
		successCount = psmt.executeUpdate();
		
		psmt.close();
		con.close();
		
		return successCount;
	}

	public int update(String no, String title, String writer, String cnts) throws SQLException {
		int successCount = 0;
		con = DriverManager.getConnection(URL, USER, PASSWORD);
		String sql = "update freeboard set btitle = ?, bwriter = ?, bcnts = ? where bno = ?";
		psmt = con.prepareStatement(sql);
		psmt.setString(1, title);
		psmt.setString(2, writer);
		psmt.setString(3, cnts);
		psmt.setString(4, no);
		successCount = psmt.executeUpdate();
		
		psmt.close();
		con.close();
	
		return successCount;
	}//update
}//class


















