package alitrtcflutte.sophon.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceUtils {
    private static final String SHAREDPRE_FILE = "videocall";
    private static final String USER_INFO = "user_info";
    private static final String APP_ID = "app_id";
    private static final String APP_KEY = "app_key";
    public static void setUser(Context context, String user) {
        SharedPreferences mySharedPreferences = context.getSharedPreferences(SHAREDPRE_FILE, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = mySharedPreferences.edit();
        editor.putString(USER_INFO, user);
        editor.commit();
    }

    public static String getUser(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHAREDPRE_FILE,
                Activity.MODE_PRIVATE);
        String userInfo = sharedPreferences.getString(USER_INFO, "");
        return userInfo;
    }

    public static void setAppId(Context context, String user) {
        SharedPreferences mySharedPreferences = context.getSharedPreferences(SHAREDPRE_FILE, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = mySharedPreferences.edit();
        editor.putString(APP_ID, user);
        editor.commit();
    }

    public static String getAppId(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHAREDPRE_FILE,
                Activity.MODE_PRIVATE);
        String userInfo = sharedPreferences.getString(APP_ID, "");
        return userInfo;
    }

    public static void setAppKey(Context context, String user) {
        SharedPreferences mySharedPreferences = context.getSharedPreferences(SHAREDPRE_FILE, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = mySharedPreferences.edit();
        editor.putString(APP_KEY, user);
        editor.commit();
    }

    public static String getAppKey(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHAREDPRE_FILE,
                Activity.MODE_PRIVATE);
        String userInfo = sharedPreferences.getString(APP_KEY, "");
        return userInfo;
    }
}
