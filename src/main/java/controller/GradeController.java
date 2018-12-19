package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import domain.Grade;
import service.GradeService;
@Controller
@RequestMapping("/grade")
public class GradeController {
	@Autowired
	private GradeService gradeService;
	@RequestMapping("/{path}")
	public String jump(@PathVariable("path")String path) {
		return "grade/" + path;
	}
	@RequestMapping("/add")
	public String add(String sno,String cno,Double score) {
		if(gradeService.addGrade(sno, cno, score)>0) {
			return "main";
		}
		return "error";
	}
	@RequestMapping("/delete")
	public String delete(String sno,String cno) {
		if(gradeService.deleteGradeBySnoCno(sno, cno)>0) {
			return "main";
		}
		return "error";
	}
	@RequestMapping("/update")
	public String update(String sno,String cno, Double score) {
		if(gradeService.updateGradeBySnoCno(sno, cno, score)>0) {
			return "main";
		}
		return "error";
	}
	@RequestMapping("query")
	public String query(String sno, String cno,Model model) {
		List<Grade> gradeList = new ArrayList<Grade>();
		if(sno!=null && !"".equals(sno)) {
			if(cno!=null && !"".equals(cno)) {
				Grade grade = gradeService.queryGradeBySnoCno(sno, cno);
				if(grade!=null) {
					gradeList.add(grade);
				}
			} else {
				gradeList = gradeService.queryGradeBySno(sno);
			}
		} else if(cno!=null && !"".equals(cno)) {
			gradeList=gradeService.queryGradeByCno(cno);
		}
		if(!gradeList.isEmpty()) {
			model.addAttribute("gradeList",gradeList);
			return "grade/list";
		}
		return "error";
	}
	@RequestMapping("queryAll")
	private String queryAll(Model model) {
		List<Grade> gradeList = this.gradeService.queryAll();
		model.addAttribute("gradeList", gradeList);
		return "grade/list";
	}
}
