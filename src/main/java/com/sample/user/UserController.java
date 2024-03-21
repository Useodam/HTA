package com.sample.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
	
	private final UserService userService;
	
	@GetMapping("/login")
	public String loginform() {
		return "user/loginform";
	}

	
	@GetMapping("/signup")
	public String form(Model model) {
		model.addAttribute("userSignupForm", new UserSignupForm());
		return "user/register-form";		// src/main/resources/templates/register-form.html
	}
	
	@PostMapping("/signup")
	public String signup(@Valid @ModelAttribute("userSignupForm") UserSignupForm form, BindingResult errors) {
		
		// BindingResult객체에 오류가 있으면, 유효성 체크를 통과하지 못한 것임으로 회원가입폼으로 내부이동시킨다.
		if(errors.hasErrors()) {
			return "user/register-form";
		}
		try {
			User user = userService.registerUser(form);
			return "redirect:/user/completed?id=" + user.getId();
		} catch (RuntimeException ex) {
			String message = ex.getMessage();	// "id" 혹은 "email" 중 하나다
			if("id".equals(message)) {
					errors.rejectValue("id", null, "사용할 수 없는 아이디입니다");
			} else if("email".equals(message)){
				errors.rejectValue("email", null, "사용할 수 없는 이메일입니다");
			}
			return "user/register-form";
		}
		
	}
	
	@GetMapping("/completed")
	public String completed(Long id, Model model) {
		User user = userService.getUser(id);
		model.addAttribute("user", user);
		
		return "user/completed";			// src/main/resources/templates/completed.html
	}
	
	
}
