package domain;

import java.io.Serializable;

public class Course implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String cno;
	String cname;
	int ccredit;
	public Course(String cno,String cname,int ccredit) {
		this.cno=cno;
		this.cname=cname;
		this.ccredit=ccredit;
	}
	public Course() {
		this.cno="";
		this.cname="";
		this.ccredit=-1;
	}
	public String getCno() {
		return cno;
	}
	public void setCno(String cno) {
		this.cno = cno;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getCcredit() {
		return ccredit;
	}
	public void setCcredit(int ccredit) {
		this.ccredit = ccredit;
	}
	public boolean equals(Object obj) {
		if(obj==null) {
			return false;
		}
		if(this==obj) {
			return true;
		}
		if(this.getClass()!=obj.getClass()) {
			return false;
		}
		Course course = (Course) obj;
		return cno.equals(course.getCno())&&cname.equals(course.getCname())
				&&ccredit==course.getCcredit();
	}
	public String toString() {
		return cno + " " + cname + " " + ccredit;
	}
}
