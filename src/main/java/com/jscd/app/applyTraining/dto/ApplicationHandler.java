package com.jscd.app.applyTraining.dto;

import org.springframework.web.util.UriComponentsBuilder;

public class ApplicationHandler {

    private  SearchApplication sa;
    public final int NAV_SIZE = 10; // 페이지 내비 크기
    private int totalCnt; // 총 게시물 개수
    private int totalPage; // 전체 페이지의 개수
    private int beginPage; // 내비의 첫번째 페이지
    private int endPage;   // 내비의 마지막 페이지
    private boolean showPrev = false; // 이전 페이지로 이동하는 링크를 보여줄 것인지의 여부
    private boolean showNext = false; // 다음 페이지로 이동하는 링크를 보여줄 것인지의 여부

    public ApplicationHandler(int totalCnt, int page) {
        this(totalCnt, new SearchApplication(page,10));
    }

    public ApplicationHandler(int totalCnt, Integer page, Integer pageSize){
        this(totalCnt, new SearchApplication(page, pageSize));
    }

    public ApplicationHandler(int totalCnt, SearchApplication sa){
        this.totalCnt = totalCnt;
        this.sa = sa;

        doPaging(totalCnt, sa);
    }

    private void doPaging(int totalCnt, SearchApplication sa){
        // 총 게시물 갯수 / 10 + (총 게시물 갯수 % 10==0? 0:1)
        this.totalPage = totalCnt / sa.getPageSize() + (totalCnt % sa.getPageSize()==0? 0:1);

        // page가 totalPage보다 크지 않게
        this.sa.setPage(Math.min(sa.getPage(), totalPage));

        // 11 -> 11, 10 -> 1, 15->11.
        this.beginPage = (this.sa.getPage() -1) / NAV_SIZE * NAV_SIZE + 1;
        this.endPage = Math.min(beginPage + NAV_SIZE - 1, totalPage);
        this.showPrev = beginPage!=1;
        this.showNext = endPage!=totalPage;
    }

    public String getQueryString() {
        return getQueryString(this.sa.getPage());
    }

    public String getQueryString(Integer page) {
        // ?page=10&pageSize=10&option=A&keyword=title
        return UriComponentsBuilder.newInstance()
                .queryParam("page", page)
                .queryParam("pageSize", sa.getPageSize())
                .queryParam("option", sa.getOption())
                .queryParam("keyword", sa.getKeyword())
                .build().toString();
    }

    void print(){
        System.out.println("page = " + sa.getPage());
        System.out.println(showPrev? "PREV " : "");

        for(int i=beginPage; i<=endPage; i++){
            System.out.println(i + " ");
        }
        System.out.println(showNext? " NEXT" : "");
    }

    public SearchApplication getSa() {
        return sa;
    }

    public void setSa(SearchApplication sa) {
        this.sa = sa;
    }

    public int getNAV_SIZE() {
        return NAV_SIZE;
    }

    public int getTotalCnt() {
        return totalCnt;
    }

    public void setTotalCnt(int totalCnt) {
        this.totalCnt = totalCnt;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getBeginPage() {
        return beginPage;
    }

    public void setBeginPage(int beginPage) {
        this.beginPage = beginPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public boolean isShowPrev() {
        return showPrev;
    }

    public void setShowPrev(boolean showPrev) {
        this.showPrev = showPrev;
    }

    public boolean isShowNext() {
        return showNext;
    }

    public void setShowNext(boolean showNext) {
        this.showNext = showNext;
    }

    @Override
    public String toString() {
        return "ApplicationHandler{" +
                "sa=" + sa +
                ", NAV_SIZE=" + NAV_SIZE +
                ", totalCnt=" + totalCnt +
                ", totalPage=" + totalPage +
                ", beginPage=" + beginPage +
                ", endPage=" + endPage +
                ", showPrev=" + showPrev +
                ", showNext=" + showNext +
                '}';
    }
}
