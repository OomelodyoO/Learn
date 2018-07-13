package win.zhang.securityoauth.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import win.zhang.securityoauth.entity.Authority;
import win.zhang.securityoauth.service.AuthorityService;
import win.zhang.securityoauth.service.UserService;

/**
 * @author zhangzhixing
 */
@RestController
@RequestMapping(value = "authority")
public class AuthorityController {
    @Autowired
    private TokenStore tokenStore;
    @Autowired
    private AuthorityService authorityService;
    @Autowired
    private UserService userService;

    @PostMapping
    public String save(@RequestBody Authority authority) {
        Authority entity = authorityService.save(authority);
        for (OAuth2AccessToken oAuth2AccessToken : tokenStore.findTokensByClientIdAndUserName("zhang", userService.findByUuid(authority.getUserUuid()).getName())) {
            tokenStore.removeAccessToken(oAuth2AccessToken);
        }
        return entity.getUuid();
    }
}
