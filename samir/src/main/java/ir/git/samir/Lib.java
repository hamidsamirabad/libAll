package ir.git.samir;

import android.content.Context;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import ir.git.samir.Utils.ClassPreferences;

public class Lib {

    public static AppCompatActivity activity;
    public static Context context;
    public static View view;


    public static boolean isNightMode = false;



    public static void init(){
        ClassPreferences pref= new ClassPreferences(context);
        isNightMode = pref.getBoolean("nightMode");

    }


    public static void setIsNightMode(boolean isNightMode){
        ClassPreferences pref= new ClassPreferences(context);
        pref.set("nightMode",isNightMode);
    }

}
