package com.example.mybatisexam.model.vo;

import com.example.mybatisexam.model.common.BaseTimeEntity;
import lombok.*;

/**
 * packageName : com.example.mybatisexam.model.vo
 * fileName : Emp
 * author : GGG
 * date : 2023-10-13
 * description : 사원 클래스(vo) == 테이블 같음
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023-10-13         GGG          최초 생성
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Emp extends BaseTimeEntity {
//  todo: 단축키 : ctrl + shift + u(대/소문자 바꾸기)
    private Integer eno;
    private String ename;
    private String job;
    private Integer manager;
    private Integer salary;
    private String hiredate;
    private Integer commission;
    private Integer dno;
}
