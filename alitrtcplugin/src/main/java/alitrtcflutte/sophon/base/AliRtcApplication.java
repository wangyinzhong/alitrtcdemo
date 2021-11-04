package alitrtcflutte.sophon.base;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;

import com.alivc.rtc.AliRtcAuthInfo;

import java.security.NoSuchAlgorithmException;

import alitrtcflutte.sophon.bean.RTCAuthInfo;
import alitrtcflutte.sophon.utils.MockAliRtcAuthInfo;
import alitrtcflutte.sophon.videocall.VideoCallActivity;

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

    /**
     * 本地生成token
     * @author wyz
     */
    private void startVideoCallActivity(String channelId, String userName) {
        try {
            AliRtcAuthInfo authInfo = null;
            try {
                authInfo = MockAliRtcAuthInfo.mockAuthInfo(channelId, MockAliRtcAuthInfo.createUserId(channelId, userName));
                RTCAuthInfo info = new RTCAuthInfo();
                RTCAuthInfo.RTCAuthInfo_Data info_data = new RTCAuthInfo.RTCAuthInfo_Data();
                info.data = info_data;
                info.data.appid = authInfo.mAppid;
                info.data.userid = authInfo.mUserId;
                info.data.nonce = authInfo.mNonce;
                info.data.timestamp = authInfo.mTimestamp;
                info.data.token = authInfo.mToken;
                info.data.gslb = authInfo.mGslb;
                info.data.ConferenceId = authInfo.mConferenceId;
                showAuthInfo(channelId, info, userName);

            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 网络获取加入频道信息
     *  @author wyz
     */
    public void showAuthInfo(String  channelId,  RTCAuthInfo rtcAuthInfo,  String userName) {
        Intent intent = new Intent(AliRtcApplication.getInstance(), VideoCallActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Bundle b = new Bundle();
        //用户名
        b.putString("username", userName);
        //频道号
        b.putString("channel", channelId);
        //音频播放
        b.putSerializable("rtcAuthInfo", rtcAuthInfo);
        intent.putExtras(b);
        startActivity(intent);
    }
}
