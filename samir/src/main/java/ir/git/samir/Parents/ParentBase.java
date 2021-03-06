package ir.git.samir.Parents;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.snackbar.Snackbar;
import ir.git.samir.Lib;
import ir.git.samir.R;


/**
 * Created by NP on 10/6/2016.
 */
public class ParentBase extends AppCompatActivity {

    public Context context;
    public static RequestPermissionHandler requestPermission;

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
            setWindowFlag(this);
        }
    }

    public final void setWindowFlag( Activity act) {
        if (Build.VERSION.SDK_INT >= 19) {
            int bits = 201326592;
            Window win = act.getWindow();

            WindowManager.LayoutParams winParams = win.getAttributes();
            winParams.flags &= ~bits;
            win.setAttributes(winParams);
            if (Build.VERSION.SDK_INT >= 21) {
                Window var10000 = act.getWindow();
                var10000.setStatusBarColor(0);
            }
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


    public void askPermissonFor(String permissionId,boolean isAskAgain, RequestPermissionListener listener) {
        askPermissonFor(new String[]{permissionId},isAskAgain,listener);
    }

    public void askPermissonFor(String permissionId, RequestPermissionListener listener) {
        askPermissonFor(new String[]{permissionId},false,listener);
    }

    public void askPermissonFor(String[] permissionIds, RequestPermissionListener listener) {
        askPermissonFor(permissionIds,false,listener);
    }

    public void askPermissonFor(final String[] permissionIds, final boolean isAskAgain, final RequestPermissionListener listener) {

        requestPermission = new RequestPermissionHandler();

        requestPermission.requestPermission(this, permissionIds, 10007, new RequestPermissionHandler.RequestPermissionListener() {
            @Override
            public void onSuccess() {

                if(listener!=null){
                    listener.onSuccess();
                }

            }

            @Override
            public void onFailed() {
                if(isAskAgain)
                {
                    askPermissonFor(permissionIds,isAskAgain,listener);
                }

                showToast("کاربر گرامی، برای دسترسی به این قسمت باید اجازه دسترسی به نرم افزار بدهید");

            }
        });


    }



    public void print(String text){
        Log.i("Info",text);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        requestPermission.onRequestPermissionsResult(requestCode, permissions,
                grantResults);
    }

    public interface RequestPermissionListener {
        void onSuccess();
    }

}
