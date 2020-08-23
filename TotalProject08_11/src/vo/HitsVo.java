package vo;

public class HitsVo {
int s_idx;
int s_num;
int c_idx;
int count;



public int getCount() {
	return count;
}
public void setCount(int count) {
	this.count = count;
}
public HitsVo() {
	// TODO Auto-generated constructor stub
}


public HitsVo(int c_idx) {
	super();
	this.c_idx = c_idx;
}
public int getS_idx() {
	return s_idx;
}
public void setS_idx(int s_idx) {
	this.s_idx = s_idx;
}
public int getS_num() {
	return s_num;
}
public void setS_num(int s_num) {
	this.s_num = s_num;
}
public int getC_idx() {
	return c_idx;
}
public void setC_idx(int c_idx) {
	this.c_idx = c_idx;
}

}
