package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import domain.Course;
import domain.Grade;
import domain.Student;
import mapper.CourseMapper;
import mapper.GradeMapper;
import mapper.StudentMapper;
import service.GradeService;
@Service
public class GradeServiceImpl implements GradeService{
	@Autowired
	private StudentMapper studentMapper;
	@Autowired
	private CourseMapper courseMapper;
	@Autowired
	private GradeMapper gradeMapper;
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor = {Exception.class})
	public int addGrade(String sno,String cno,Double score) {
		if(sno!=null && !"".equals(sno) && cno!=null && !"".equals(cno)
				&& !gradeMapper.isExistsGradeBySnoCno(sno, cno)) {
			Student student = studentMapper.queryStudentBySno(sno);
			Course course = courseMapper.queryCourseByCno(cno);
			if(student != null && course != null) {
				return gradeMapper.addGrade(new Grade(student,course,score));
			}
		}
		return 0;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor = {Exception.class})
	public int deleteGradeBySnoCno(String sno, String cno) {
		if(sno!=null && !"".equals(sno) && cno!=null && !"".equals(cno)) {
			if(gradeMapper.isExistsGradeBySnoCno(sno, cno)) {
				return gradeMapper.deleteGradeBySnoCno(sno, cno);
			}
		}
		return 0;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor = {Exception.class})
	public int deleteGradeBySno(String sno) {
		if(sno!=null && !"".equals(sno)) {
			if(gradeMapper.isExistsGradeBySno(sno)) {
				return gradeMapper.deleteGradeBySno(sno);
			}
		}
		return 0;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor = {Exception.class})
	public int deleteGradeByCno(String cno) {
		if(cno!=null && !"".equals(cno)) {
			if(gradeMapper.isExistsGradeByCno(cno)) {
				return gradeMapper.deleteGradeByCno(cno);
			}
		}
		return 0;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor = {Exception.class})
	public int updateGradeBySnoCno(String sno, String cno, Double score) {
		if(sno!=null && !"".equals(sno) && cno!=null && !"".equals(cno)) {
			if(gradeMapper.isExistsGradeBySnoCno(sno, cno)) {
				return gradeMapper.updateGradeBySnoCno(sno, cno, score);
			}
		}
		return 0;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor = {Exception.class})
	public int updateStudents(String oldSno, Student newStudent) {
		if(oldSno!=null && !"".equals(oldSno)) {
			if(gradeMapper.isExistsGradeBySno(oldSno)) {
				return gradeMapper.updateStudents(oldSno, newStudent);
			}
		}
		return 0;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor = {Exception.class})
	public int updateCourses(String oldCno, Course newCourse) {
		if(oldCno!=null && !"".equals(oldCno)) {
			if(gradeMapper.isExistsGradeByCno(oldCno)) {
				gradeMapper.updateCourses(oldCno, newCourse);
			}
		}
		return 0;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor = {Exception.class})
	public List<Grade> queryAll() {
		return gradeMapper.quryAll();
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor = {Exception.class})
	public Grade queryGradeBySnoCno(String sno, String cno) {
		if(sno!=null && !"".equals(sno) && cno!=null && !"".equals(cno)) {
			return gradeMapper.queryGradeByCnoSno(cno, sno);
		}
		return null;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor = {Exception.class})
	public List<Grade> queryGradeByCno(String cno) {
		if(cno!=null && !"".equals(cno)) {
			return gradeMapper.queryGradeByCno(cno);
		}
		return null;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor = {Exception.class})
	public List<Grade> queryGradeBySno(String sno) {
		if(sno!=null && !"".equals(sno)) {
			return gradeMapper.queryGradeBySno(sno);
		}
		return null;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor = {Exception.class})
	public boolean isExistsGradeBySnoCno(String sno, String cno) {
		if(sno!=null && !"".equals(sno) && cno!=null && !"".equals(cno)) {
			return gradeMapper.isExistsGradeBySnoCno(sno, cno);
		}
		return false;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor = {Exception.class})
	public boolean isExistsGradeBySno(String sno) {
		if(sno!=null && !"".equals(sno)) {
			return gradeMapper.isExistsGradeBySno(sno);
		}
		return false;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor = {Exception.class})
	public boolean isExistsGradeByCno(String cno) {
		if(cno!=null && !"".equals(cno)) {
			return gradeMapper.isExistsGradeByCno(cno);
		}
		return false;
	}
}
