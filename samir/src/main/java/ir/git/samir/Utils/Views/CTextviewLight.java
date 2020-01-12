package ir.git.samir.Utils.Views;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;
import ir.git.samir.Lib;


/**
 * Created by NP on 5/30/2016.
 */
public class CTextviewLight extends TextView {
    public CTextviewLight(Context context) {
        super(context);
        setFont(context);

    }

    public CTextviewLight(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFont(context);
    }

    public CTextviewLight(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFont(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CTextviewLight(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setFont(context);
    }

    private void setFont(Context context)
    {
        setTypeface(Typeface.createFromAsset(Lib.context.getAssets(), "fonts/IRANSansMobile_Light.ttf"));

    }




}
