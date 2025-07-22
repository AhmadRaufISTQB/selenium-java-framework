package com.ahmad.automation.utils;

import com.ahmad.automation.config.ConfigManager;
import com.ahmad.automation.drivers.DriverManager;

public class NavigationUtil {

    private static final String BASE_URL = ConfigManager.get("baseUrl");

    /**
     * Navigate to a relative or absolute URL.
     * If the URL starts with "/", it will append it to the baseUrl.
     */
    public static void navigateTo(String url) {
        if (url.startsWith("/")) {
            DriverManager.getDriver().get(BASE_URL + url);
        } else {
            DriverManager.getDriver().get(url);
        }
    }
}
