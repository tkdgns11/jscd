package com.jscd.app.admin.domain;

import org.springframework.web.util.UriComponentsBuilder;

public class SearchCondition {

    //페이지 이동마다 쿼리스트링으로 주고 받을 데이터 객체로 묶기
    private Integer page = 1; //값이 넘어오지 못할 경우를 위해, 기본값 설정
    private Integer pageSize = 10;
    private String option = "";
    private String keyword = "";

    public SearchCondition(){}

    public SearchCondition(Integer page, Integer pageSize, String option, String keyword) {
        this.page = page;
        this.pageSize = pageSize;
        this.option = option;
        this.keyword = keyword;
    }


    public String getQueryString(Integer page) { // ?page=10&pageSize=10&option=A&keyword=title
        //현재 페이지에 대한 쿼리스트링
        return UriComponentsBuilder.newInstance()
                .queryParam("page",     page)
                .queryParam("option",   option)
                .queryParam("keyword",  keyword)
                .build().toString();
    }

    @Override
    public String toString() {
        return "SearchCondition{" +
                "page=" + page +
                ", pageSize=" + pageSize +
                ", offset=" + getOffset() +
                ", option='" + option + '\'' +
                ", keyword='" + keyword + '\'' +
                '}';
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getOffset() {
        return (page-1)*pageSize;
    }


    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
