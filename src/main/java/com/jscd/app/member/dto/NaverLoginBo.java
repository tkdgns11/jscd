package com.jscd.app.member.dto;

import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth20Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.UUID;

@Service
public class NaverLoginBo {

    /*인증 요청문을 구성하는 파라미터 */
    /*
    client_id : 애플리케이션 등록 후 발급받은 클라이언트 아이디
    response_type : 인증 과정에 대한 구분값, code로 값이 고정
    redirect_url : 네이버 로그인 인증의 결과를 전달받을 콜백 url
    state : 애플리케이션이 생성한 상태 토큰
    profile_api_url : 프로필 조회 api url
     */
    private final static String CLIENT_ID = "m18tOuezIseUaPWLoEIf";
    private final static String CLIENT_SECRET = "VIKmUpcCI8";
    private final static String REDIRECT_URI="http://localhost:8080/member/naverLogin";
    private final static String SESSION_STATE="naver_oauth_state";
    private final static String PROFILE_API_URL="https://openapi.naver.com/v1/nid/me";

    //네이버 아이디로 인증 url 생성 method
    public String getAuthorizationUrl(HttpSession session){

        //세션 유효성 검증을 위하여 난수를 생성
        String state = generateRandomString();
        //생성한 난수 값을 session에 저장
        setSession(session,state);

        /*
            scribe에서 제공하는 인증 url 생성 기능을 이용하여 네이버 아이디로 인증 url 생성
         */
        OAuth20Service oAuth20Service = new ServiceBuilder()
                .apiKey(CLIENT_ID)
                .apiSecret(CLIENT_SECRET)
                .callback(REDIRECT_URI)
                .state(state) //앞서 생성한 난수값을 인증 url 생성 시 사용
                .build(NaverOAuthApi.instance());

        return oAuth20Service.getAuthorizationUrl();

    }
    //네이버 아이디로 callback 처리 및 AccessToken 획득
    public OAuth2AccessToken getAccessToken(HttpSession session, String code, String state) throws IOException{

        //callback으로 전달받은 세션검증용 난수값과 세션에 저장되어 있는 값이 일치하는지 확인
        String sessionState = getSession(session);

        if(StringUtils.pathEquals(sessionState, state)){
            System.out.println("sessionState equals");
            OAuth20Service oAuth20Service = new ServiceBuilder()
                    .apiKey(CLIENT_ID)
                    .apiSecret(CLIENT_SECRET)
                    .callback(REDIRECT_URI)
                    .state(state)
                    .build(NaverOAuthApi.instance());
            //scribe에서 제공하는 accessToken 획득 기능으로 네이버 아이디로 Access Token을 획득
            OAuth2AccessToken accessToken = oAuth20Service.getAccessToken(code);
            return accessToken;
        }

        return null;
    }

    //세션 유효성 검증을 위한 난수 생성
    private String generateRandomString(){
        return UUID.randomUUID().toString();
    }

    //http session에 데이터 저장
    private void setSession(HttpSession session, String state){
        session.setAttribute(SESSION_STATE, state);
    }

    //http session에서 데이터 가져오기
    private String getSession(HttpSession session){
        return (String) session.getAttribute(SESSION_STATE);
    }

    //Access Token을 이용하여 네이버 사용자 프로필 API를 호출
    public String getUserProfile(OAuth2AccessToken oauthToken) throws Exception{
        OAuth20Service oauthService = new ServiceBuilder()
                .apiKey(CLIENT_ID)
                .apiSecret(CLIENT_SECRET)
                .callback(REDIRECT_URI)
                .build(NaverOAuthApi.instance());


        OAuthRequest request = new OAuthRequest(Verb.GET, PROFILE_API_URL, oauthService);
        oauthService.signRequest(oauthToken, request);
        Response response = request.send();
        return  response.getBody();

    }


 }
