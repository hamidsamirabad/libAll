package ir.git.liball;

import android.os.Bundle;
import ir.git.samir.Parents.ParentBase;
import ir.git.samir.Utils.loading.LoadingSweet;

public class MainActivity extends ParentBase {


    LoadingSweet loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loading = new LoadingSweet(this);

        loading.waiting(new LoadingSweet.OnCancelClick() {
            @Override
            public void cancel() {
                loading.cancel();
            }
        });
    }
}
