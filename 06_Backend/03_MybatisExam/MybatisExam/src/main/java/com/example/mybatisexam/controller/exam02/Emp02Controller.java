package com.example.mybatisexam.controller.exam02;

import com.example.mybatisexam.model.common.PageReq;
import com.example.mybatisexam.model.common.PageRes;
import com.example.mybatisexam.model.vo.Dept;
import com.example.mybatisexam.model.vo.Emp;
import com.example.mybatisexam.service.exam02.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * packageName : com.example.mybatisexam.controller.exam02
 * fileName : Emp02Controller
 * author : GGG
 * date : 2023-10-16
 * description : 사원 컨트롤러 : @RestController (react 용)
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023-10-16         GGG          최초 생성
 */
@Slf4j
@RestController
@RequestMapping("/exam02")
public class Emp02Controller {
    @Autowired
    EmpService empService; // todo: DI

    /**
     * 전체 조회
     */
    @GetMapping("/emp")
    public ResponseEntity<Object> getEmpAll(
            @RequestParam(defaultValue = "") String ename
            , @RequestParam(defaultValue = "0") int page
            , @RequestParam(defaultValue = "3") int size
    ) {
        try {
            PageReq pageReq = new PageReq(page, size);

//      todo: 전체 조회 함수 호출
            PageRes<Emp> pageRes
                    = empService.findByEnameContaining(ename, pageReq);

//      todo: jsp 정보전달( 부서배열, 페이징정보 )
//        자료구조 (키, 값) : Map
            Map<String, Object> response = new HashMap<>();

            response.put("emp", pageRes.getContent()); // 사원배열
            response.put("currentPage", pageRes.getNumber()); // 현재 페이지 번호
            response.put("totalItems", pageRes.getTotalElements()); // 전체 테이블 건수
            response.put("totalPages", pageRes.getTotalPages()); // 전체 페이지 개수

            if(pageRes.isEmpty() == false) {
//                todo: 조회 성공
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
//                todo: 0건 조회 (실패)
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 상세조회
     */
    @GetMapping("/emp/{eno}")
    public ResponseEntity<Object> getEmpId(@PathVariable int eno) {
        try {
//                todo: 상세조회 함수 호출
            Optional<Emp> optionalEmp
                    = empService.findById(eno);

            if(optionalEmp.isEmpty() == false) {
//                todo: 조회 성공
                return new ResponseEntity<>(optionalEmp.get(), HttpStatus.OK);
            } else {
//                todo: 0건 조회 (실패)
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 저장함수
     */
    @PostMapping("/emp")
    public ResponseEntity<Object> createEmp(
            @RequestBody Emp emp
    ) {
        try{
            int count = empService.save(emp);

            return new ResponseEntity<>(count, HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 수정함수
     */
    @PutMapping("/emp/{eno}")
    public ResponseEntity<Object> updateEmp(
            @PathVariable int eno,
            @RequestBody Emp emp
    ) {
        try{
//            // todo : 수정함수 (기본키가 있으면 )
            int count = empService.save(emp);

            return new ResponseEntity<>(count, HttpStatus.OK);
        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 삭제함수
     */
    @DeleteMapping("/emp/deletion/{eno}")
    public ResponseEntity<Object> deleteEmp(
            @PathVariable int eno
    ) {
        try {
//                todo: 삭제 함수 호출
            boolean bSuccess = empService.removeById(eno);

            if(bSuccess == true) {
//                todo: 삭제 성공
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
//                todo: 0건 삭제 (실패)
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            log.debug(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}






