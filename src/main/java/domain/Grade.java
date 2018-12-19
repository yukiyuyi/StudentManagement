package domain;

import java.io.Serializable;

public class Grade implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Student student;
	private Course course;
	private Double score;
	public Grade(Student student,Course course,Double score) {
		this.student=student;
		this.course=course;
		this.score=score;
	}
	public Grade(){
		this.student = new Student();
		this.course = new Course();
		this.score = 0.0;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
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
		Grade grade=(Grade)obj;
		if(!student.equals(grade.getStudent()) | 
				!course.equals(grade.getCourse()) | score!=grade.getScore()) {
			return false;
		}
		return true;
	}
	public String toString() {
		return student.getSno() + " " + course.getCno() + " " + score.toString();
	}
}
