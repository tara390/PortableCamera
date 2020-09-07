package com.tara.portablecamera;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.Collection;

public class SPVariables {





    public static String getString(String name, Context c) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(c);
        return sp.getString(name, "");
    }

    public static void setString(String name, String value, Context c) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(c);
        sp.edit().putString(name, value).apply();
    }



}
