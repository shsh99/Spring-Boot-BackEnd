package com.example.jpacustomexam.controller;

import com.example.jpacustomexam.model.Dept;
import com.example.jpacustomexam.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * packageName : com.example.jpacustomexam.controller
 * fileName : DeptController
 * author : GGG
 * date : 2023-10-17
 * description : 부서 컨트롤러 (react 용)
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023-10-17         GGG          최초 생성
 */
@Slf4j
@RestController
public class DeptController {

    @Autowired
    DeptService deptService; // DI

    /** 전체 조회 + 정렬(dno 내림차순) : 쿼리메소드 */
    @GetMapping("/dept/desc")
    public ResponseEntity<Object> getDeptAllDesc() {
        try {
//         전체 조회 + 정렬(dno 내림차순) 호출
            List<Dept> list = deptService.findAllByOrderByDnoDesc();

            if (list.isEmpty() == false) {
//                성공
                return new ResponseEntity<>(list, HttpStatus.OK);
            } else {
//                데이터 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e){
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /** 전체 조회 + 정렬(dname 내림차순) : 쿼리메소드  */
    @GetMapping("/dept/dname/desc")
    public ResponseEntity<Object> findAllByOrderByDnameDesc() {
        try {
//         전체 조회 + 정렬(dno 내림차순) 호출
            List<Dept> list = deptService.findAllByOrderByDnameDesc();

            if (list.isEmpty() == false) {
//                성공
                return new ResponseEntity<>(list, HttpStatus.OK);
            } else {
//                데이터 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e){
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    /** 전체 조회 + 정렬(dno 오름차순) : 쿼리메소드  */
    @GetMapping("/dept/dno/asc")
    public ResponseEntity<Object> findAllByOrderByDno() {
        try {
//         전체 조회 + 정렬(dno 오름차순) 호출
            List<Dept> list = deptService.findAllByOrderByDno();

            if (list.isEmpty() == false) {
//                성공
                return new ResponseEntity<>(list, HttpStatus.OK);
            } else {
//                데이터 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e){
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    /** 전체조회 + dname like(Containing) 검색 +정렬(dname 내림차순) : 쿼리메소드 */
    @GetMapping("/dept/dname/containing/desc/{dname}")
    public ResponseEntity<Object> findAllByOrderByDno(
            @PathVariable String dname
    ) {
        try {
//         전체 조회 + 정렬(dno 오름차순) 호출
            List<Dept> list
                    = deptService
                    .findAllByDnameContainingOrderByDnameDesc(dname);

            if (list.isEmpty() == false) {
//                성공
                return new ResponseEntity<>(list, HttpStatus.OK);
            } else {
//                데이터 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e){
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    /** 전체조회 + dname like 검색 : @Query */
    @GetMapping("/dept/dname/{dname}")
    public ResponseEntity<Object> selectByDname(
            @PathVariable String dname
    ) {
        try {
//         전체 조회 + 정렬(dno 오름차순) 호출
            List<Dept> list
                    = deptService.selectByDname(dname);

            if (list.isEmpty() == false) {
//                성공
                return new ResponseEntity<>(list, HttpStatus.OK);
            } else {
//                데이터 없음
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e){
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}