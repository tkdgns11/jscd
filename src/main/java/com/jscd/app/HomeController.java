package com.jscd.app;

import java.text.DateFormat;
import java.util.*;

import com.jscd.app.lecture.lstRegist.dto.LstRegistDto;
import com.jscd.app.lecture.lstRegist.service.LstService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	// 세미나와 부트캠프를 불러오기 위한 lstService 주입
	@Autowired
	LstService lstService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(/*Locale locale, Model model*/ Model m) {
//		logger.info("Welcome home! The client locale is {}.", locale);
//
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//
//		String formattedDate = dateFormat.format(date);
//
//		model.addAttribute("serverTime", formattedDate );
		// 제일 최신 세미나&부트캠프 각각 두개씩 불러온다.
		try {
			List<LstRegistDto> homeSeminarList = lstService.homeSeminarList();
			List<LstRegistDto> homeBootCampList = lstService.homeBootCampList();
			m.addAttribute("seminarList", homeSeminarList);
			m.addAttribute("bootCampList", homeBootCampList);
		} catch(Exception e) {
			e.printStackTrace();
			// 에러 404페이지로 이동.
		}

		return "home";
	}

	@PostMapping("/seminarList")
	@ResponseBody
	public Map<String, Object> homeSeminarList(Model m) throws Exception{
		Map<String, Object> map = new HashMap<>();

		try {
			List<LstRegistDto> homeSeminarList = lstService.homeSeminarList();
			map.put("response", homeSeminarList);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@PostMapping("/bootCampList")
	@ResponseBody
	public Map<String, Object> homeBootCampList(Model m) throws Exception{
		Map<String, Object> map = new HashMap<>();

		try {
			List<LstRegistDto> homeBootCampList = lstService.homeBootCampList();
			map.put("response", homeBootCampList);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
