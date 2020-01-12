package ir.git.samir.Parents;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.LayoutRes;
import ir.git.samir.R;
import ir.git.samir.Utils.MyToolBar;
import ir.git.samir.Utils.SweetAlert.SweeftLoading;

public class ParentMyToolbar extends ParentBase {

    public Context context;

    MyToolBar myToolBar;

    FrameLayout frameLayout;
    SweeftLoading loading_view;

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);

        context = this;

        try {
            myToolBar = (MyToolBar) findViewById(R.id.tbar);

            myToolBar.setClickiconAlone(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });

        } catch (Exception ex) {

        }

        try{
            frameLayout = (FrameLayout) findViewById(R.id.frameLayout);
            loading_view = (SweeftLoading) findViewById(R.id.loading_view);

            // remember i commented this code because there's no any loading_view somewhere, and if i gonna use this i should uncomment this code
            // first i have to write code like this :

//        <artmis.org.template.Utils.SweetAlert.SweeftLoading
//            android:id="@+id/loading_view"
//            android:layout_width="match_parent"
//            android:layout_height="match_parent" />

            // afterward i gonna uncomment this code next run

        }catch (Exception ex){

        }

//
//            <FrameLayout
//        android:id="@+id/frameLayout"
//        android:layout_width="match_parent"
//        android:layout_height="match_parent"
//        android:visibility="visible">
//
//        <android.support.v7.widget.RecyclerView
//        android:id="@+id/rv"
//        android:layout_width="match_parent"
//        android:layout_height="match_parent"
//        android:layout_marginTop="8dp" />
//
//
//        <artmis.org.template.Utils.SweetAlert.SweeftLoading
//        android:id="@+id/loading_view"
//        android:layout_width="match_parent"
//        android:layout_height="match_parent" />
//
//    </FrameLayout>
//

    }

    public void showLoading() {


        frameLayout.getChildAt(1).setVisibility(View.VISIBLE);
        frameLayout.getChildAt(0).setVisibility(View.GONE);


        loading_view.changeAlertType(SweeftLoading.PROGRESS_TYPE);

        loading_view.setContentText("");

        loading_view.setTitleText(getString(R.string.loading));

        loading_view.showContentText(false);

        loading_view.showCancelButton(false);

    }


    public void errorLoading(SweeftLoading.OnSweetClickListener listener) {

        loading_view.changeAlertType(SweeftLoading.ERROR_TYPE);
        loading_view.setTitleText(getString(R.string.error_message));
        loading_view.setContentText(getString(R.string.error_message_content));
        loading_view.setConfirmText(getString(R.string.tryagin));
        loading_view.setConfirmClickListener(listener);
        loading_view.showContentText(true);

        loading_view.showCancelButton(false);

    }

    public void hideLoading() {
        frameLayout.getChildAt(0).setVisibility(View.VISIBLE);
        frameLayout.getChildAt(1).setVisibility(View.GONE);

    }


    public MyToolBar toolBar() {
        return myToolBar;
    }


    public void showWarningLoading(String s, String title)
    {
        showWaningLoading(title,"");
    }

    public void showWaningLoading(String title,String content)
    {
        loading_view.changeAlertType(SweeftLoading.WARNING_TYPE);
        loading_view.setTitleText(title);
        loading_view.setContentText(content);
        loading_view.showContentText(false);
        loading_view.showCancelButton(false);
    }
}
