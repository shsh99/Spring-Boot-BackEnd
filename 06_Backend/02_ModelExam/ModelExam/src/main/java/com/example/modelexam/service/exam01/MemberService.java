package com.example.modelexam.service.exam01;

import com.example.modelexam.dao.MemberDao;
import com.example.modelexam.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * packageName : com.example.modelexam.service.exam01
 * fileName : MemberService
 * author : GGG
 * date : 2023-10-10
 * description : 회원 서비스 - 업무 로직
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023-10-10         GGG          최초 생성
 */
@Service
public class MemberService {

    //    todo : db 접근 함수들이 있는 객체 : memberDao
    @Autowired
    MemberDao memberDao;

    /**
     * 전체 조회
     *
     * @return
     */
    public List<Member> findAll() {
        List<Member> list = memberDao.selectAll(); // 전체 조회

        return list;
    }

    public Member findById(long eno) {
        Member member = memberDao.selectById(eno);
        return member;
    }
}