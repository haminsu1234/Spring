package kr.ch12.oauth2;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

//아까 설정해둔게 nick, email 이므로 이두정보와 부가적인 데이터가있음
//카카오 리소스 서버에서 사용자에게 정보를 줄때 loadUser로 보내줌 userRequest에 kakao에서 보내준정보가 있음
@Service
@Log4j2
public class OAuth2UserService extends DefaultOAuth2UserService {

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        //인증서버에서 발급된 엑세스토큰
        String accessToken =userRequest.getAccessToken().getTokenValue();
        log.info("OAuth2UserService..1: "+accessToken);
        //서비스 제공자 (카카오)
        String provider =userRequest.getClientRegistration().getRegistrationId();

        //다른 서비스 (네이버,구글)등이 있으면 서비스 제공자로 조건을 걸어서 넘길거임
        OAuth2User oAuth2User=super.loadUser(userRequest);


        Map<String, Object> attributes =oAuth2User.getAttributes();




        return oAuth2User;
    }
}
