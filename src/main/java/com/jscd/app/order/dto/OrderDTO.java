package com.jscd.app.order.dto;
//주문 상품 정보

public class OrderDTO {
    private int registCode;
    private String title;
    private int lastPrice;
    private String startDate;
    private String endDate;

    public OrderDTO() {
    }

    public OrderDTO(int registCode, String title, int lastPrice, String startDate, String endDate) {
        this.registCode = registCode;
        this.title = title;
        this.lastPrice = lastPrice;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getRegistCode() {
        return registCode;
    }

    public void setRegistCode(int registCode) {
        this.registCode = registCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(int lastPrice) {
        this.lastPrice = lastPrice;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "registCode=" + registCode +
                ", title='" + title + '\'' +
                ", lastPrice=" + lastPrice +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}
