package com.example.jpacustomexam.service;

import com.example.jpacustomexam.model.Dept;
import com.example.jpacustomexam.repository.DeptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * packageName : com.example.jpacustomexam.service
 * fileName : DeptService
 * author : GGG
 * date : 2023-10-17
 * description : 부서 서비스
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023-10-17         GGG          최초 생성
 */
@Service
public class DeptService {

    @Autowired
    DeptRepository deptRepository; // DI

    /** 전체조회 + 정렬(dno 내림차순) */
//    쿼리메소드 사용한 함수
    public List<Dept> findAllByOrderByDnoDesc() {
        List<Dept> list = deptRepository.findAllByOrderByDnoDesc();

        return list;
    }

    /** 전체조회 + 정렬(dname 내림차순) : 쿼리메소드 */
    public List<Dept> findAllByOrderByDnameDesc() {
        List<Dept> list = deptRepository.findAllByOrderByDnameDesc();

        return list;
    }

    /** 전체조회 + 정렬(dno 오름차순) : 쿼리메소드 */
    public List<Dept> findAllByOrderByDno() {
        List<Dept> list = deptRepository.findAllByOrderByDno();

        return list;
    }

    /** 전체조회 + dname like(Containing) 검색 +정렬(dname 내림차순) : 쿼리메소드 */
    public List<Dept> findAllByDnameContainingOrderByDnameDesc(String dname) {
        List<Dept> list
                = deptRepository.findAllByDnameContainingOrderByDnameDesc(dname);

        return list;
    }

    /** 전체조회 + dname like 검색 : @Query */
    public List<Dept> selectByDname(String dname) {
        List<Dept> list
                = deptRepository.selectByDname(dname);

        return list;
    }

}