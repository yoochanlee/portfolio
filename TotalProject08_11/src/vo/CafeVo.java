package vo;

import java.util.List;

public class CafeVo {

	int c_idx;
	String c_name;
	String c_addr;
	String c_tel;
	String c_price;
	String c_park;
	String c_time;
	String c_hday;
	String c_uri;
	String c_map;
	String c_photo;
	String c_menu1;
	String c_menu2;
	String c_menu3;
	String c_menu4;
	String c_tag;
	

	ReviewVo ca_list;
	

	public ReviewVo getCa_list() {
		return ca_list;
	}

	public void setCa_list(ReviewVo ca_list) {
		this.ca_list = ca_list;
	}

	public CafeVo() {
		// TODO Auto-generated constructor stub
	}

	// insert
	public CafeVo(String c_name, String c_addr, String c_tel, String c_price, String c_park, String c_time,
			String c_hday, String c_uri, String c_map, String c_photo, String c_menu1, String c_menu2, String c_menu3,
			String c_menu4, String c_tag) {
		super();
		this.c_name = c_name;
		this.c_addr = c_addr;
		this.c_tel = c_tel;
		this.c_price = c_price;
		this.c_park = c_park;
		this.c_time = c_time;
		this.c_hday = c_hday;
		this.c_uri = c_uri;
		this.c_map = c_map;
		this.c_photo = c_photo;
		this.c_menu1 = c_menu1;
		this.c_menu2 = c_menu2;
		this.c_menu3 = c_menu3;
		this.c_menu4 = c_menu4;
		this.c_tag = c_tag;
	}

	public CafeVo(int c_idx, String c_name, String c_addr, String c_tel, String c_price, String c_park, String c_time,
			String c_hday, String c_uri, String c_map, String c_photo, String c_menu1, String c_menu2, String c_menu3,
			String c_menu4, String c_tag) {
		super();
		this.c_idx = c_idx;
		this.c_name = c_name;
		this.c_addr = c_addr;
		this.c_tel = c_tel;
		this.c_price = c_price;
		this.c_park = c_park;
		this.c_time = c_time;
		this.c_hday = c_hday;
		this.c_uri = c_uri;
		this.c_map = c_map;
		this.c_photo = c_photo;
		this.c_menu1 = c_menu1;
		this.c_menu2 = c_menu2;
		this.c_menu3 = c_menu3;
		this.c_menu4 = c_menu4;
		this.c_tag = c_tag;
	}

	public int getC_idx() {
		return c_idx;
	}

	public void setC_idx(int c_idx) {
		this.c_idx = c_idx;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getC_addr() {
		return c_addr;
	}

	public void setC_addr(String c_addr) {
		this.c_addr = c_addr;
	}

	public String getC_tel() {
		return c_tel;
	}

	public void setC_tel(String c_tel) {
		this.c_tel = c_tel;
	}

	public String getC_price() {
		return c_price;
	}

	public void setC_price(String c_price) {
		this.c_price = c_price;
	}

	public String getC_park() {
		return c_park;
	}

	public void setC_park(String c_park) {
		this.c_park = c_park;
	}

	public String getC_time() {
		return c_time;
	}

	public void setC_time(String c_time) {
		this.c_time = c_time;
	}

	public String getC_hday() {
		return c_hday;
	}

	public void setC_hday(String c_hday) {
		this.c_hday = c_hday;
	}

	public String getC_uri() {
		return c_uri;
	}

	public void setC_uri(String c_uri) {
		this.c_uri = c_uri;
	}

	public String getC_map() {
		return c_map;
	}

	public void setC_map(String c_map) {
		this.c_map = c_map;
	}

	public String getC_photo() {
		return c_photo;
	}

	public void setC_photo(String c_photo) {
		this.c_photo = c_photo;
	}

	public String getC_menu1() {
		return c_menu1;
	}

	public void setC_menu1(String c_menu1) {
		this.c_menu1 = c_menu1;
	}

	public String getC_menu2() {
		return c_menu2;
	}

	public void setC_menu2(String c_menu2) {
		this.c_menu2 = c_menu2;
	}

	public String getC_menu3() {
		return c_menu3;
	}

	public void setC_menu3(String c_menu3) {
		this.c_menu3 = c_menu3;
	}

	public String getC_menu4() {
		return c_menu4;
	}

	public void setC_menu4(String c_menu4) {
		this.c_menu4 = c_menu4;
	}

	public String getC_tag() {
		return c_tag;
	}

	public void setC_tag(String c_tag) {
		this.c_tag = c_tag;
	}

}
