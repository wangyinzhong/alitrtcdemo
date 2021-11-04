package alitrtcflutte.sophon.base;

import android.app.Application;

/**
 * 全局上下文
 */
public class AliRtcApplication extends Application {

    private static AliRtcApplication sInstance;


    public static AliRtcApplication getInstance(){
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
    }
}
