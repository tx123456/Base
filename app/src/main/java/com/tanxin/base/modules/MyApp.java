package com.tanxin.base.modules;
import com.tencent.bugly.beta.tinker.TinkerApplicationLike;
import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.shareutil.ShareConstants;


/**
 * @author TANXIN
 * @date 2018/6/20/020 
 */
 
 
public class MyApp extends TinkerApplication {

    public MyApp() {
        super(ShareConstants.TINKER_ENABLE_ALL, "com.tanxin.base.modules.MyAppLike",
                    "com.tencent.tinker.loader.TinkerLoader", false);
    }

}
