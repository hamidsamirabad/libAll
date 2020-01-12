package ir.git.samir.Utils.loading;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import ir.git.samir.R;
import ir.git.samir.Utils.SweetAlert.SweetAlertDialog;

/**
 * Created by Royal on 9/24/2017.
 */

public class LoadingSweet {

    SweetAlertDialog dialog;

    Context context;


    public LoadingSweet(Context context) {

        this.context = context;


        dialog = new SweetAlertDialog(context);

        dialog.setCancelable(false);


    }


    public interface OnCancelClick {

        public void cancel();

    }

    public void rewaiting(final OnCancelClick cancelClick) {


        dialog.showCancelButton(true);

        dialog.changeAlertType(SweetAlertDialog.PROGRESS_TYPE);

        dialog.setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
            @Override
            public void onClick(SweetAlertDialog sweetAlertDialog) {
                dialog = sweetAlertDialog;
                dialog.cancel();
                cancelClick.cancel();
            }
        });

        dialog.showCancelButton(true);
        dialog.setCancelText(context.getString(R.string.cancel));


        dialog.setTitleText(context.getString(R.string.loading));

    }

    public void waiting(boolean isDialogLoading, final OnCancelClick cancelClick) {
        dialog = new SweetAlertDialog(context);

        dialog.showCancelButton(true);

        dialog.changeAlertType(SweetAlertDialog.PROGRESS_TYPE);

        dialog.setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
            @Override
            public void onClick(SweetAlertDialog sweetAlertDialog) {
                dialog = sweetAlertDialog;
                dialog.cancel();
                cancelClick.cancel();
            }
        });

        if (isDialogLoading) {
            try {

                dialog.showCancelButton(true);
                dialog.setCancelText(context.getString(R.string.cancel));

                dialog.setTitleText(context.getString(R.string.loading));

                if (!dialog.isShowing()) {
                    dialog.show();
                }
            } catch (Exception ex) {
                Log.i("ERRF",ex.getMessage());
            }
        }


    }

    public void waiting(final OnCancelClick cancelClick) {
        waiting(true, cancelClick);

    }

    public void error(final LisnterSweed listener) {

        dialog.changeAlertType(SweetAlertDialog.ERROR_TYPE);

        dialog.setTitleText(context.getString(R.string.error_message));
        dialog.setContentText(context.getString(R.string.error_message_content));

        dialog.setConfirmText(context.getString(R.string.tryagin));

        dialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
            @Override
            public void onClick(SweetAlertDialog sDialog) {
                dialog = sDialog;
                dialog.cancel();
                listener.clicked();
            }
        });

        dialog.showCancelButton(true);
        dialog.setCancelText(context.getString(R.string.cancel));

        if (!dialog.isShowing()) {
            dialog.show();
        }

    }


    public interface LisnterSweed {
        public void clicked();
    }


    private void msg(String title, String content, final LisnterSweed listener, int alertType) {
        dialog.changeAlertType(alertType);
        dialog.setTitleText(title);
        if (!content.equals("")) {
            dialog.showContentText(true);
            dialog.setContentText(content);
        } else {
            dialog.showContentText(false);
        }


        dialog.showCancelButton(false);

        dialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
            @Override
            public void onClick(SweetAlertDialog sDialog) {
                dialog = sDialog;
                sDialog.dismissWithAnimation();
                if (listener != null) {
                    listener.clicked();
                }

            }
        });

        dialog.setConfirmText(context.getString(R.string.ok));


        try {

            if (!dialog.isShowing()) {
                dialog.show();
            }

        } catch (Exception ex) {

        }

    }

    public void invalidData() {
        setWarning("", "کاربرگرامی متاسفانه اطلاعات شما نامعتبر است");
    }

    public void invalidConfirm() {
        setWarning("", "کاربرگرامی متاسفانه ثبت نشد");
    }

    public void invalidID() {
        setWarning("", "کاربرگرامی متاسفانه شناسه شما نامعتبر است");
    }


    public void setWarning(String title) {
        msg(title, "", null, SweetAlertDialog.WARNING_TYPE);
    }

    public void setWarning(String title, String content) {
        msg(title, content, null, SweetAlertDialog.WARNING_TYPE);
    }


    public void setWarning(String title, String content, final LisnterSweed listener) {
        msg(title, content, listener, SweetAlertDialog.WARNING_TYPE);
    }

    public void setMessage(String title) {
        msg(title, "", null, SweetAlertDialog.SUCCESS_TYPE);
    }

    public void setMessage(String title, String content) {
        msg(title, content, null, SweetAlertDialog.SUCCESS_TYPE);
    }


    public void setMessage(String title, String content, final LisnterSweed listener) {
        msg(title, content, listener, SweetAlertDialog.SUCCESS_TYPE);
    }


    public void setMessage(String title, final LisnterSweed listener) {
        msg(title, "", listener, SweetAlertDialog.SUCCESS_TYPE);
    }

    public void cancel() {
        dialog.cancel();
    }


}
