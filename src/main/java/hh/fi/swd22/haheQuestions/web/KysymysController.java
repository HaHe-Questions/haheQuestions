package hh.fi.swd22.haheQuestions.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.fi.swd22.haheQuestions.domain.KysymysRepository;

@Controller
public class KysymysController {
	@Autowired
	private KysymysRepository krepository;
	
	@ResponseBody
	@RequestMapping("/index")
	public String hello() {
		return "hello";
	}
	
}
