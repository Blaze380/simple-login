package com.blazeland.simplelogin.services.implementation;

import org.springframework.stereotype.Service;

import com.blazeland.simplelogin.services.CookieService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class CookieServiceImpl implements CookieService {

    @Override
    public void setCookie(HttpServletResponse response, String key, String value, int maxTimeInSeconds) {
        Cookie cookie = new Cookie(key, value);
        cookie.setMaxAge(maxTimeInSeconds);
        response.addCookie(cookie);
    }

    @Override
    public String getCookie(HttpServletRequest request, String key) {
        var cookies = request.getCookies();
        String cookieValue = null;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(key)) {
                cookieValue = cookie.getValue();
                break;
            }
        }
        return cookieValue;
    }

    @Override
    public boolean deleteCookie(String key) {
        return true;
    }

}
