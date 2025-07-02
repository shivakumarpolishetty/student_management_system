package sp.db.controller;

import java.util.List;

import javax.lang.model.element.ModuleElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import sp.db.StundetdbApplication;
import sp.db.entity.Student;
import sp.db.service.stdService;


@Controller
public class htmlController {

	
	@Autowired
	private stdService stdservice;
	
	
	@ModelAttribute
	public void addprojectname(Model model)
	{
		model.addAttribute("project", "STUDENT MANAGEMENT SYSTEM");
	}
	
	
	@GetMapping("/")
	public String startingpage()
	{
		
		return "redirect:/home";
		
	}
	@GetMapping("/home")
	public String home(Model model)
	{
		String name = "STUDENT MANAGEMENT SYSTEM";
		
		List<Student>allstudents = stdservice.getallstudents();
		model.addAttribute("project", name);
		model.addAttribute("student",new Student());
		
		model.addAttribute("students", allstudents);
		
		return "home";
	}
	
	@PostMapping("/add")
	public String addstudent(@ModelAttribute Student student,Model model)
	{
		
		
		if(stdservice.findbyid(student.getId()))
		{
			
			model.addAttribute("response", "this is duplicate ID");
			model.addAttribute("color", "red");
			model.addAttribute("student", student);
			model.addAttribute("students", stdservice.getallstudents());
			return "home";
		}
		
		
		
		stdservice.addstd(student);
		
		String name = student.getName();
		int id = student.getId();
		String response = "student name with " +name+ " and id " +id +"added success fully";
		
		
		
		model.addAttribute("students",stdservice.getallstudents());
		model.addAttribute("student", new Student());
		model.addAttribute("response", response);
		model.addAttribute("color", "green");
		
		return "home";
	}
	
	
	
	@GetMapping("/edit/{id}")
	public String editstd(@PathVariable int id,Model model)
	{
		
	  Student std  =  stdservice.getstdbyid(id).orElse(new Student());
	  model.addAttribute("student", std);
	  model.addAttribute("students", stdservice.getallstudents());		
		
		
		return "home";
	}
	
	@PostMapping("/update")
	public String updateStudent(@ModelAttribute Student std , Model model)
	{
	
	  String res =	stdservice.addstd(std);
	  model.addAttribute("response", "successfully updated");
	  model.addAttribute("students",stdservice.getallstudents());
	  model.addAttribute("color", "green");
	  
		
		return "home";
		
	}
	
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id)
	{
		
		stdservice.deletestd(id);
		return "redirect:/home";
		
	}

   
    
}

