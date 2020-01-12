package ir.git.samir.Utils.Views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import net.steamcrafted.materialiconlib.MaterialDrawableBuilder;

import static android.util.TypedValue.COMPLEX_UNIT_DIP;
import static android.util.TypedValue.applyDimension;


public class MyMatiralIcon extends ImageView {

    private MaterialDrawableBuilder mBuilder;
    private Drawable mDrawable;
    private MaterialDrawableBuilder.IconValue mIcon;
    private int mOverruledSize = -1;

    private static final int ACTIONBAR_HEIGHT_DP = 24;

    public MyMatiralIcon(Context context) {
        super(context);
        init();
    }

    public MyMatiralIcon(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context, attrs);
    }

    public MyMatiralIcon(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        init(context, attrs);
    }

    static int convertDpToPx(Context context, float dp) {
        return (int) applyDimension(COMPLEX_UNIT_DIP, dp,
                context.getResources().getDisplayMetrics());
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if(mDrawable == null){
            int size = convertDpToPx(getContext(), 24);
            final int width = MeasureSpec.getMode(widthMeasureSpec);
            final int height = MeasureSpec.getMode(heightMeasureSpec);

            int paddinghori = getPaddingLeft() + getPaddingRight();
            int paddingvert = getPaddingTop() + getPaddingBottom();

            if(width == MeasureSpec.UNSPECIFIED && height == MeasureSpec.UNSPECIFIED){
                // do nothing, just default 24 dp size
            }else if(width == MeasureSpec.UNSPECIFIED){
                size = MeasureSpec.getSize(heightMeasureSpec) - paddingvert;
            }else if(height == MeasureSpec.UNSPECIFIED){
                size = MeasureSpec.getSize(widthMeasureSpec) - paddinghori;
            }else{
                size = Math.min(MeasureSpec.getSize(heightMeasureSpec) - paddingvert,
                        MeasureSpec.getSize(widthMeasureSpec) - paddinghori);
            }
            size = Math.max(0, size);
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            regenerateDrawable();
        }else{
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }

    }

    private void init(){
        mBuilder = MaterialDrawableBuilder.with(getContext());
    }

    private void init(Context context, AttributeSet attrs){
        init();

        TypedArray array = context.obtainStyledAttributes(attrs, net.steamcrafted.materialiconlib.R.styleable.MaterialIconViewFormat);
        try {
            int type = array.getInt(net.steamcrafted.materialiconlib.R.styleable.MaterialIconViewFormat_materialIcon, 0);

            if(type >= 0) setIcon(type);
        } catch (Exception e){

        }
        try {
            int color = array.getColor(net.steamcrafted.materialiconlib.R.styleable.MaterialIconViewFormat_materialIconColor, Color.BLACK);

            setColor(color);
        } catch (Exception e){

        }
        try {
            int size = array.getDimensionPixelSize(net.steamcrafted.materialiconlib.R.styleable.MaterialIconViewFormat_materialIconSize, -1);

            if(size >= 0) setSizePx(size);
        } catch (Exception e){

        }

        array.recycle();
    }

    public void setIcon(int iconIndex){
        setIcon(MaterialDrawableBuilder.IconValue.values()[iconIndex]);
    }

    public void setIcon(MaterialDrawableBuilder.IconValue iconValue){
        mIcon = iconValue;
        mBuilder.setIcon(iconValue);
        regenerateDrawable();
    }

    /**
     * Set the size of this icon to the standard Android ActionBar.
     *
     * @return The current IconDrawable for chaining.
     */
    public void setToActionbarSize() {
        setSizeDp(ACTIONBAR_HEIGHT_DP);
    }

    /**
     * Set the size of the drawable.
     *
     * @param dimenRes The dimension resource.
     * @return The current IconDrawable for chaining.
     */
    public void setSizeResource(int dimenRes) {
        mBuilder.setSizeResource(dimenRes);
        mOverruledSize = (getContext().getResources().getDimensionPixelSize(dimenRes));
        regenerateDrawable();
    }

    /**
     * Set the size of the drawable.
     *
     * @param size The size in density-independent pixels (dp).
     * @return The current IconDrawable for chaining.
     */
    public void setSizeDp(int size) {
        mBuilder.setSizeDp(size);
        mOverruledSize = convertDpToPx(getContext(), size);
        regenerateDrawable();
    }

    /**
     * Set the size of the drawable.
     *
     * @param size The size in pixels (px).
     * @return The current IconDrawable for chaining.
     */
    public void setSizePx(int size) {
        mBuilder.setSizePx(size);
        mOverruledSize = size;
        regenerateDrawable();
    }

    /**
     * Set the color of the drawable.
     *
     * @param color The color, usually from android.graphics.Color or 0xFF012345.
     * @return The current IconDrawable for chaining.
     */
    public void setColor(int color) {
        mBuilder.setColor(color);
        regenerateDrawable();
    }

    /**
     * Set the color of the drawable.
     *
     * @param colorRes The color resource, from your R file.
     * @return The current IconDrawable for chaining.
     */
    public void setColorResource(int colorRes) {
        mBuilder.setColorResource(colorRes);
        regenerateDrawable();
    }

    /**
     * Sets paint style.
     *
     * @param style to be applied
     */
    public void setStyle(Paint.Style style) {
        mBuilder.setStyle(style);
        regenerateDrawable();
    }

    private void regenerateDrawable(){
        if(mIcon != null){
            mDrawable = mBuilder.build();
            super.setImageDrawable(mDrawable);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (getWidth() == 0 || getHeight() == 0) return;

        int scaledWidth = getMeasuredWidth();
        int scaledHeight = getMeasuredHeight();
        int scaleddimen = (mOverruledSize >= 0) ? mOverruledSize : Math.min(scaledHeight, scaledWidth);

        boolean redraw = false;
        if(mDrawable == null){
            redraw = true;
        }else{
            int initialdimen = Math.min(mDrawable.getIntrinsicHeight(), mDrawable.getIntrinsicHeight());
            if(initialdimen != scaleddimen){
                redraw = true;
            }
        }

        if(redraw){
            if(mOverruledSize >= 0){
                mBuilder.setSizePx(mOverruledSize);
            }else{
                mBuilder.setSizePx(scaleddimen);
            }
            regenerateDrawable();
        }

        super.onDraw(canvas);
    }


}