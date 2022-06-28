package servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SelectEmp11DAO {
	
	private Connection con; //private 선언 필요 (왜?)
	private Statement stmt;
	private ResultSet rs;
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe"; //final 변수 선언=대문자로 해야 함. final : 변경 불가
	private final String USER = "c##scott";
	private final String PASSWORD = "tiger";
	
	public SelectEmp11DAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
	}//constructor 
		
	public ArrayList<SelectEmp11DTO> selectEmp() {
		
		ArrayList<SelectEmp11DTO> list = new ArrayList<SelectEmp11DTO>();
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = con.createStatement();
			String sql = "select empno, ename, job, mgr, hiredate, sal, comm, deptno from emp";
			rs = stmt.executeQuery(sql);
			//DTO : data transfer object = data class
			// == DO : data object 
			// == Bean : data bean	
			while(rs.next()) {
				SelectEmp11DTO dto = new SelectEmp11DTO();
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
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}//finally
		
		return list;
	}//selectEmp
	
}//class
