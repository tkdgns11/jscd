package com.jscd.app.board.notice.dto;

import org.springframework.web.util.UriComponentsBuilder;

public class SearchCon {
    private Integer pageSize = DEFAULT_PAGE_SIZE;
    private Integer page=1;
    private String keyword="";
    private String option="";
    public static final int MIN_PAGE_SIZE = 5;
    public static final int DEFAULT_PAGE_SIZE = 10;
    public static final int MAX_PAGE_SIZE = 50;

    public SearchCon(){}

    public SearchCon(Integer page, Integer pageSize) {
        this(page, pageSize, "", "");
    }
    public SearchCon(Integer pageSize, Integer page, String keyword, String option) {
        this.pageSize = pageSize;
        this.page = page;
        this.keyword = keyword;
        this.option = option;
    }

    @Override
    public String toString() {
        return "SearchCon{" +
                "pageSize=" + pageSize +
                ", page=" + page +
                ", keyword='" + keyword + '\'' +
                ", option='" + option + '\'' +
                '}';
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }


    public Integer getOffset() {
        return (page-1)*pageSize;
    }

    public String getQueryString(Integer page) {
        // ?page=10&pageSize=10&option=A&keyword=title
        return UriComponentsBuilder.newInstance()
                .queryParam("page",     page)
                .queryParam("pageSize", pageSize)
                .queryParam("option",   option)
                .queryParam("keyword",  keyword)
                .build().toString();
    }
}
