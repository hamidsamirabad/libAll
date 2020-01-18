package ir.git.samir.Parents;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.snackbar.Snackbar;
import ir.git.samir.Lib;
import ir.git.samir.R;
import ir.git.samir.Utils.FullScreenActivity;


/**
 * Created by NP on 10/6/2016.
 */
public class ParentBase extends AppCompatActivity {

    public Context context;

    @Override
    protected void onResume() {
        super.onResume();
        context = this;
        Lib.context=this;
        Lib.activity=this;
        Lib.view=this.getWindow().getDecorView().findViewById(android.R.id.content);
    }

    public void fullScreen(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
           new FullScreenActivity().setWindowFlag(this);
        }
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        Lib.context=this;
        context = this;
        Lib.activity=this;
        Lib.view=this.getWindow().getDecorView().findViewById(android.R.id.content);
    }

    public void showToast(String text)
    {
        Toast toast = Toast.makeText(this,text, Toast.LENGTH_LONG);
        LinearLayout toastLayout = (LinearLayout) toast.getView();
        TextView toastTV = (TextView) toastLayout.getChildAt(0);
        Typeface typeface = Typeface.createFromAsset(this.getAssets(),"fonts/fa.ttf");
        toastTV.setTypeface(typeface);
        toast.show();
    }

    public void showMessage(String text)
    {
        Snackbar mSnackBar = Snackbar.make(Lib.view, text, Snackbar.LENGTH_SHORT);
        TextView tv = (TextView) (mSnackBar.getView()).findViewById(R.id.snackbar_text);
        Typeface font = Typeface.createFromAsset(Lib.context.getAssets(), "fonts/fa.ttf");
        tv.setTypeface(font);
        mSnackBar.show();
    }


    public void showFragment(Fragment frg, int layout )
    {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(layout, frg).commit();
    }


    public void print(String text){
        Log.i("Info",text);
    }

}
