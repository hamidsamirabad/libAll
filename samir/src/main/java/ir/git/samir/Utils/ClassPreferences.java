package ir.git.samir.Utils;


import android.content.Context;
import android.content.SharedPreferences;
import ir.git.samir.Lib;

public class ClassPreferences
{
    private Context context;
    private String FileName;


    public ClassPreferences()
    {
        this.context= Lib.context;
        this.FileName="temp";
    }

    public ClassPreferences(Context context)
    {
        this.context=context;
        this.FileName="temp";
    }

    public ClassPreferences(Context context,String FileName)
    {
        this.context=context;
        this.FileName=FileName;
    }

    public ClassPreferences(String FileName)
    {
        this.context= Lib.context;
        this.FileName=FileName;
    }

    public void set(String Key,String stringValue)
    {
        SharedPreferences preferences=context.getSharedPreferences(FileName,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=preferences.edit();
        editor.putString(Key,stringValue);
        editor.commit();
    }
    public void set(String Key,Boolean booleanValue)
    {
        SharedPreferences preferences=context.getSharedPreferences(FileName,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=preferences.edit();
        editor.putBoolean(Key, booleanValue);
        editor.commit();
    }
    public void set(String Key,int Value)
    {
        SharedPreferences preferences=context.getSharedPreferences(FileName,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=preferences.edit();
        editor.putInt(Key, Value);
        editor.commit();
    }

    public void set(String Key,Long Value)
    {
        SharedPreferences preferences=context.getSharedPreferences(FileName,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=preferences.edit();
        editor.putLong(Key, Value);
        editor.commit();
    }


    public String getString(String Key)
    {
        SharedPreferences preferences =context.getSharedPreferences(FileName, Context.MODE_PRIVATE);
        String getString=preferences.getString(Key, "");
        return getString;
    }
    public String getString(String Key,String NoFind)
    {
        SharedPreferences preferences =context.getSharedPreferences(FileName, Context.MODE_PRIVATE);
        String getString=preferences.getString(Key, NoFind);
        return getString;
    }
    public int getInt(String Key)
    {
        SharedPreferences preferences =context.getSharedPreferences(FileName, Context.MODE_PRIVATE);
        int getint=preferences.getInt(Key, 0);
        return getint;
    }

    public Long getLong(String Key)
    {
        SharedPreferences preferences =context.getSharedPreferences(FileName, Context.MODE_PRIVATE);
        Long getint=preferences.getLong(Key, 0);
        return getint;
    }
    public int getInt(String Key,int ifNotFind)
    {
        SharedPreferences preferences =context.getSharedPreferences(FileName, Context.MODE_PRIVATE);
        int getint=preferences.getInt(Key, ifNotFind);
        return getint;
    }






    public boolean getBoolean(String key)
    {
        SharedPreferences share=context.getSharedPreferences(FileName, Context.MODE_PRIVATE);
        boolean is=share.getBoolean(key, false);
        return is;
    }



}