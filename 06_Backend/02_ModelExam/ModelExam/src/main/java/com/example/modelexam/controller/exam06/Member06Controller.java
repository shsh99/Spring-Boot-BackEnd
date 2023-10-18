package com.example.modelexam.controller.exam06;

import com.example.modelexam.model.Member;
import com.example.modelexam.service.exam06.Member06Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

/**
 * packageName : com.example.modelexam.controller.exam01
 * fileName : MemberController
 * author : GGG
 * date : 2023-10-10
 * description : 멤버 컨트롤러 - 화면 & 업무로직 중간 역할 (리모콘 역할)
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023-10-10         GGG          최초 생성
 */
@Slf4j
@Controller
@RequestMapping("/exam06")
public class Member06Controller {

    //   todo: 서비스 객체 가져오기
    @Autowired
    Member06Service memberService;

    @GetMapping("/member")
    public String getMemberAll(Model model) {

        List<Member> list = memberService.findAll();
        model.addAttribute("list", list);

//      todo: 로깅
        log.debug(list.toString());

        return "exam06/member/member_all.jsp";
    }

    @GetMapping("/member/{eno}")
    public String getMemberId(@PathVariable int eno,
                              Model model) {
//      todo: 멤버 서비스 상세조회 함수 호출
        Member member = memberService.findById(eno);
        model.addAttribute("member", member);

        return "exam06/member/member_id.jsp";
    }

    //  todo: 새로운 회원 추가 페이지 이동 함수
    @GetMapping("/member/addition")
    public String addMember() {
        return "exam06/member/add_member.jsp";
    }

    //  todo: db 저장 함수
    @PostMapping("/member/add")
    public RedirectView createMember(
            @ModelAttribute Member member
    ){
        memberService.save(member);
//      todo : 전체 조회 페이지
        return new RedirectView("/exam06/member");
    }

    //  todo: 회원 수정 페이지 열기 함수 : 상세조회 필요
    @GetMapping("/member/edition/{eno}")
    public String editMember(@PathVariable long eno, Model model) {
        Member member = memberService.findById(eno); // 상세조회
        model.addAttribute("member", member);

        return "exam06/member/update_member.jsp";
    }

    //  todo: db 수정 저장 함수 : 수정 후 전체조회페이지로 강제 이동(리다이렉트)
    @PutMapping("/member/edit/{eno}")
    public RedirectView updateMember(@PathVariable int eno,
                                     @ModelAttribute Member member) {
//        todo: db 수정 저장
        memberService.save(member);

        return new RedirectView("/exam06/member");
    }

    //  todo: 삭제 함수 : 전체 조회 페이지로 강제 이동
    @DeleteMapping("/member/delete/{eno}")
    public RedirectView deleteMember(@PathVariable int eno) {
        memberService.removeById(eno); // db 삭제 함수 호출

        return new RedirectView("/exam06/member"); // 전체 조회 사이트
    }
}







