package alitrtcflutte.sophon.utils;

import static alitrtcflutte.AliTrTcAction.myContext;

import android.content.Intent;

import java.util.HashMap;
import java.util.Map;

public  class alivcVideoCallWithdraw {

    public static void leave(){
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("code", 1001);
        Intent lIntent = new Intent("ali.flutter.call");
        myContext.sendBroadcast(lIntent);
    }
}
