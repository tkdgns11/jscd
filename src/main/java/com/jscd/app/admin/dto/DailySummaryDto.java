package com.jscd.app.admin.dto;

import java.util.*;

public class DailySummaryDto {
    private String date;
    private Integer pageviews;
    private Integer visitors;
    private Integer orders;
    private Integer revenue;
    private Integer signups;
    private Integer inquiries;
    private Integer reviews;
    private Date regDate;

    public DailySummaryDto(String date, Integer pageviews, Integer visitors, Integer orders, Integer revenue, Integer signups, Integer inquiries, Integer reviews) {
        this.date = date;
        this.pageviews = pageviews;
        this.visitors = visitors;
        this.orders = orders;
        this.revenue = revenue;
        this.signups = signups;
        this.inquiries = inquiries;
        this.reviews = reviews;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getPageviews() {
        return pageviews;
    }

    public void setPageviews(Integer pageviews) {
        this.pageviews = pageviews;
    }

    public Integer getVisitors() {
        return visitors;
    }

    public void setVisitors(Integer visitors) {
        this.visitors = visitors;
    }

    public Integer getOrders() {
        return orders;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
    }

    public Integer getRevenue() {
        return revenue;
    }

    public void setRevenue(Integer revenue) {
        this.revenue = revenue;
    }

    public Integer getSignups() {
        return signups;
    }

    public void setSignups(Integer signups) {
        this.signups = signups;
    }

    public Integer getInquiries() {
        return inquiries;
    }

    public void setInquiries(Integer inquiries) {
        this.inquiries = inquiries;
    }

    public Integer getReviews() {
        return reviews;
    }

    public void setReviews(Integer reviews) {
        this.reviews = reviews;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DailySummaryDto)) return false;
        DailySummaryDto that = (DailySummaryDto) o;
        return Objects.equals(getDate(), that.getDate()) && Objects.equals(getPageviews(), that.getPageviews()) && Objects.equals(getVisitors(), that.getVisitors()) && Objects.equals(getOrders(), that.getOrders()) && Objects.equals(getRevenue(), that.getRevenue()) && Objects.equals(getSignups(), that.getSignups()) && Objects.equals(getInquiries(), that.getInquiries()) && Objects.equals(getReviews(), that.getReviews()) && Objects.equals(getRegDate(), that.getRegDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDate(), getPageviews(), getVisitors(), getOrders(), getRevenue(), getSignups(), getInquiries(), getReviews(), getRegDate());
    }

    @Override
    public String toString() {
        return "DailySummaryDto{" +
                "date='" + date + '\'' +
                ", pageviews=" + pageviews +
                ", visitors=" + visitors +
                ", orders=" + orders +
                ", revenue=" + revenue +
                ", signups=" + signups +
                ", inquiries=" + inquiries +
                ", reviews=" + reviews +
                ", regDate=" + regDate +
                '}';
    }
}