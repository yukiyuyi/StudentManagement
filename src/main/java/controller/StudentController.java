package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import domain.Student;
import service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService studentService;
	@RequestMapping("/{path}")
	public String jump(@PathVariable("path")String path) {
		return "student/" + path;
	}
	@RequestMapping("/add")
	public String add(Student student) {
		if(studentService.addStudent(student)>0) {
			return "main";
		}
		return "error";
	}
	@RequestMapping("/delete")
	public String delete(String sno) {
		if(studentService.deleteStudentBySno(sno)>0) {
			return "main";
		}
		return "error";
	}
	@RequestMapping("/update")
	public String update(String oldSno,Student newStudent) {
		if(studentService.updateStudent(oldSno, newStudent)>0) {
			return "main";
		}
		return "error";
	}
	@RequestMapping("query")
	public String query(String sno,Model model) {
		Student student = studentService.queryStudentBySno(sno);
		if(student!=null) {
			List<Student> studentList = new ArrayList<Student>();
			studentList.add(student);
			model.addAttribute("studentList",studentList);
			return "student/list";
		}
		return "error";
	}
	@RequestMapping("queryAll")
	private String queryAll(Model model) {
		List<Student> studentList = this.studentService.queryAll();
		model.addAttribute("studentList", studentList);
		return "student/list";
	}
}
