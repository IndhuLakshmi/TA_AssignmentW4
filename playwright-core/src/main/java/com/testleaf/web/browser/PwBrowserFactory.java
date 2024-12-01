package com.testleaf.web.browser;

import com.testleaf.constants.BrowserType;

public class PwBrowserFactory implements BrowserFactory {
    @Override
    public Browser createBrowser(BrowserType browserType) {
        return new PwBrowserImpl(browserType,"00D5g00000LNGD5!AR0AQPcS7aLY.7d47XvlCbmlGORbeom6TctmL9xpFSJMHJRy4AyndOIxFgTRz._sRFuxHx2o39Qn_IchPnsOIszO2vI6FjIH");
    }
}

