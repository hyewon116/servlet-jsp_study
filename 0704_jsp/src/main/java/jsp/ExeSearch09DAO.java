package jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ExeSearch09DAO {
	
	public ExeSearch09DAO () {
		try { 
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}//생성자 
	
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "c##scott";
	private final String PASSWORD = "tiger";

	public ArrayList<EmpDTO> nameSearch(String name) throws SQLException {
		
		String sql = "select empno, ename, job, mgr, hiredate, sal, comm, deptno "
				+ "from emp where ename like '%'||?||'%'";
		
		ArrayList<EmpDTO> list = new ArrayList<EmpDTO>();
		
		Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
		PreparedStatement psmt = con.prepareStatement(sql);
		psmt.setString(1, name); //해당 문자가 들어간 name을 찾기 위해 앞뒤로 % 붙이기 (like %s%)
		ResultSet rs = psmt.executeQuery();
		while(rs.next()) {
			EmpDTO dto = new EmpDTO();
			dto.setEmpno(rs.getString("empno"));
			dto.setEname(rs.getString("ename"));
			dto.setJob(rs.getString("job"));
			dto.setMgr(rs.getString("mgr"));
			dto.setHiredate(rs.getString("hiredate"));
			dto.setSal(rs.getString("sal"));
			dto.setComm(rs.getString("comm"));
			dto.setDeptno(rs.getString("deptno"));
			
			list.add(dto);
		}//while
				
		rs.close();
		psmt.close();
		con.close();
		
		return list;

	}//nameSearch
}//class
