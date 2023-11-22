package com.jscd.app.member.kakao.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;


public interface KakaoService {
    public String kakaoAccessToken(String code) throws Exception;
    public HashMap<String, Object> getUserInfo(String accessToken) throws Exception;
    public void kakaoLogout(String accessToken) throws Exception;
}
