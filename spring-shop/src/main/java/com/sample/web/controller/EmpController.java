package com.sample.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sample.service.EmployeeService;
import com.sample.service.HrService;
import com.sample.vo.Dept;
import com.sample.vo.Emp;
import com.sample.web.form.EmpCreateForm;
import com.sample.web.form.EmpModifyForm;

@Controller
@RequestMapping("/emp")
public class EmpController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private HrService hrService;

	
	@GetMapping("/list")
	public String list(Model model) {
		
		List<Emp> empList = employeeService.getAllEmployees();
		model.addAttribute("empList", empList);
		
		
		return "emp/list";
	}
	
	@GetMapping("/add")
	public String form(Model model) {
		List<Dept> deptList = hrService.getAllDepts();
		model.addAttribute("deptList", deptList);
		
		return "emp/form";
	}
	
	@PostMapping("/add")
	public String create(EmpCreateForm form) {
		employeeService.createEmployee(form);
		return "redirect:list";
	}
	
	@GetMapping("/detail")
	public String detail(int no, Model model) {
		Emp emp = employeeService.getEmployeeDetail(no);
		model.addAttribute("emp", emp);
		
		return "emp/detail";
	}
	
	@GetMapping("/modify")
	public String form(int no, Model model) {
		Emp emp = employeeService.getEmployeeDetail(no);
		List<Dept> deptList = hrService.getAllDepts();
		model.addAttribute("emp", emp);
		model.addAttribute("deptList", deptList);
		return "emp/modifyform";
	}
	
	@PostMapping("/modify")
	public String update(EmpModifyForm form, Model model, int no) {
		employeeService.getEmployeeDetail(no);
		employeeService.updateEmployee(form);
		
		return "redirect:/emp/detail?no=" + no;
	}
}
