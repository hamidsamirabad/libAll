package ir.git.samir.Utils.loading;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import ir.git.samir.R;

public class LoadingView extends LinearLayout {

	Context context;
	View view;

	View btn_try,btn_cancel;

	View layout_error,layout_waiting;

	FrameLayout frameLayout;

	TextView text_message;

	public LoadingView(final Context context) {
		super(context);
		initialize(context);
	}

	public LoadingView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initialize(context);
	}

	private void initialize(Context context) {

		this.context = context;
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		view = inflater.inflate(R.layout.obj_loading_view, this, true);

		btn_try=  findViewById(R.id.btn_try);
		btn_cancel= findViewById(R.id.btn_cancel);

		text_message = (TextView) view.findViewById(R.id.text_message);

		layout_error=findViewById(R.id.layout_error);
		layout_waiting=findViewById(R.id.layout_waiting);

	}

	public void setFrameLayout(FrameLayout frameLayout)
	{
		this.frameLayout=frameLayout;
	}

	public void clickTry(OnClickListener onClickListener)
	{
		btn_try.setOnClickListener(onClickListener);
	}

	public void clickCancel(OnClickListener onClickListener)
	{
		btn_cancel.setOnClickListener(onClickListener);
	}

	public void showCancel(boolean is)
	{
		if(is)
		{
			btn_cancel.setVisibility(View.VISIBLE);
		}else{
			btn_cancel.setVisibility(View.GONE);
		}
	}

	public void error()
	{
		layout_error.setVisibility(View.VISIBLE);
		layout_waiting.setVisibility(View.GONE);


		frameLayout.getChildAt(0).setVisibility(View.GONE);
		frameLayout.getChildAt(1).setVisibility(View.VISIBLE);
		text_message.setVisibility(View.GONE);
	}

	public void waiting()
	{
		layout_waiting.setVisibility(View.VISIBLE);
		layout_error.setVisibility(View.GONE);
		text_message.setVisibility(View.GONE);

		frameLayout.getChildAt(0).setVisibility(View.GONE);
		frameLayout.getChildAt(1).setVisibility(View.VISIBLE);

	}


	public void success()
	{
		frameLayout.getChildAt(0).setVisibility(View.VISIBLE);
		frameLayout.getChildAt(1).setVisibility(View.GONE);
		text_message.setVisibility(View.GONE);
	}


	public void setMessage(String message) {

		frameLayout.getChildAt(0).setVisibility(View.GONE);
		frameLayout.getChildAt(1).setVisibility(View.VISIBLE);

		layout_waiting.setVisibility(View.GONE);
		layout_error.setVisibility(View.GONE);
		text_message.setVisibility(View.VISIBLE);

		text_message.setText(message);

	}
}
