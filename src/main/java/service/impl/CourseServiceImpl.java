package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import domain.Course;
import mapper.CourseMapper;
import mapper.GradeMapper;
import service.CourseService;
@Service
public class CourseServiceImpl implements CourseService{
	@Autowired
	private CourseMapper courseMapper;
	@Autowired
	private GradeMapper gradeMapper;
	

	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = {Exception.class})
	public int addCourse(Course course) {
		String cno = course.getCno();
		if(cno!=null && !"".equals(cno) && !courseMapper.isExistsCourseByCno(cno)) {
			int i = courseMapper.addCourse(course);
			return i;
		}
		return 0;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = {Exception.class})
	public int deleteCourseByCno(String cno) {
		if(cno!=null && !"".equals(cno) && courseMapper.isExistsCourseByCno(cno)) {
			int i = 0;
			if(gradeMapper.queryGradeByCno(cno).isEmpty()) {
				i = courseMapper.deleteCourseByCno(cno);
			} else {
				gradeMapper.deleteGradeByCno(cno);
				i = courseMapper.deleteCourseByCno(cno);
				
			}
			return i;
		}
		return 0;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = {Exception.class})
	public int updateCourse(String oldCno, Course newCourse) {
		if(oldCno!=null && !"".equals(oldCno) && courseMapper.isExistsCourseByCno(oldCno)) {		
			if(!oldCno.equals(newCourse.getCno())&&courseMapper.isExistsCourseByCno(newCourse.getCno())) {
				return 0;
			}
			int i = 0;
			if(gradeMapper.queryGradeByCno(oldCno).isEmpty()) {
				i = courseMapper.UpdateCourse(oldCno, newCourse);
			} else {
				gradeMapper.updateCourses(oldCno, newCourse);
				i = courseMapper.UpdateCourse(oldCno, newCourse);				
			}
			return i;
		}
		return 0;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = {Exception.class})
	public Course queryCourseByCno(String cno) {
		if(cno!=null && !"".equals(cno)) {
			return courseMapper.queryCourseByCno(cno);
		}
		return null;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = {Exception.class})
	public List<Course> queryAll() {		
		return courseMapper.queryAll();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = {Exception.class})
	public boolean isExistsCourseByCno(String cno) {
		if(cno!=null && !"".equals(cno)) {
			return courseMapper.isExistsCourseByCno(cno);
		}
		return false;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = {Exception.class})
	public List<Course> queryCourseByCname(String cname) {
		if(cname!=null) {
			return courseMapper.queryCourseByCname(cname);
		}
		return null;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = {Exception.class})
	public List<Course> queryCourseByCcredit(int ccredit) {
		return courseMapper.queryCourseByCcredit(ccredit);
	}

}
