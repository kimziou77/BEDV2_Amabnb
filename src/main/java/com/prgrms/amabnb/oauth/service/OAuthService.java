package com.prgrms.amabnb.oauth.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prgrms.amabnb.oauth.dto.TokenResponse;
import com.prgrms.amabnb.oauth.dto.UserProfile;
import com.prgrms.amabnb.user.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OAuthService {

    private final TokenService tokenService;
    private final UserService userService;

    @Transactional
    public TokenResponse register(UserProfile userProfile) {
        var registeredUser = userService.register(userProfile);
        return tokenService.createToken(registeredUser);
    }

}
