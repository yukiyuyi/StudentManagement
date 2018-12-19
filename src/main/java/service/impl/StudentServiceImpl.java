package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.lang.Override;
import java.util.List;

import domain.Student;
import mapper.GradeMapper;
import mapper.StudentMapper;
import service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentMapper studentMapper;
	@Autowired
	private GradeMapper gradeMapper;
	//PROPAGATION_REQUIRED:如果当前没有事务，就新建一个事务，如果已经存在一个事务中，加入到这个事务中。这是最常见的选择。
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor = {Exception.class})
	public int addStudent(Student student) {
		String sno = student.getSno();
		if(sno!=null && !"".equals(sno) && !studentMapper.isExistsStudentBySno(sno)) {
			System.out.println(studentMapper.isExistsStudentBySno(sno));
			int i=studentMapper.addStudent(student);
			return i;
		}
		return 0;
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
	public int deleteStudentBySno(String sno) {
		if(sno!=null && !"".equals(sno)&&studentMapper.isExistsStudentBySno(sno)) {
			int i=0;
			if(gradeMapper.queryGradeBySno(sno).isEmpty()) {
				i = studentMapper.deleteStudentBySno(sno);
			} else {
				gradeMapper.deleteGradeBySno(sno);
				i = studentMapper.deleteStudentBySno(sno);
				
			}
			return i;
		}
		return 0;
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = {Exception.class})
	public int updateStudent(String oldSno, Student newStudent) {
		if(oldSno!=null && !"".equals(oldSno) && studentMapper.isExistsStudentBySno(oldSno)) {
			if(!oldSno.equals(newStudent.getSno())&&studentMapper.isExistsStudentBySno(newStudent.getSno())) {
				return 0;
			}
			int i=0;
			if(gradeMapper.queryGradeBySno(oldSno).isEmpty()) {
				i = studentMapper.updateStudent(oldSno, newStudent);
			} else {
				 gradeMapper.updateStudents(oldSno, newStudent);
				 i = studentMapper.updateStudent(oldSno, newStudent);				 
			}
			return i;
		}
		return 0;
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = {Exception.class})
	public Student queryStudentBySno(String sno) {
		if(sno!=null && !"".equals(sno)) {
			return studentMapper.queryStudentBySno(sno);
		}
		return null;
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = {Exception.class})
	public List<Student> queryAll() {
		return studentMapper.queryAll();
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = {Exception.class})
	public boolean isExistsCourseBySno(String sno) {
		if(sno!=null&&!"".equals(sno)) {
			return studentMapper.isExistsStudentBySno(sno);
		}
		return false;
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = {Exception.class})
	public List<Student> queryStudentBySsex(String ssex) {
		if(ssex!=null && !"".equals(ssex)) {
			return studentMapper.queryStudentBySsex(ssex);
		}
		return null;
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = {Exception.class})
	public List<Student> queryStudentBySname(String sname) {
		if(sname!=null && !"".equals(sname)) {
			return studentMapper.queryStudentBySname(sname);
		}
		return null;
	}
}
