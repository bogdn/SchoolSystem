package pl.edu.agh.school;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import pl.edu.agh.school.models.Class;
import pl.edu.agh.school.models.Mark;
import pl.edu.agh.school.models.Student;
import pl.edu.agh.school.models.Subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pl.edu.agh.school.dao.ClassDAO;
import pl.edu.agh.school.dao.MarkDAO;
import pl.edu.agh.school.dao.StudentDAO;
import pl.edu.agh.school.dao.SubjectDAO;

@Controller
public class GradeBookController {
	@Autowired
	private ClassDAO classDAO;
	@Autowired
	private SubjectDAO subjectDAO;
	@Autowired
	private StudentDAO studentDAO;
	@Autowired MarkDAO markDAO;
	
	@RequestMapping(value = "/listClasses", method=RequestMethod.GET)
	public String listAllClasses(Model model) {
		
		model.addAttribute("allClasses", classDAO.findAll());
		return "listClasses";
		
	}
	
	@RequestMapping(value="/subjectsOfClass", method = RequestMethod.GET)
	public String listSubjectsOfClass(Model model, HttpServletRequest request) {
		int classID = Integer.parseInt(request.getParameter("id"));
		model.addAttribute("sClass", classDAO.getClass(classID));
		model.addAttribute("subjects", subjectDAO.getSubjectsFromClass(classID));
		return "subjectsOfClass";
		
	}
	
	@RequestMapping(value = "/listStudents", method=RequestMethod.GET)
	public String listStudents(Model model, HttpServletRequest request) {
		int classID = Integer.parseInt(request.getParameter("class_id"));
		Class testClass = classDAO.getClass(classID);
		List<Student> students = testClass.getStudent();
		model.addAttribute("students", students);
		int subjectId = Integer.parseInt(request.getParameter("subject_id")); 
		model.addAttribute("subject_id", subjectId);
		
		return "listStudents";
	}
	@Transactional
	@RequestMapping(value = "/studentMarks", method = RequestMethod.GET)
	public String getStudentMarks(Model model, HttpServletRequest request) {
		int studentId = Integer.parseInt(request.getParameter("id"));
		model.addAttribute("student_id", studentId);
		int subjectId = Integer.parseInt(request.getParameter("subject_id"));
		model.addAttribute("subject_id", subjectId);
		model.addAttribute("marks",markDAO.getStudentMarks(studentId, subjectId));
		return "studentMarks";
	}
	
	@RequestMapping(value = "/addMark", method = RequestMethod.GET)
	public String addMark(Model model, HttpServletRequest request) {
		
		int studentId = Integer.parseInt(request.getParameter("student_id"));
		model.addAttribute("student_id", studentId);
		int subjectId = Integer.parseInt(request.getParameter("subject_id"));
		model.addAttribute("subject_id", subjectId);
		Mark mark = new Mark();
		
		model.addAttribute("mark", mark);
		return "addMark";
	}
	
	@RequestMapping(value = "/addMark", method = RequestMethod.POST)
	public String addMarkPOST( @Valid Mark mark, Model model,  HttpServletRequest request, RedirectAttributes redirectAttributes) {
		
		int studentId = Integer.parseInt(request.getParameter("student_id"));
		int subjectId = Integer.parseInt(request.getParameter("subject_id"));
		Student student = studentDAO.getStudent(studentId);
		Subject subject = subjectDAO.getSubject(subjectId);
		mark.setStudent(student);
		mark.setSubject(subject);
		markDAO.saveMark(mark);
		redirectAttributes.addFlashAttribute("message", "Dodano nową ocenę");
		return "redirect:/studentMarks?id="+studentId+"&subject_id="+subjectId;
	}
	
	@RequestMapping(value = "/deleteMark", method = RequestMethod.GET)
	public String deleteMark(Model model, @RequestParam("mark_id") String markId, @RequestParam("id") String studentId,
			@RequestParam("subject_id") String subjectId, RedirectAttributes attributes) {
		attributes.addFlashAttribute("message", "usunięto 1 ocenę");
		System.out.println(markId);
		int markID = Integer.parseInt(markId);
		Mark mark = markDAO.getMark(markID);
		System.out.println(mark);
		markDAO.deleteMark(mark);
		
		return "redirect:/studentMarks?id="+studentId+"&subject_id="+subjectId;
	}
	
	@RequestMapping(value = "/editMark", method = RequestMethod.GET)
	public String editMark(Model model, @RequestParam("mark_id") String markId, 
			@RequestParam("student_id") String studentId, @RequestParam("subject_id") String subjectId) {
		int markID = Integer.parseInt(markId);
		model.addAttribute("student", studentDAO.getStudent(Integer.parseInt(studentId)));
		model.addAttribute("student_id", studentId);
		model.addAttribute("subject_id", subjectId);
		Mark mark = markDAO.getMark(markID);
		model.addAttribute("mark", mark);
		return "editMark";
	}
	
	@RequestMapping(value = "/editMark", method = RequestMethod.POST)
	public String editMarkPost(Model model, @Valid Mark mark,
			@RequestParam("subject_id") int subjectId, @RequestParam("student_id") int studentId,
			RedirectAttributes attributes) {
			
			Student student = studentDAO.getStudent(studentId);
			Subject subject = subjectDAO.getSubject(subjectId);
			mark.setStudent(student);
			mark.setSubject(subject);
			attributes.addFlashAttribute("message", "Zmodyfikowano ocenę");
		
		
			markDAO.updateMark(mark);
		
		
		return "redirect:/studentMarks?id="+studentId + "&subject_id=" + subjectId;
	}
	
	
	
	
	

}
