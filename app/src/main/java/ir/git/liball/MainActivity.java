package ir.git.liball;

import android.os.Bundle;
import ir.git.samir.Enums.FontType;
import ir.git.samir.Parents.ParentBase;
import ir.git.samir.Utils.loading.LoadingSweet;

public class MainActivity extends ParentBase {


    LoadingSweet loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loading = new LoadingSweet(this);

        showToast(FontType.IRANSANS_Bold);

        loading.waiting(new LoadingSweet.OnCancelClick() {
            @Override
            public void cancel() {
                loading.cancel();
            }
        });
    }
}
