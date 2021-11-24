package alitrtcflutte.sophon.videocall;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import alitrtcflutte.AliTrTcAction;
import alitrtcflutte.sophon.R;
import alitrtcflutte.sophon.bean.RTCAuthInfo;
import alitrtcflutte.sophon.rtc.RTCActionCallInfo;
import alitrtcflutte.sophon.utils.StringUtil;


public class VideoCallActivity extends AppCompatActivity implements View.OnClickListener {

    AlivcVideoCallView alivcVideoCallView;
    String displayName;
    String channel;
    private RTCAuthInfo mRtcAuthInfo;
    private TextView mTitleTv;
    private TextView mCopyTv;
    private RTCActionCallInfo aliTrTcAction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aliyun_video_call_main);
        getIntentData();
        mTitleTv =findViewById(R.id.tv_title);
        mCopyTv =findViewById(R.id.tv_copy);
        alivcVideoCallView = findViewById(R.id.alivc_videocall_view);
        mCopyTv.setOnClickListener(this);
        alivcVideoCallView.setAlivcVideoCallNotifyListner(new AlivcVideoCallView.AlivcVideoCallNotifyListner() {
            @Override
            public void onLeaveChannel() {
                finish();
            }
        });

        mTitleTv.setText(String.format(getResources().getString(R.string.str_channel_code),channel));

        alivcVideoCallView.auth(displayName, channel, mRtcAuthInfo);
        aliTrTcAction=new RTCActionCallInfo(new AliTrTcAction());
    }

    private void getIntentData() {
        if (getIntent().getExtras() != null) {
            displayName = getIntent().getExtras().getString("username");
            channel = getIntent().getExtras().getString("channel");
            mRtcAuthInfo = (RTCAuthInfo) getIntent().getExtras().getSerializable("rtcAuthInfo");
        }
    }

    @Override
    protected void onDestroy() {
        if (alivcVideoCallView != null) {
            alivcVideoCallView.leave();
        }
        aliTrTcAction.callWithdraw();
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.tv_copy) {
            StringUtil.clipChannelId(channel, VideoCallActivity.this);
        }
    }
}
