package com.testleaf.drivers.manager;

import com.testleaf.constants.BrowserTestEngine;
import com.testleaf.constants.BrowserType;
import com.testleaf.web.browser.Browser;
import com.testleaf.web.browser.BrowserFactory;
import com.testleaf.web.browser.PwBrowserFactory;
import com.testleaf.web.browser.PwBrowserImpl;
import com.testleaf.web.browser.SeBrowserFactory;

public class DriverManager {

    public static Browser getBrowser(BrowserTestEngine browserEngine, BrowserType browserType) {
        return setupBrowser(browserEngine, browserType);
    }

    public static Browser getBrowserWithAPI(BrowserTestEngine browserEngine, BrowserType browserType) {
        return setupBrowserWithAPI(browserEngine, browserType);
    }

    private static Browser setupBrowser(BrowserTestEngine browserEngine, BrowserType browserType) {
        switch (browserEngine) {
            case SELENIUM:
                return new SeBrowserFactory().createBrowser(browserType);
            case PLAYWRIGHT:
                return new PwBrowserFactory().createBrowser(browserType);
            default:
                throw new IllegalArgumentException("Unexpected value: " + browserEngine);
        }
    }

    private static Browser setupBrowserWithAPI(BrowserTestEngine browserEngine, BrowserType browserType) {
        switch (browserEngine) {
            case SELENIUM:
                return new SeBrowserAPIImpl(browserType);
            case PLAYWRIGHT:
                return new PwBrowserImpl(browserType,"00D5g00000LNGD5!AR0AQPcS7aLY.7d47XvlCbmlGORbeom6TctmL9xpFSJMHJRy4AyndOIxFgTRz._sRFuxHx2o39Qn_IchPnsOIszO2vI6FjIH");
            default:
                throw new IllegalArgumentException("Unexpected value: " + browserEngine);
        }
    }
}
