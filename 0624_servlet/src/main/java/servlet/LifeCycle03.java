package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * Servlet Life Cycle : 서블릿이 생성, 실행, 파괴되는 과정.
 * 생성자 -> init() -> service() -> destroy()
 * init() : 서비스 시작 전에 수행할 내용이 있다면 init()에서 처리.
 * service()가 실제로 업무를 처리하는 메소드.
 * service()가 전송 방식에 따라 분할된 것이 doGet/doPost 이다.
 * destroy() : 사용되지 않거나, 메모리가 부족할 때, 서블릿을 종료시키는 메소드.
 *             jvm의 garbage collector가 수행함.
 */
@WebServlet("/LifeCycle03")
public class LifeCycle03 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LifeCycle03() {
        super();
        System.out.println("1. 생성자 수행");
    }

	public void init() throws ServletException {
        System.out.println("2. init 수행");
	}

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("3. service 수행");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet 수행");
	}

	public void destroy() {
        System.out.println("4. destroy 수행");
	}

}//class