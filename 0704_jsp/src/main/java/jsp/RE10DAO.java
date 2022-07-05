package jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RE10DAO {
	
	public RE10DAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}//생성자(constructor)
	
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "c##scott";
	private String password = "tiger";
	
	public ArrayList<EmpDTO> nameLikeSearch(String enm) throws SQLException {

		ArrayList<EmpDTO> list = new ArrayList<EmpDTO>();		
		Connection con = DriverManager.getConnection(url, user, password);
		
		String sql = "select empno, ename, job, mgr, hiredate, sal, comm"
				+ ", deptno from emp where ename like '%'||?||'%'"; 
		PreparedStatement psmt = con.prepareStatement(sql);
		psmt.setString(1, enm.toUpperCase()); //toUpperCase() = 소문자로 입력해도 검색되도록 설정. 
		ResultSet rs = psmt.executeQuery(); 
		while( rs.next() ) {
			EmpDTO dto = new EmpDTO();
			dto.setEmpno( rs.getString("empno") );
			dto.setEname( rs.getString("ename") );
			dto.setJob( rs.getString("job") );
			dto.setMgr( rs.getString("mgr") );
			dto.setHiredate( rs.getString("hiredate") );
			dto.setSal( rs.getString("sal") );
			dto.setComm( rs.getString("comm") );
			dto.setDeptno( rs.getString("deptno") );
			
			list.add(dto);
		}//while
		
		rs.close();
		psmt.close();
		con.close();
		
		return list;
	}

}//class
