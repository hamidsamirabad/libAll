package ir.git.liball;

import android.Manifest;
import android.os.Bundle;
import android.view.View;
import android.webkit.PermissionRequest;
import ir.git.samir.Enums.FontType;
import ir.git.samir.Parents.ParentBase;
import ir.git.samir.Utils.loading.LoadingSweet;

import java.security.Permission;
import java.security.Permissions;

public class MainActivity extends ParentBase {


    LoadingSweet loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        showToast(FontType.IRANSANS_Bold);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                askPermissonFor(Manifest.permission.CAMERA, new RequestPermissionListener() {
                    @Override
                    public void onSuccess() {

                    }
                });
            }
        });



    }
}
