package com.example.jpacustomexam.controller;

import com.example.jpacustomexam.model.Dept;
import com.example.jpacustomexam.model.Emp;
import com.example.jpacustomexam.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * packageName : com.example.jpacustomexam.controller
 * fileName : EmpController
 * author : GGG
 * date : 2023-10-17
 * description : 사원 컨트롤러
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023-10-17         GGG          최초 생성
 */
@Slf4j
@RestController
public class EmpController {

    @Autowired
    EmpService empService; // DI

    /** 전체조회 + 정렬(eno 내림차순) */
    @GetMapping("/emp/desc")
    public ResponseEntity<Object> getEmpAllDesc() {
        try {
//         전체 조회 + 정렬(dno 내림차순) 호출
            List<Emp> list = empService.findAllByOrderByEnoDesc();

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


    /** 전체조회 + 정렬(ename 오름차순) */
    @GetMapping("/emp/ename/asc")
    public ResponseEntity<Object> findAllByOrderByEname() {
        try {
//         전체 조회 + 정렬(dno 내림차순) 호출
            List<Emp> list = empService.findAllByOrderByEname();

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

    /** 전체조회 + like(Containing) 검색( ename ) : 쿼리메소드 */
    @GetMapping("/emp/ename/containing/{ename}")
    public ResponseEntity<Object> findAllByEnameContaining(
            @PathVariable String ename
    ) {
        try {
//         전체 조회 + 정렬(dno 내림차순) 호출
            List<Emp> list
                    = empService.findAllByEnameContaining(ename);

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

    /** 연습 4) : 쿼리메소드 */
    @GetMapping("/emp/dno/{dno}")
    public ResponseEntity<Object> findAllByJobAndDno(
            @PathVariable int dno
    ) {
        try {
//         전체 조회 + 정렬(dno 내림차순) 호출
            List<Emp> list
                    = empService.findAllByJobAndDno("MANAGER", dno);

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


    /** 연습 5) : 쿼리메소드 */
    @GetMapping("/emp/salary/{first}/{last}")
    public ResponseEntity<Object> findAllBySalaryBetween(
            @PathVariable int first,
            @PathVariable int last
    ) {
        try {
//         전체 조회 + 정렬(dno 내림차순) 호출
            List<Emp> list
                    = empService.findAllBySalaryBetween(first, last);

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

    /** 연습 6) : 쿼리메소드 */
    @GetMapping("/emp/ignore/job/{job}")
    public ResponseEntity<Object> findAllByJobIgnoreCase(
            @PathVariable String job
    ) {
        try {
//         전체 조회 + 정렬(dno 내림차순) 호출
            List<Emp> list
                    = empService.findAllByJobIgnoreCase(job);

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

    /** 연습 7) : 쿼리메소드 */
    @GetMapping("/emp/commission")
    public ResponseEntity<Object> findAllByCommissionIsNotNull() {
        try {
//         전체 조회 + 정렬(dno 내림차순) 호출
            List<Emp> list
                    = empService.findAllByCommissionIsNotNull();

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

    /** 연습 8) : 쿼리메소드 */
    @GetMapping("/emp/salary/desc/ename/asc")
    public ResponseEntity<Object> findAllByOrderBySalaryDescEnameAsc() {
        try {
//         전체 조회 + 정렬(dno 내림차순) 호출
            List<Emp> list
                    = empService.findAllByOrderBySalaryDescEnameAsc();

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

    /** 연습 9) : 쿼리메소드 */
    @GetMapping("/emp/or/salary/{first}/{last}")
    public ResponseEntity<Object> findAllBySalaryLessThanOrSalaryGreaterThan(
            @PathVariable int first,
            @PathVariable int last
    ) {
        try {
//         전체 조회 + 정렬(dno 내림차순) 호출
            List<Emp> list
                    = empService
                    .findAllBySalaryLessThanOrSalaryGreaterThan(first, last);

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

    /** 연습 10) : 쿼리메소드 */
    @GetMapping("/emp/commission/{first}/{second}/{third}")
    public ResponseEntity<Object> findAllBySalaryLessThanOrSalaryGreaterThan(
            @PathVariable int first,
            @PathVariable int second,
            @PathVariable int third
    ) {
        try {
//         전체 조회 + 정렬(dno 내림차순) 호출
            List<Emp> list
                    = empService
                    .findAllByCommissionOrCommissionOrCommission(first,
                            second,
                            third);

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