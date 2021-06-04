package com.example.class0604.Controller;

import com.example.class0604.DTO.Member;
import com.example.class0604.DTO.MemberDTO;
import com.example.class0604.Repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@AllArgsConstructor
public class MemberController {
    @Autowired
    MemberRepository memberRepository;

    //입력메소드 시작
    @RequestMapping("/input")
    public String go_input()
    {
        return "Inputform";
    }
    //입력메소드 종료

    //저장메소드 시작
    @RequestMapping("/save")
    public String go_save(MemberDTO mdto) {
        Member member = mdto.toEntity();
        memberRepository.save(member);
        return "redirect:list";
    }
    //저장메소드 종료

    //저장알림 메소드 시작
    @GetMapping("list")
    public String go_list(Model model)
    {
        List<Member> alist = (List<Member>) memberRepository.findAll();
        model.addAttribute("list",alist);
        return "Outform";
    }
    //저장 알림 메소드 종료

    //아이디로 삭제 메소드 시작
    @DeleteMapping("/DeleteId")
    public String go_DeleteId(HttpServletRequest hrs)
    {
        String id = hrs.getParameter("id");
        memberRepository.deleteById(id);
        return "redirect:list";
    }
    //아이디로 삭제 메소드 종료

//    //전체삭제 메소드 시작
//    @GetMapping("/DeleteAll")
//    public void go_DeleteAll()
//    {
//        memberRepository.deleteAll();
//    }
//    //전체삭제 메소드 종료

    //수정메소드 시작
    @RequestMapping("/update")
    public String go_update(Model model, HttpServletRequest hrs)
    {
        String id = hrs.getParameter("id");
        model.addAttribute("id",id);
        return "Modifyform";
    }
    //수정메소드 종료

    //수정자료 입력 시작
    @PostMapping("/updateend")//넘겨받은 자료 개체화
    public String go_updateend(MemberDTO mdto)
    {
        Member member=mdto.toEntity();
        memberRepository.save(member);
        return "redirect:list";
    }
    //수정자료 입력 종료

}
