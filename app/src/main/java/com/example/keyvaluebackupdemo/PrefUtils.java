package com.example.keyvaluebackupdemo;

import android.content.Context;

public class PrefUtils {
    public static final String PREF_USER_NAME = "com.example.keyvaluebackupdemo.PREF_USER_NAME";
    private static final String EMAIL = "EMAIL";
    private static final String EMAIL_BACKUP = "EMAIL_BACKUP";

    private PrefUtils() {

    }

    public static void setEmail(Context context, String email) {
        context.getSharedPreferences(PREF_USER_NAME, Context.MODE_PRIVATE)
                .edit()
                .putString(EMAIL, email)
                .apply();
    }

    public static void setBackUpEmail(Context context, String email) {
        context.getSharedPreferences(PREF_USER_NAME, Context.MODE_PRIVATE)
                .edit()
                .putString(EMAIL_BACKUP, email)
                .apply();
    }

    public static String getEmailFromBackup(Context context) {
        return context.getSharedPreferences(PREF_USER_NAME, Context.MODE_PRIVATE)
                .getString(EMAIL_BACKUP, "no backup found");
    }

    public static String getEmail(Context context) {
        return context.getSharedPreferences(PREF_USER_NAME, Context.MODE_PRIVATE)
                .getString(EMAIL, "");
    }
}
