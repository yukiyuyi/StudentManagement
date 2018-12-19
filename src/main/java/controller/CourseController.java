package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import domain.Course;
import mapper.CourseMapper;
import service.CourseService;

@Controller
@RequestMapping("/course")
public class CourseController {
	@Autowired
	private CourseService courseService;
	@RequestMapping("/{path}")
	public String jump(@PathVariable("path")String path) {
		return "course/" + path;
	}
	@RequestMapping("/add")
	public String add(Course course) {
		if(courseService.addCourse(course)>0) {
			return "main";
		}
		return "error";
	}
	@RequestMapping("/delete")
	public String delete(String cno) {
		if(courseService.deleteCourseByCno(cno)>0) {
			return "main";
		}
		return "error";
	}
	@RequestMapping("/update")
	public String update(String oldCno,Course newCourse) {
		if(courseService.updateCourse(oldCno, newCourse)>0) {
			return "main";
		}
		return "error";
	}
	@RequestMapping("query")
	public String query(String cno,Model model) {
		Course course = courseService.queryCourseByCno(cno);
		if(course!=null) {
			List<Course> courseList = new ArrayList<Course>();
			courseList.add(course);
			model.addAttribute("courseList",courseList);
			return "course/list";
		}
		return "error";
	}
	@RequestMapping("queryAll")
	private String queryAll(Model model) {
		List<Course> courseList = this.courseService.queryAll();
		model.addAttribute("courseList", courseList);
		return "course/list";
	}
}
