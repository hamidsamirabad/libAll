package ir.git.samir.Utils;


import android.content.Context;
import android.content.res.Configuration;
import ir.git.samir.Lib;

import java.util.Locale;

public class LanguageManeger {

    private  static Languages languages = Languages.English;

    public static LanguageManeger with(Context context) {


        return new LanguageManeger();
    }


    public static boolean isRight(){

        return Locale.getDefault().toString().equals("fa");

    }

    public Languages getLanguage(){
        return languages;
    }

    public static void Persion() {


        changeTo(Languages.Persion);

    }

    public static void English() {


        changeTo(Languages.English);

    }


    public static void defaultLanguage() {
        ClassPreferences pref = new ClassPreferences(Lib.context);
        String languageToLoad = "";



        if (pref.getString("lan_gu_age").equals("")){
            if(Locale.getDefault().getLanguage().equals("fa")){
                languageToLoad="fa";
                languages = Languages.Persion;
            }else{
                languageToLoad="en";
                languages = Languages.English;
            }
        }else{

            if (pref.getString("lan_gu_age").equals("fa")) {
                languageToLoad = "fa"; // your language
                languages = Languages.Persion;

            } else {
                languageToLoad = "en"; // your language
                languages = Languages.English;

            }
        }

//



        Locale locale = new Locale(languageToLoad);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        Lib.context.getResources().updateConfiguration(config,
                Lib.context.getResources().getDisplayMetrics());


    }


    public static void changeTo(Languages languages) {


        ClassPreferences pref = new ClassPreferences(Lib.context);
        String languageToLoad = "";
        if (languages == Languages.Persion) {
            languageToLoad = "fa"; // your language
            languages = Languages.Persion;

        } else {
            languageToLoad = "en"; // your language
            languages = Languages.English;

        }

        Locale locale = new Locale(languageToLoad);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        Lib.context.getResources().updateConfiguration(config,
                Lib.context.getResources().getDisplayMetrics());


        pref.set("lan_gu_age", languageToLoad);

    }


    public enum Languages {
        Persion, English
    }

}
