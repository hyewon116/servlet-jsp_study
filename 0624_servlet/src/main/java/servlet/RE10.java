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

@WebServlet("/RE10")
public class RE10 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RE10() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			//JDBC 1. 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch( ClassNotFoundException e ) {
			e.printStackTrace();
		}
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
//		String url = "jdbc:oracle:thin:@192.168.0.38:1521:xe";
		String user = "c##scott";
		String password = "tiger";
		String sql = "select empno, ename, job, mgr, hiredate, sal, comm, deptno from emp";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			//JDBC 2. Connection : url user password
			con = DriverManager.getConnection(url, user, password);
			//JDBC 3. sql 전송
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			//JDBC 4. 결과 확인
			PrintWriter out = response.getWriter();
			out.print("<table border=1><tbody>");
			while(rs.next()) {
				out.print("<tr>");
				out.print("<td>" + rs.getString("empno") + "</td>");
				out.print("<td>" + rs.getString("ename") + "</td>");
				out.print("<td>" + rs.getString("job") + "</td>");
				out.print("<td>" + rs.getString("mgr") + "</td>");
				out.print("<td>" + rs.getString("hiredate") + "</td>");
				out.print("<td>" + rs.getString("sal") + "</td>");
				out.print("<td>" + rs.getString("comm") + "</td>");
				out.print("<td>" + rs.getString("deptno") + "</td>");
				out.print("</tr>");
			}//while
			out.print("</tbody></table>");
			out.close();
		} catch( SQLException e ) {
			e.printStackTrace();
		} finally {
			try {
				//JDBC 5. close
				rs.close();
				stmt.close();
				con.close();
			} catch( SQLException e ) {
				e.printStackTrace();
			}
		}//finally

	}//doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}//class