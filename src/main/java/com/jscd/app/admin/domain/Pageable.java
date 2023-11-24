package com.jscd.app.admin.domain;


public class Pageable {
    private SearchCondition sc;
    public  final int NAV_SIZE = 10; // 내비 사이즈
    private int totalCnt; // 총 갯수
    private int totalPage; // 전체 페이지의 갯수
    private int beginPage; // 내비 첫 페이지
    private int endPage; // 내비 마지막 페이지
    private boolean showNext = false; // 이후를 보여줄지의 여부
    private boolean showPrev = false; // 이전을 보여줄지의 여부

    public Pageable(SearchCondition sc, int totalCnt){
        this.sc = sc;
        this.totalCnt = totalCnt;

        totalPage = totalCnt / sc.getPageSize() + (totalCnt%sc.getPageSize() == 0 ? 0 : 1); //나머지가 있으면 + 1, 아니면 0
        beginPage = (sc.getPage()-1) / NAV_SIZE * NAV_SIZE + 1;
        endPage = Math.min(beginPage + NAV_SIZE-1,totalPage);
        showNext = beginPage != 1; //맨 처음만 아니면 실행
        showPrev = endPage != totalPage; //끝 페이지만 아니면 실행

    }

    public Pageable(){}


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

    public boolean isShowNext() {
        return showNext;
    }

    public void setShowNext(boolean showNext) {
        this.showNext = showNext;
    }

    public boolean isShowPrev() {
        return showPrev;
    }

    public void setShowPrev(boolean showPrev) {
        this.showPrev = showPrev;
    }

    @Override
    public String toString() {
        return "Pageable{" +
                ", NAV_SIZE=" + NAV_SIZE +
                ", totalCnt=" + totalCnt +
                ", totalPage=" + totalPage +
                ", beginPage=" + beginPage +
                ", endPage=" + endPage +
                ", showNext=" + showNext +
                ", showPrev=" + showPrev +
                '}';
    }
}
