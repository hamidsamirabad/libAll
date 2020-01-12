package ir.git.samir.Utils.Views;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.balysv.materialripple.MaterialRippleLayout;
import ir.git.samir.R;


public class cv_ripButton extends LinearLayout {

    Context context;
    View view;
    TextView text;

    MyMatiralIcon iocnview;

    int color ;

    MaterialRippleLayout click;
    View btn;
    GradientDrawable drawable;

    public cv_ripButton(Context context) {
        super(context);
        initialize(context);

    }

    public cv_ripButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize(context);
        init(attrs);
    }

    public cv_ripButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize(context);
        init(attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public cv_ripButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        initialize(context);
        init(attrs);
    }

    private void initialize(Context context) {

        this.context = context;
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.cv_ripbutton, this, true);

        click= (MaterialRippleLayout) findViewById(R.id.click);
        btn=  findViewById(R.id.btn);
        text= (TextView) findViewById(R.id.text);
        iocnview= (MyMatiralIcon) findViewById(R.id.iocnview);

        btn.setBackgroundResource(R.drawable.gradiant_app_round);
        drawable = (GradientDrawable) btn.getBackground();

        iocnview.setVisibility(View.GONE);

    }

    @Override
    public void setBackgroundColor(int color) {
        //drawable.setColor(color);
    }

    @Override
    public void setOnClickListener(OnClickListener onClickListener) {
        click.setOnClickListener(onClickListener);
    }

    public String getText(){
        return text.getText().toString().trim();
    }

    public void setText(String message)
    {
        text.setText(message);
    }
    public void setText(CharSequence message)
    {
        text.setText(message);
    }

    private void init(AttributeSet attrs) {
        try {

            TypedArray array = context.obtainStyledAttributes(attrs, net.steamcrafted.materialiconlib.R.styleable.MaterialIconViewFormat);
                      try {
                int type = array.getInt(net.steamcrafted.materialiconlib.R.styleable.MaterialIconViewFormat_materialIcon, 0);

                if(type > 0){
                    iocnview.setIcon(type);
                    iocnview.setVisibility(View.VISIBLE);
                }else{
                    iocnview.setVisibility(View.GONE);
                }
            } catch (Exception e){
                iocnview.setVisibility(View.GONE);
            }




            TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.cvs, 0, 0);

            if (ta.hasValue(R.styleable.cvs_title)) {
                text.setText(ta.getString(R.styleable.cvs_title));
            }else{
                text.setText("Test Button");
            }


            if (ta.hasValue(R.styleable.cvs_colortxt)) {
                text.setTextColor(ta.getColor(R.styleable.cvs_colortxt,Color.WHITE));
            }else{

            }

            try {
               // int color = array.getColor(net.steamcrafted.materialiconlib.R.styleable.MaterialIconViewFormat_materialIconColor, Color.WHITE);
                if (ta.hasValue(R.styleable.cvs_colortxt)) {
                    iocnview.setColor(ta.getColor(R.styleable.cvs_colortxt,Color.WHITE));
                }
            } catch (Exception e){
            }



            if (ta.hasValue(R.styleable.cvs_showIcon)) {
                if( ta.getBoolean(R.styleable.cvs_showIcon,false)){
                    iocnview.setVisibility(View.GONE);
                }
            }



            if (ta.hasValue(R.styleable.cvs_color)) {

                color = ta.getColor(R.styleable.cvs_color,0);
               //
            }else{



//        drawable.setColor(getResources().getColor(R.color.primary));
              //  drawable.setColor(getResources().getColor(R.color.colorPrimary));
//        btn.setBackgroundColor(getResources().getColor(R.color.primary));
            }

//            btn.setText("Test Button");


            ta.recycle();

        } catch (Exception ex) {

        }

    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        click.setEnabled(enabled);
        if(enabled==false){

          //  drawable.setColor(Color.parseColor("#bdbdbd"));
        }else{
           // drawable.setColor(color);
        }

    }


    public void setColor(String color){
        try{
            //.setColor(Color.parseColor(color));
        }catch (Exception c){
           // drawable.setColor(getResources().getColor(R.color.colorPrimary));
        }

    }


    public void setTextColor(String color){

        text.setTextColor(Color.parseColor(color));

    }

}
