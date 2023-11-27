package com.jscd.app.member.dto;

import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth20Service;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.UUID;

@Service
public class KakaoLoginBo {

    private final static String KAKAO_CLIENT_ID = "f9bba8ce6a0b56e27f28ef5f010fdb0c";
    private final static String KAKAO_CLIENT_SECRET = "JXQxjXwtdJ3agG7PnWTZYd23zC2829UW";

    private final static String KAKAO_REDIRECT_URI="http://localhost:8080/kakao/login";

    private final static String SESSION_STATE="kakao_oauth_state";

    private final static String PROFILE_API_URL="https://kapi.kakao.com/v2/user/me";

    public String getAuthorizationUrl(HttpSession session){

        String state = generateRandomString();

        setSession(session,state);

        OAuth20Service oAuth20Service = new ServiceBuilder()
                .apiKey(KAKAO_CLIENT_ID)
                .apiSecret(KAKAO_CLIENT_SECRET)
                .callback(KAKAO_REDIRECT_URI)
                .state(state)
                .build(KakaoOAuthApi.instance());

        return oAuth20Service.getAuthorizationUrl();

    }



    public OAuth2AccessToken getAccessToken(HttpSession session, String code, String state) throws IOException{
        System.out.println("getAccessToken");
        String sessionState = getSession(session);

        if(StringUtils.pathEquals(sessionState,state)){
            OAuth20Service oAuth20Service = new ServiceBuilder()
                    .apiKey(KAKAO_CLIENT_ID)
                    .apiSecret(KAKAO_CLIENT_SECRET)
                    .callback(KAKAO_REDIRECT_URI)
                    .state(state)
                    .build(KakaoOAuthApi.instance());
            OAuth2AccessToken accessToken = oAuth20Service.getAccessToken(code);
            return accessToken;
        }

        return null;
    }

    private String generateRandomString(){
        return UUID.randomUUID().toString();
    }

    private void setSession(HttpSession session, String state){
        session.setAttribute(SESSION_STATE, state);
    }

    private String getSession(HttpSession session){
        return (String) session.getAttribute(SESSION_STATE);
    }

    public String getUserProfile(OAuth2AccessToken oauthToken) throws Exception{
        OAuth20Service oauthService = new ServiceBuilder()
                .apiKey(KAKAO_CLIENT_ID)
                .apiSecret(KAKAO_CLIENT_SECRET)
                .callback(KAKAO_REDIRECT_URI)
                .build(NaverOAuthApi.instance());


        OAuthRequest request = new OAuthRequest(Verb.GET, PROFILE_API_URL, oauthService);
        oauthService.signRequest(oauthToken, request);
        Response response = request.send();
        return  response.getBody();

    }


 }
