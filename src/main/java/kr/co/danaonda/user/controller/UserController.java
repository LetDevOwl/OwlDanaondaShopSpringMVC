package kr.co.danaonda.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.danaonda.user.domain.User;
import kr.co.danaonda.user.service.UserService;

@Controller
@SessionAttributes({"userId","userPw"})
public class UserController {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(value="/user/register.do", method=RequestMethod.GET)
	public String showRegisterPage(Model model) {
		return "user/register";
	}
	
	@RequestMapping(value="/user/register.do", method=RequestMethod.POST)
	public String registerUser(
			HttpServletRequest request
			, HttpServletResponse response
			, @RequestParam("user_id") String userId
			, @RequestParam("user_pw") String userPw
			, @RequestParam("name") String userName
			, @RequestParam("nickname") String userNickName
			, @RequestParam("email") String userEmail
			, @RequestParam("tel") String userPhone
			, @RequestParam("gender") String userGender
			, Model model) {
		User user = new User(userId, userPw, userName, userNickName, userEmail, userPhone, userGender);
		try {
			int result = service.insertUser(user);
			if(result > 0) {
				model.addAttribute("msg", "회원가입 성공했습니다.");
				return "redirect:/index.jsp";
			}else {
				return "common/serviceFailed.jsp";
			}
		} catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			return "common/errorPage"; 
		}
	}
	
	@RequestMapping(value="/user/mypage.do", method=RequestMethod.GET)
	public String showMyPage(
			@RequestParam("user-id") String userId
			, Model model) {
		try {
			User user = service.selectOneById(userId);
			if(user != null) {
				model.addAttribute("user", user);
				return "user/myPage";
			}else {
				return "common/serviceFailed.jsp";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/errorPage";
		}
	}
	
	@RequestMapping(value="/user/update.do", method=RequestMethod.POST)
	public String updateUser(
			HttpServletRequest request
			, HttpServletResponse response
			, @RequestParam("user_id") String userId
			, @RequestParam("user_pw") String userPw
			, @RequestParam("email") String userEmail
			, @RequestParam("nickname") String userNickName
			, @RequestParam("name") String userName
			, @RequestParam("tel") String userPhone
			, @RequestParam("gender") String userGender
			, Model model) {
		try {
			User user = new User(userId, userPw, userName, userNickName, userEmail, userPhone, userGender);
			int result = service.updateUser(user);
			if(result > 0) {
				return "redirect:/index.jsp";
			}else {
				return "common/serviceFailed";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/errorPage";
		}
	}
	
	@RequestMapping(value="/user/delete.do", method=RequestMethod.GET)
	public String deleteUser(
			@RequestParam("userId") String userId
			, Model model) {
		try {
			int result = service.deleteUser(userId);
			if(result > 0) {
				return "redirect:/user/logout.do";
			}else {
				return "common/serviceFailed";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/errorPage";
		}
	}

	@RequestMapping(value="/user/login.do", method=RequestMethod.GET)
	public String showLoginPage(
			@RequestHeader("referer") String prevUrl
			, Model model) {
		model.addAttribute("prevUrl", prevUrl);
		return "user/loginPage";
	}
	
	@RequestMapping(value="/user/login.do", method=RequestMethod.POST)
	public String userLogin(
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
				model.addAttribute("msg", "로그인 성공!");
				model.addAttribute("url", prevUrl);
				return "common/serviceSuccess";
			}else {
				model.addAttribute("msg", "데이터가 조회되지 않았습니다.");
				return "common/serviceFailed";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/errorPage";
		}
	}
	
	@RequestMapping(value="/user/logout.do", method=RequestMethod.GET)
	public String userLogout(
			HttpSession sessionPrev
			, SessionStatus session
			, Model model) {
		if(session != null) {
			session.setComplete();
			if(session.isComplete()) {
				// 세션 만료 유효성 체크
			}
		}
		return "redirect:/index.jsp";
	}
	
	@RequestMapping(value="/products/productList.do", method=RequestMethod.GET)
	public String productListPage() {
		return "products/productListPage";
	}
	
	@RequestMapping(value="/products/productDetail.do", method=RequestMethod.GET)
	public String productDetailPage() {
		return "products/productDetailPage";
	}
	
}
