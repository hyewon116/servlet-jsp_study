package jsp;

import javax.servlet.http.HttpSession;

/*
 * Utility class : 작업 편의를 위한 class 
 * 공통 모듈 : 여러 class에서 호출해서 사용할 수 있는 공통 작업을 가진 class
 */

public class UtilMessage {
	
	public static void setSessionMsg(HttpSession session, String msg, String url, String urlName) {
		SuccessMsgDTO msgDTO = new SuccessMsgDTO();
		msgDTO.setMessage(msg);
		msgDTO.setUrl(url);
		msgDTO.setUrlName(urlName);
		session.setAttribute("msg_dto", msgDTO);
	}//setSessionMsg
}//class







