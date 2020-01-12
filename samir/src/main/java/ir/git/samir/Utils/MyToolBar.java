package ir.git.samir.Utils;


import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import ir.git.samir.R;
import net.steamcrafted.materialiconlib.MaterialDrawableBuilder;
import net.steamcrafted.materialiconlib.MaterialIconView;

public class MyToolBar extends LinearLayout {

    Context context;
    View view;


    MaterialIconView iconA;
    MaterialIconView iconB;
    MaterialIconView iconC;
    TextView textBtn;
    TextView textTitle;
    MaterialIconView iconAlone;
    ImageView LogoImage;


    //------------------------

    View viewA;
    View viewB;
    View viewC;


    public MyToolBar(Context context) {
        super(context);
        initialize(context);

    }

    public MyToolBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize(context);

    }

    public MyToolBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize(context);

    }

    @TargetApi(value = Build.VERSION_CODES.LOLLIPOP)
    public MyToolBar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        initialize(context);


        LogoImage.setVisibility(View.GONE);

    }


    private void initialize(Context context) {


        this.context = context;
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(LanguageManeger.isRight() ? R.layout.toolbar_right : R.layout.toolbar_left, this, true);

        iconA = view.findViewById(R.id.iconA);
        iconB = view.findViewById(R.id.iconB);
        iconC = view.findViewById(R.id.iconC);
        textBtn = view.findViewById(R.id.textBtn);
        textTitle = view.findViewById(R.id.textTitle);
        iconAlone = view.findViewById(R.id.iconAlone);
        LogoImage = view.findViewById(R.id.LogoImage);

        viewA = view.findViewById(R.id.viewA);
        viewB = view.findViewById(R.id.viewB);
        viewC = view.findViewById(R.id.viewC);

        iconA.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                listener_a.onClick(view);
            }
        });

        iconC.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                listener_c.onClick(view);
            }
        });

        iconB.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                listener_b.onClick(view);
            }
        });

        textBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    if (iconA.getVisibility() == VISIBLE) {
                        listener_a.onClick(v);
                    }
                } catch (Exception ex) {

                }
            }
        });

iconAlone.setOnClickListener(new OnClickListener() {
    @Override
    public void onClick(View view) {
        listener_iconAlone.onClick(view);
    }
});


        textTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    if (iconAlone.getVisibility() == VISIBLE) {
                        listener_iconAlone.onClick(v);
                    }
                } catch (Exception ex) {

                }
            }
        });


    }


    public void setTitleBar(String title) {

        textTitle.setText(title.trim());
    }

    public void setTextBtn(String text) {
        textBtn.setVisibility(View.VISIBLE);
        textBtn.setText(text.trim());
    }







    View.OnClickListener listener_a;
    View.OnClickListener listener_b;
    View.OnClickListener listener_c;

    public void setClickA(MaterialDrawableBuilder.IconValue iconValue, View.OnClickListener listener) {
        iconA.setVisibility(View.VISIBLE);
        viewA.setVisibility(View.VISIBLE);
        iconA.setIcon(iconValue);
        listener_a = listener;

    }

    public void setClickB(MaterialDrawableBuilder.IconValue iconValue, View.OnClickListener listener) {
        iconB.setVisibility(View.VISIBLE);
        viewB.setVisibility(View.VISIBLE);
        iconB.setIcon(iconValue);
        listener_b = listener;

    }

    public void setClickC(MaterialDrawableBuilder.IconValue iconValue, View.OnClickListener listener) {
        iconC.setVisibility(View.VISIBLE);
        viewC.setVisibility(View.VISIBLE);
        iconC.setIcon(iconValue);
        listener_c = listener;

    }



    View.OnClickListener listener_iconAlone;

    public void setClickiconAlone(View.OnClickListener listener) {


        listener_iconAlone = listener;

    }


    public void hideAllIcons() {


        iconC.setVisibility(View.GONE);
        iconA.setVisibility(View.GONE);
        iconB.setVisibility(View.GONE);

        viewA.setVisibility(View.GONE);
        viewB.setVisibility(View.GONE);
        viewC.setVisibility(View.GONE);

        textBtn.setVisibility(View.GONE);
    }




}
