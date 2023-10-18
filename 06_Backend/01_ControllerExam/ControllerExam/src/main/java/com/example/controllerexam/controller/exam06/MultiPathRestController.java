package com.example.controllerexam.controller.exam06;

import com.example.controllerexam.model.Board;
import com.example.controllerexam.model.Dept;
import com.example.controllerexam.model.Member;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * packageName : com.example.controllerexam.controller.exam06
 * fileName : MultiPathRestController
 * author : GGG
 * date : 2023-10-06
 * description : @PathVariable , @RestController
 * 요약 :
 *      @Controller     : jsp 개발 시 사용
 *        => return 값 : 이동할 jsp 페이지명
 *      @RestController : react / vue 연동 개발 시 사용
 *        => return 값 : json 데이터로 출력됨 : {속성:값}
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023-10-06         GGG          최초 생성
 */
@RestController
@RequestMapping("/exam06")
public class MultiPathRestController {
    //  TODO: http://localhost:8000/exam06/multi-path-rest/id/hong/name/홍길동
    @GetMapping("/multi-path-rest/id/{id}/name/{name}")
    public Member getMultiPath(
            @PathVariable String id,
            @PathVariable String name
    ) {
//        멤버 객체 생성
        Member member = new Member(id, name);
//        결과 json 데이터로 전송
        return member;
    }

    //  TODO: 연습 1) 부서 클래스의(Dept) 속성에 아래와 같이
//         데이터를 저장해서 화면에 출력해 보세요.
//    결과 :
//      {
//          "dno": 10,
//          "loc": "Seoul",
//          "dname": "Sales"
//      }
//     Rest Client 이용 해서 Rest API 함수를 테스트하는 것
    @GetMapping("/example01-extra/dno/{dno}/dname/{dname}/loc/{loc}")
    public Dept getExample01(
            @PathVariable int dno,
            @PathVariable String dname,
            @PathVariable String loc
    ){
//        객체 생성
        Dept dept = new Dept(dno, dname, loc);

        return dept;
    }

    //   TODO: 연습 2) 게시판(Board) 모델 클래스를 만들어서
//          아래와 같이 출력되도록 레스트클라이언트에 출력해 보세요.
//    결과 :
//      {
//          "no": 10,
//          "title": "제목",
//          "content": "내용",
//          "count" : "1"
//      }
    @GetMapping("/example02-extra/no/{no}/title/{title}/content/{content}/count/{count}")
    public Board getExample02(
            @PathVariable long no,
            @PathVariable String title,
            @PathVariable String content,
            @PathVariable String count
    ) {
//        객체 생성
        Board board = new Board(no, title, content, count);

        return board;
    }

}






