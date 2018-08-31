package com.tanxin.base.common.api;

import com.xiaomai.environmentswitcher.annotation.Environment;
import com.xiaomai.environmentswitcher.annotation.Module;

public class EnvironmentConfig {
    @Module
    class App{
        @Environment(url = "https://admin.mo2323.com:8443/", isRelease = true, alias = "正式")
        private String online;

        @Environment(url = "https://test.mo2323.com:8446/", alias = "测试")
        private String test;
    }
}
