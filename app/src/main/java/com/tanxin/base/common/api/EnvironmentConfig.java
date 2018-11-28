package com.tanxin.base.common.api;

import com.xiaomai.environmentswitcher.annotation.Environment;
import com.xiaomai.environmentswitcher.annotation.Module;

public class EnvironmentConfig {
    @Module
    private class App{
        @Environment(url = "https://gank.io/api/", isRelease = true, alias = "正式")
        private String online;
        @Environment(url = "192.168.1.1", alias = "测试")
        private String test;
    }
}
