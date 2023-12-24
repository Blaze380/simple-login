package com.blazeland.simplelogin.services;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface CookieService {
    void setCookie(HttpServletResponse response, String key, String value, int maxTimeInSeconds);

    String getCookie(HttpServletRequest request, String key);

    boolean deleteCookie(String key);
}
