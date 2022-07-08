package jsp;

public class BoardDTO { 
	//data transfer object : 데이터를 담아서 이동만 시켜주는 객체
	
	private String bno;
	private String btitle;
	private String bwriter;
	private String bcnts;
	private String bdate;
	
	public String getBno() {
		return bno;
	}
	public void setBno(String bno) {
		this.bno = bno;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBwriter() {
		return bwriter;
	}
	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}
	public String getBcnts() {
		return bcnts;
	}
	public void setBcnts(String bcnts) {
		this.bcnts = bcnts;
	}
	public String getBdate() {
		return bdate;
	}
	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
}
