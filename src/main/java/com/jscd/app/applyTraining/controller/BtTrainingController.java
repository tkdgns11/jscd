package com.jscd.app.applyTraining.controller;

import com.jscd.app.applyTraining.dto.BtApplicationDto;
import com.jscd.app.applyTraining.service.BtApplicationService;
import com.jscd.app.lecture.lstRegist.dto.LstRegistDto;
import com.jscd.app.lecture.lstRegist.service.LstService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/btTraining")
public class BtTrainingController {
    @Autowired
    BtApplicationService btApplicationService;
    @Autowired
    LstService lstService;

    // 부트캠프 신청서 제출
    @PostMapping("btApplication")
    public String btApplicationWrite(BtApplicationDto btApplicationDto, Model m, RedirectAttributes rattr){

        System.out.println("btApplicationDto = " + btApplicationDto);

        try {
            int cnt = btApplicationService.write(btApplicationDto);

            if(cnt != 1)
                throw new Exception("write err");

            rattr.addFlashAttribute("msg", "write ok");
            // 신청서 제출 후 마이페이지 강의 신청 현황으로 이동
            return null;
        } catch (Exception e) {
            // 신청서 제출 실패시
            // 작성했던 내용, 에러 메세지와 함께 신청서 페이지로 이동
            e.printStackTrace();
            m.addAttribute(btApplicationDto);
            m.addAttribute("msg", "write err");
            return "/applyTraining/btApplication";
        }
    }

    // 부트캠프 신청서 이동
    @GetMapping("btApplication")
    public String btApplicationWrite(LstRegistDto lstRegistDto, Model m, RedirectAttributes rattr, HttpServletRequest request){

//        // 1. 로그인 상태 확인
//        // 이미 생성된 세션이 있으면 기존의 세션 반환 없으면 null 반환
//        HttpSession session = request.getSession(false);
//
//        // 2. 로그인 상태라면 이미 신청한 회원인지 확인
//        if(session != null){
//            String id = (String)session.getAttribute("id");
//            System.out.println("id = " + id);
//
//            // 2.1 신청한 강의 번호 얻기
//            Integer registCode = lstRegistDto.getRegistCode();
//
//            // 2.2 신청한 강의 번호, session id를 map에 담기
//            Map map = new HashMap();
//            map.put("registCode", registCode);
//            map.put("id", id);
//
//            // 2.3 map으로 검색
//            try {
//                BtApplicationDto btApplicationDto = btApplicationService.confirmApplcation(map);
//
//                // 2.4 검색 결과가 중복 신청이라면 예외 발생
//                if (btApplicationDto != null)
//                    throw new Exception("duplicate application");
//
//                // 3. 중복 신청이 아니라면 id, registCode, title, lastPrice를 신청서 페이지로 전달
//                m.addAttribute("id" + id);
//                m.addAttribute("lstRegistDto" + lstRegistDto);
//                return "/applyTraining/btApplication";
//            } catch (Exception e) {
//                // 2.5 신청 중복 메시지와 함께 리턴
//                e.printStackTrace();
//                rattr.addFlashAttribute("msg", "duplicate application");
//                return null;
//            }
//
//        }else{
//            // 로그인 상태가 아니면 메세지 전송
//            m.addAttribute("msg", "login required");
//            // 로그인 페이지로 이동
//            System.out.println("no session");
//            return "redirect:/member/login";
//        }

        m.addAttribute("lstRegistDto" + lstRegistDto);
        return "/applyTraining/btApplication";
    }

    // 부트캠프 리스트 이동
    @GetMapping("/list")
    public String btTrainingList(Model m) throws Exception {
        try {
            List<LstRegistDto> list = lstService.bootCampList();
            m.addAttribute("list", list);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return "/applyTraining/bootCampList";
    }

    // 부트캠프 세부페이지 이동
    @GetMapping("/read")
    public String bootCampRead(Integer registCode, Model m) throws Exception {
        try {
            LstRegistDto lstRegistDto = lstService.bootCampRead(registCode);
            m.addAttribute(lstRegistDto);
        } catch(Exception e) {
            e.printStackTrace();
            return "redirect:/btTraining/list";
        }
        return "/applyTraining/bootCamp";
    }
}
