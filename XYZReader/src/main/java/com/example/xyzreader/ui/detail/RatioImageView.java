package com.example.xyzreader.ui.detail;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.ImageView;

@SuppressLint("AppCompatCustomView")
public class RatioImageView extends ImageView {
    public RatioImageView(Context context) {
        super(context);
    }
    
    public RatioImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    
    public RatioImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public RatioImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int
            defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
    
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = (int) (measuredWidth * (2f / 3f));
        setMeasuredDimension(measuredWidth, measuredHeight);
    }
}
