package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/JDBCTest08")
public class JDBCTest08 extends HttpServlet {
	private static final long serialVersionUID = 1L;
		
    public JDBCTest08() {
        super();
    }
    	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.print("<table><tbody>");
		//1. driver(오라클 접속 모듈) loading
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "c##scott";
		String password = "tiger";
		String sql = "select empno, ename, job, sal, deptno from emp";
		Connection con = null; 
		Statement stmt = null;
		ResultSet rs = null;
		try {
			//2. connection 연결(url, user, password)
			con = DriverManager.getConnection(url, user, password);
			//3. sql 전송
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			//4. 결과 확인
			while(rs.next()) {
				out.print("<tr>");
				out.print("<td>" + rs.getString("empno") + "</td>");
				out.print("<td>" + rs.getString("ename") + "</td>");
				out.print("<td>" + rs.getString("job") + "</td>");
				out.print("<td>" + rs.getString("sal") + "</td>");
				out.print("<td>" + rs.getString("deptno") + "</td>");
				out.print("</tr>");
//				System.out.println(rs.getString("empno"));
//				System.out.println(rs.getString("ename"));
//				System.out.println(rs.getString("job"));
//				System.out.println(rs.getString("sal"));
//				System.out.println(rs.getString("deptno"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//5. close
				rs.close();
				stmt.close();
				con.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}//finally
		out.print("</tbody></table>");
		out.close();
	}//doGet
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
