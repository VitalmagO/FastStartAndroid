package com.example.sandbox;

import android.text.TextUtils;
import android.util.Log;

public class Logger {
    public static void debug (String tag, String message, Object...args) {
        if (BuildConfig.DEBUG) {
            if (TextUtils.isEmpty(message)) {
                return;
            }
        }
        if (args.length > 0) {
            message = String.format(message, args);
        }
        Log.d(tag, message);
    }
}
