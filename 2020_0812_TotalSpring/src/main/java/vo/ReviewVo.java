package vo;

public class ReviewVo {
	 int r_idx;       
	 String r_cot;        
	 int   m_idx;        
	 int   c_idx;       
	 int   r_grade;      
	 String   r_pwd;        
	 String   r_ip;          
	 String   r_regdate;
	 String m_name;
	 String m_photo;
	 int bad;
	 int notbad;
	 int soso;
	 int likes;
	 int god;
	 int total;
	 String image;
	double avg;
	
	 public String getImage() {
		 switch (r_grade) {
			case 1 : image="bad";  break;
			case 2 : image="notBad";  break;
			case 3 : image="soso";  break;
			case 4 : image="like";  break;
			case 5 : image="god";  break;

			}
		return image;
	}





	public void setImage(String image) {
		
		
		this.image = image;
	}

	 




	public double getAvg() {
		return avg;
	}





	public void setAvg(double avg) {
		this.avg = avg;
	}





	public int getTotal() {
		return total;
	}





	public void setTotal(int total) {
		this.total = total;
	}





	public int getBad() {
		return bad;
	}





	public void setBad(int bad) {
		this.bad = bad;
	}





	public int getNotbad() {
		return notbad;
	}





	public void setNotbad(int notbad) {
		this.notbad = notbad;
	}





	public int getSoso() {
		return soso;
	}





	public void setSoso(int soso) {
		this.soso = soso;
	}





	public int getLikes() {
		return likes;
	}





	public void setLikes(int likes) {
		this.likes = likes;
	}





	public int getGod() {
		return god;
	}





	public void setGod(int god) {
		this.god = god;
	}





	public ReviewVo() {
		// TODO Auto-generated constructor stub
	}
	
	
	 
	
	 
	public ReviewVo(int r_idx, String r_cot, int r_grade, String r_pwd) {
		super();
		this.r_idx = r_idx;
		this.r_cot = r_cot;
		this.r_grade = r_grade;
		this.r_pwd = r_pwd;
	}





	public ReviewVo(String r_cot, int m_idx, int c_idx, int r_grade, String r_pwd, String r_ip) {
		super();
		this.r_cot = r_cot;
		this.m_idx = m_idx;
		this.c_idx = c_idx;
		this.r_grade = r_grade;
		this.r_pwd = r_pwd;
		this.r_ip = r_ip;
	}


	
	

	public String getM_name() {
		return m_name;
	}



	public void setM_name(String m_name) {
		this.m_name = m_name;
	}



	public String getM_photo() {
		return m_photo;
	}



	public void setM_photo(String m_photo) {
		this.m_photo = m_photo;
	}



	public int getR_idx() {
		return r_idx;
	}
	public void setR_idx(int r_idx) {
		this.r_idx = r_idx;
	}
	public String getR_cot() {
		return r_cot;
	}
	public void setR_cot(String r_cot) {
		this.r_cot = r_cot;
	}
	public int getM_idx() {
		return m_idx;
	}
	public void setM_idx(int m_idx) {
		this.m_idx = m_idx;
	}
	public int getC_idx() {
		return c_idx;
	}
	public void setC_idx(int c_idx) {
		this.c_idx = c_idx;
	}
	public int getR_grade() {
		return r_grade;
	}
	public void setR_grade(int r_grade) {
		this.r_grade = r_grade;
	}
	public String getR_pwd() {
		return r_pwd;
	}
	public void setR_pwd(String r_pwd) {
		this.r_pwd = r_pwd;
	}
	public String getR_ip() {
		return r_ip;
	}
	public void setR_ip(String r_ip) {
		this.r_ip = r_ip;
	}
	public String getR_regdate() {
		return r_regdate;
	}
	public void setR_regdate(String r_regdate) {
		this.r_regdate = r_regdate;
	}    
	
	
}
