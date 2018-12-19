package domain;

import java.io.Serializable;

public class Student implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String sno;
	private String sname;
	private String ssex;
	//构造函数
	public Student(String sno,String sname,String ssex) {
		this.sno=sno;
		this.sname=sname;
		this.ssex=ssex;
	}
	public Student() {
		this.sno="";
		this.sname="";
		this.ssex="";
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public void setSsex(String ssex) {
		this.ssex = ssex;
	}
	public String getSno() {
		return sno;
	}
	public String getSname() {
		return sname;
	}
	public String getSsex() {
		return ssex;
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
		Student student = (Student) obj;
		if(!sno.equals(student.getSno()) | !sname.equals(student.getSname()) | 
				!ssex.equals(student.getSsex())) {
			return false;
		}
		return true;
	}
	public String toString() {
		return sno + " " + sname + " " + ssex;
	}
}
