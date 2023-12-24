package com.jscd.app.admin.dto;


import io.swagger.models.auth.In;
import lombok.*;

@ToString
@Setter
@Getter
@Data
public class DashboardDto {
    // 1.회원현황
    private Integer memberCnt; // 일반 회원 수
    private Integer studentCnt; // 학생 수
    private Integer teacherCnt; // 강사 수
    private Integer managerCnt; // 관리자 수
    private Integer firstManagerCnt; //최고 관리자 수
    private Integer memberTotalCnt; //전체 회원 수

//    2. 학원 매출
    private Integer btPriceTotal; //부트캠프 매출
    private Integer smPriceTotal; //세미나 매출

//    3. 강의 현황
    private Integer btProceedingCnt; //진행 중 부트캠프
    private Integer btExpectedCnt; //진행 예정 부트캠프
    private Integer btEndCnt; //종료 부트캠프
    private Integer btTotalCnt; //전체 개수 부트캠프
    
    private Integer smProceedingCnt; //진행 중 세미나
    private Integer smExpectedCnt; //진행 예정 세미나
    private Integer smEndCnt; //종료 세미나
    private Integer smTotalCnt; //전체 개수 세미나

//    4. qna(전체) 게시글 카테고리 분류

    private Integer qnaBtCnt; //부트캠프 관련 질문 게시글 수
    private Integer qnaSmCnt; //세미나 관련 질문 게시글 수
    private Integer qnaPayRefCnt; //결제 및 환불 관련 질문 게시글 수
    private Integer qnaSiteUseCnt; //사이트 이용 게시글 수
    private Integer qnaAcademyCnt; //학원 관련 게시글 수
    private Integer qnaEtcCnt;//기타 게시글 수
    private Integer qnaTotalCnt;//qna(전체) 전체 게시글 수

}
