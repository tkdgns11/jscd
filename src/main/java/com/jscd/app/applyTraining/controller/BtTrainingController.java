package com.jscd.app.applyTraining.controller;

import com.jscd.app.applyTraining.dto.BtApplicationDto;
import com.jscd.app.applyTraining.service.BtApplicationService;
import com.jscd.app.lecture.classEnroll.dto.ClassEnrollDto;
import com.jscd.app.lecture.classEnroll.service.ClassEnrollService;
import com.jscd.app.lecture.lstRegist.dto.LstRegistDto;
import com.jscd.app.lecture.lstRegist.service.LstService;
import com.jscd.app.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/btTraining")
public class BtTrainingController {
    @Autowired
    BtApplicationService btApplicationService;
    @Autowired
    LstService lstService;
    @Autowired
    MemberService memberService;
    @Autowired
    ClassEnrollService classEnrollService;

    // 부트캠프 신청서 제출
    @PostMapping("btApplication")
    public String btApplicationWrite(BtApplicationDto btApplicationDto, Model m, RedirectAttributes rattr){

        try {
            int cnt = btApplicationService.write(btApplicationDto);
            btApplicationService.lectureApplyInsert(btApplicationDto);

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
    public String btTrainingApplication(LstRegistDto lstRegistDto, Model m, HttpServletRequest request){

        // 이미 생성된 세션이 있으면 기존의 세션 반환 없으면 null 반환
        HttpSession session = request.getSession(false);

        //session id, 신청한 강의 번호 얻기
        String id = (String)session.getAttribute("id");
        Integer registCode = lstRegistDto.getRegistCode();

        // 1. 로그인 상태라면
        if(id != null){

            // 2. id와 신청한 강의 번호 btApplicationDto에 set
            BtApplicationDto btApplicationDto = new BtApplicationDto();
            btApplicationDto.setId(id);
            btApplicationDto.setRegistCode(registCode);

            // 강의 중복 신청 확인
            try {
                // 3. id와 신청한 강의 번호를 set한 btApplicationDto 이용하여 검색
                BtApplicationDto btApplicationDto2 = btApplicationService.confirmApplcation(btApplicationDto);

                // 4. 검색 결과가 중복 신청이면 예외 발생
                if (btApplicationDto2 != null)
                    throw new Exception("duplicate application");

                // 5. 검색 결과가 중복이 아니라면
                // id, registCode, title, lastPrice를 신청서 페이지로 전달
                m.addAttribute("id" + id);
                m.addAttribute("lstRegistDto" + lstRegistDto);
                return "/applyTraining/btApplication";
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("중복 신청 발생");

                // 6. 검색 결과가 중복 신청이라 예외 발생시
                try {
                    // 7. 신청한 강의 번호로 강의 상세 내용 얻기
                    LstRegistDto lstRegistDto2 = lstService.bootCampRead(registCode);

                    // 8. 강의 상세 내용과 중복 신청 메시지 전달
                    // 강의 상세 내용을 전달하는 이유는 사용자가 보던 강의 상세 페이지를 보여주기 위함
                    m.addAttribute("lstRegistDto", lstRegistDto2);
                    m.addAttribute("msg", "duplicate application");
                    return "/applyTraining/bootCamp";
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return "redirect:/btTraining/list";
                }// try catch end
            }// try catch end

        }else{
            // 9. 로그인 상태가 아니면
            System.out.println("로그아웃 상태");
            try {
                // 10. 신청한 강의 번호로 강의 상세 내용 얻기
                LstRegistDto lstRegistDto2 = lstService.bootCampRead(registCode);

                // 11. 강의 상세 내용과 로그인 필요 메시지 전달
                // 사용자가 로그인을 거절하면 보던 강의 상세 페이지를 보여주기 위함
                m.addAttribute("lstRegistDto", lstRegistDto2);
                m.addAttribute("msg", "login required");
                return "/applyTraining/bootCamp";
            } catch (Exception e) {
                e.printStackTrace();
                return "redirect:/btTraining/list";
            }// try catch end
        }// if else end
    }

    // 부트캠프 리스트 이동
    @GetMapping("/list")
    public String btTrainingList(Model m) throws Exception {

        try {
            List<LstRegistDto> list = lstService.bootCampList();
            System.out.println(list);

            m.addAttribute("list", list);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return "/applyTraining/bootCampList";
    }

    // 부트캠프 세부페이지 이동
    @GetMapping("/read")
    public String bootCampRead(Integer registCode, Integer courseCode, Model m, HttpServletRequest request) throws Exception {

        try {
            LstRegistDto lstRegistDto = lstService.bootCampRead(registCode);
            List<ClassEnrollDto> classList = classEnrollService.getBootList(courseCode);
            m.addAttribute(lstRegistDto);
            m.addAttribute("list", classList);
        } catch(Exception e) {
            e.printStackTrace();
            return "redirect:/btTraining/list";
        }
        return "/applyTraining/bootCamp";
    }

//    private boolean loginCheck(HttpServletRequest request) {
//        // 1. 세션 얻기
//        HttpSession session = request.getSession();
//        // 2. 세션에 id가 있는지 확인, 있으면 true를 반환
//        return session.getAttribute("id")!=null;
//    }

}
