package com.jscd.app.board.notice.dto;


import java.util.Objects;

public class stdNoticeDto {
    private Integer bno;
    private String title;
    private String content;
    private String writer;
    private Integer viewCnt;
    private String modifyDate;
    private String regDate;

    public Integer getBno() {
        return bno;
    }

    public void setBno(Integer bno) {
        this.bno = bno;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public Integer getViewCnt() {
        return viewCnt;
    }

    public void setViewCnt(Integer viewCnt) {
        this.viewCnt = viewCnt;
    }

    public String getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(String modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        stdNoticeDto that = (stdNoticeDto) o;
        return Objects.equals(bno, that.bno) && Objects.equals(title, that.title) && Objects.equals(content, that.content) && Objects.equals(writer, that.writer) && Objects.equals(viewCnt, that.viewCnt) && Objects.equals(modifyDate, that.modifyDate) && Objects.equals(regDate, that.regDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bno, title, content, writer, viewCnt, modifyDate, regDate);
    }

    public stdNoticeDto() {
        this("", "", "");
    }

    public stdNoticeDto(String title, String content, String writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
    }
}

