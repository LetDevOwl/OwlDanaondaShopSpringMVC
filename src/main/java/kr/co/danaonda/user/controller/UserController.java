package kr.co.danaonda.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import kr.co.danaonda.user.domain.User;
import kr.co.danaonda.user.service.UserService;

@Controller
@SessionAttributes({"userId","userPw"})
public class UserController {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(value="/user/login.do", method=RequestMethod.GET)
	public String showLoginPage(
			@RequestHeader("referer") String prevUrl
			, Model model) {
		model.addAttribute("prevUrl", prevUrl);
		return "user/loginPage";
	}
	
	@RequestMapping(value="/user/login.do", method=RequestMethod.POST)
	public String UserLogin(
			HttpServletRequest request
			, @RequestParam("user_id") String userId
			, @RequestParam("user_pw") String userPw
			, @RequestParam("prev_url") String prevUrl
			, Model model) {
		try {
			User user = new User();
			user.setUserId(userId);
			user.setUserPw(userPw);
			User uOne = service.selectCheckLogin(user);
			if(uOne != null) {
				model.addAttribute("userId", uOne.getUserId());
				model.addAttribute("userNickName", uOne.getUserNickName());
				model.addAttribute("msg", "�α��� ����!");
				model.addAttribute("url", prevUrl);
				return "common/serviceSuccess";
			}else {
				model.addAttribute("msg", "�����Ͱ� ��ȸ���� �ʾҽ��ϴ�.");
				return "common/serviceFailed";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/errorPage";
		}
	}
	
	public String UserLogout(
			HttpSession sessionPrev
			, SessionStatus session
			, Model model) {
		if(session != null) {
			session.setComplete();
			if(session.isComplete()) {
				// ���� ���� ��ȿ�� üũ
			}
			return "redirect:/index.jsp";
		}else {
			model.addAttribute("msg", "�α׾ƿ��� �Ϸ����� ���߽��ϴ�.");
			return "common/errorPage";
		}
	}
	
}
