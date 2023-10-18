package com.example.modelexam.service.quiz;

import com.example.modelexam.dao.BoardDao;
import com.example.modelexam.model.Board;
import com.example.modelexam.model.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.modelexam.service.quiz
 * fileName : BoardService
 * author : GGG
 * date : 2023-10-12
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023-10-12         GGG          최초 생성
 */
@Service
public class BoardService {

    @Autowired
    BoardDao boardDao; // DB 접속 객체(crud 함수들)

    /**
     * 전체 조회
     */
    public List<Board> findAll() {
        List<Board> list = boardDao.selectAll();

        return list;
    }

    /**
     * 상세 조회
     */
    public Optional<Board> findById(int id) {
//       todo: db 상세조회(1건조회) 함수 호출
//          id(기본키)로 조회
        Board board = boardDao.selectById(id);
//      todo : null 방지 클래스 사용
        Optional<Board> optionalBoard = Optional.ofNullable(board);

        return optionalBoard;
    }

    /**
     * 저장 함수
     */
    public List<Board> save(Board board) {

        List<Board> list = null;
//      todo: insert 시 dno 자동 생성
//        기존 부서번호 max 찾아서 + 10
        if (board.getId() == null) {
//            todo: 전체조회해서 현재 배열의 크기 가져오기
            int count = boardDao.selectAll().size();
//            todo: 새로운 id 생성
            int newId = count + 1;
//            todo: 새로운 부서번호 저장 : dept
            board.setId(newId);
//            todo: db 저장
            list = boardDao.insert(board);
        } else {
//           todo: db 수정
            list = boardDao.update(board);
        }

        return list;
    }

    /**
     * 삭제 함수
     */
    public boolean removeById(int id) {
//        삭제 함수 호출 : 리턴값 : (삭제된 건수)
        int iCount = boardDao.deleteById(id);

        return (iCount > 0) ? true : false;
    }


}