package com.jscd.app.lecture.bootCamp.domain;

public class BootCampRegistHandler {
    private int totalCnt; // 총 게시물 개수
    private int pageSize; // 한 페이지의 크기
    private int naviSize = 10; // 페이지 내비 크기
    private int totalPage; // 전체 페이지의 개수
    private int page;      // 현재 페이지
    private int beginPage; // 내비의 첫번째 페이지
    private int endPage;   // 내비의 마지막 페이지
    private boolean showPrev; // 이전 페이지로 이동하는 링크를 보여줄 것인지의 여부
    private boolean showNext; // 다음 페이지로 이동하는 링크를 보여줄 것인지의 여부

    public BootCampRegistHandler(int totalCnt, int page){
        // 총 게시물 개수, 현재 페이지, 한 페이지의 크기(10)
        this(totalCnt, page, 10);
    }

    public BootCampRegistHandler(int totalCnt, int page, int pageSize) {
        // 총 게시물 개수, 현재 페이지, 한 페이지의 크기
        this.totalCnt = totalCnt;
        this.page = page;
        this.pageSize = pageSize;

        // 전체 페이지의 개수 = (int)(올림)총 게시물 개수 / (double)한 페이지의 크기 10
        totalPage = (int)Math.ceil(totalCnt / (double)pageSize);

        // 내비 첫번째 페이지 = (현재 페이지-1) / 10 * 10 + 1
        beginPage = (page-1) / naviSize * naviSize + 1;
//        page(현재 페이지)  beginPage(내비 첫번째 페이지)
//        5                 1
//        15                11
//        20                11

        // 내비 마지막 페이지 = (내비 첫번째 페이지 + 10 -1) , (전체 페이지 개수) 둘 중에 작은 값
        endPage = Math.min(beginPage + naviSize -1 , totalPage);

        // 이전 페이지 이동 버튼 (<) = 내비 첫번째 페이지가 1이 아니면 true
        showPrev = beginPage != 1;

        // 다음 페이지 이동 버튼 (>) = 내비 마지막 페이지가 전체 페이지 개수가 아니면 true
        showNext = endPage != totalPage;
    }

    //    페이지 내비게이션을 consol에 출력하는 메서드(test 할때 사용)
    public void print(){
        System.out.println("page = " + page);
        System.out.print(showPrev ? "[PREV] " : "");
        for(int i = beginPage; i <= endPage; i++){
            System.out.print( i + "");
        }
        System.out.println(showNext ? "[NEXT]" : "");
    }

    public int getTotalCnt() {
        return totalCnt;
    }

    public void setTotalCnt(int totalCnt) {
        this.totalCnt = totalCnt;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getNaviSize() {
        return naviSize;
    }

    public void setNaviSize(int naviSize) {
        this.naviSize = naviSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
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

    public void setEndPage(int endPage) { this.endPage = endPage; }

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
        return "registrationHandler{" +
                "totalCnt=" + totalCnt +
                ", pageSize=" + pageSize +
                ", naviSize=" + naviSize +
                ", totalPage=" + totalPage +
                ", page=" + page +
                ", beginPage=" + beginPage +
                ", endPage=" + endPage +
                ", showPrev=" + showPrev +
                ", showNext=" + showNext +
                '}';
    }

}
