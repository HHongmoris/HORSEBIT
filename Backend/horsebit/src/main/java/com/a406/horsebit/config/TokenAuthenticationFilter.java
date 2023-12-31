package com.a406.horsebit.config;

import com.a406.horsebit.config.jwt.TokenProvider;
import com.a406.horsebit.domain.User;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
public class TokenAuthenticationFilter extends OncePerRequestFilter {

    private final TokenProvider tokenProvider;
    private final static String HEADER_AUTHORIZATION = "Authorization";
    private final static String TOKEN_PREFIX = "Bearer ";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Authentication authentication = null;

        try {
            log.info("필터 시작");
//            log.debug("authenticationHeaderValue: {}", request.getHeader(HEADER_AUTHORIZATION));
            String token = resolveToken(request.getHeader(HEADER_AUTHORIZATION));
            authentication = tokenProvider.getAuthentication(token);
            log.info(token);
            log.info("authentication.isAuthenticated(): {}", authentication.isAuthenticated());
            log.info(authentication.toString());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            log.info("Security Context에 '{}' 인증 정보를 저장했습니다.", ((User) authentication.getPrincipal()).getNickname());
        } catch (Exception e) {
            log.info("JWT 토큰이 없거나 유효하지 않습니다, {}", e.getMessage());
        }

        filterChain.doFilter(request, response);
    }

    private String resolveToken(String authorizationHeaderValue) {
        log.info(authorizationHeaderValue);
        if (!authorizationHeaderValue.startsWith(TOKEN_PREFIX)) {
            throw new IllegalArgumentException("유효하지 않은 Authorization header value 입니다.");
        }

        return authorizationHeaderValue.substring(TOKEN_PREFIX.length());
    }

    private String getAccessToken(String authorizationHeader){
        if(authorizationHeader != null && authorizationHeader.startsWith(TOKEN_PREFIX)){
            return authorizationHeader.substring(TOKEN_PREFIX.length());
        }
        return null;

    }
}