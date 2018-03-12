package com.godwin.SessionPlay;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// add my controller annotation
// this is similar to the @service 
@Controller
public class SessionController {

	@RequestMapping("")
	public String homePage1(HttpSession session) {

		//make sure to use null key word  and not "null" the string
		if(session.getAttribute("count") == null){
			session.setAttribute("count",0);
		}else{
			session.setAttribute("count",(Integer) session.getAttribute("count")+1);
			System.out.println("count just got added 1  to it count");
		}
		return "index.jsp";
	}
	@RequestMapping("/counter")
	public String displayPage(){	
		return "newPage.jsp";
	}
	@RequestMapping("/counter2")
	public String counter2(HttpSession session) {
		if(session.getAttribute("count") == null) {
			session.setAttribute("count",0);
		}else {
			session.setAttribute("count", (Integer)session.getAttribute("count")+2);
			System.out.println("count just got added two to count");
		}
		return "redirect:/counter";
	}
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		//set the session to zero
		session.setAttribute("count",0);
		System.out.println("reset count back to zero");
		return "redirect:/counter";
	}
}
