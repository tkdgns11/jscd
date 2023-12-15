package com.jscd.app.order.dto;
//카드 결제, 카카오페이 결제 api 호출 시 사용되는 파라미터 값

public class OrderRequest {
    private String pg; // PG사 코드
    private String pay_method; // 결제 수단 (카드 등)
    private String merchant_uid; // 주문번호
    private String name; // 상품명
    private int amount; // 결제 금액
    private String company; // 회사명
    private String buyer_email; // 구매자 이메일
    private String buyer_name; // 구매자 이름
    private String buyer_tel; // 구매자 전화번호
    private int registCode; // 추가된 필드

    public OrderRequest() {
    }

    public OrderRequest(String pg, String pay_method, String merchant_uid, String name, int amount, String company, String buyer_email, String buyer_name, String buyer_tel, int registCode) {
        this.pg = pg;
        this.pay_method = pay_method;
        this.merchant_uid = merchant_uid;
        this.name = name;
        this.amount = amount;
        this.company = company;
        this.buyer_email = buyer_email;
        this.buyer_name = buyer_name;
        this.buyer_tel = buyer_tel;
        this.registCode = registCode;
    }

    public String getPg() {
        return pg;
    }

    public void setPg(String pg) {
        this.pg = pg;
    }

    public String getPay_method() {
        return pay_method;
    }

    public void setPay_method(String pay_method) {
        this.pay_method = pay_method;
    }

    public String getMerchant_uid() {
        return merchant_uid;
    }

    public void setMerchant_uid(String merchant_uid) {
        this.merchant_uid = merchant_uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getBuyer_email() {
        return buyer_email;
    }

    public void setBuyer_email(String buyer_email) {
        this.buyer_email = buyer_email;
    }

    public String getBuyer_name() {
        return buyer_name;
    }

    public void setBuyer_name(String buyer_name) {
        this.buyer_name = buyer_name;
    }

    public String getBuyer_tel() {
        return buyer_tel;
    }

    public void setBuyer_tel(String buyer_tel) {
        this.buyer_tel = buyer_tel;
    }

    public int getRegistCode() {
        return registCode;
    }

    public void setRegistCode(int registCode) {
        this.registCode = registCode;
    }

    @Override
    public String toString() {
        return "OrderRequest{" +
                "pg='" + pg + '\'' +
                ", pay_method='" + pay_method + '\'' +
                ", merchant_uid='" + merchant_uid + '\'' +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                ", company='" + company + '\'' +
                ", buyer_email='" + buyer_email + '\'' +
                ", buyer_name='" + buyer_name + '\'' +
                ", buyer_tel='" + buyer_tel + '\'' +
                ", registCode=" + registCode +
                '}';
    }
}


