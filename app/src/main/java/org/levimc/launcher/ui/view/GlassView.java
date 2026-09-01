package org.levimc.launcher.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RenderEffect;
import android.graphics.Shader;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.RequiresApi;

import org.levimc.launcher.R;

/**
 * GlassView - A custom view that applies glass morphism (liquid glass) effect
 * Uses blur and transparency to create a modern frosted glass appearance
 */
public class GlassView extends View {
    private float blurRadius = 15f;
    private float alpha = 0.7f;
    private int backgroundColor = 0x80FFFFFF; // Default: semi-transparent white
    private Paint paint;

    public GlassView(Context context) {
        super(context);
        init(context, null);
    }

    public GlassView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public GlassView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        paint = new Paint();
        paint.setAntiAlias(true);

        if (attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.GlassView);
            blurRadius = a.getFloat(R.styleable.GlassView_glassBlurRadius, 15f);
            alpha = a.getFloat(R.styleable.GlassView_glassAlpha, 0.7f);
            backgroundColor = a.getColor(R.styleable.GlassView_glassBackgroundColor, 0x80FFFFFF);
            a.recycle();
        }

        // Apply blur effect for Android 12+
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            applyBlurEffect();
        }
    }

    @RequiresApi(Build.VERSION_CODES.S)
    private void applyBlurEffect() {
        RenderEffect blurEffect = RenderEffect.createBlurEffect(blurRadius, blurRadius, Shader.TileMode.CLAMP);
        this.setRenderEffect(blurEffect);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        
        // Set the paint color with alpha
        int color = backgroundColor;
        int a = Math.round(alpha * 255);
        int finalColor = (a << 24) | (color & 0x00FFFFFF);
        paint.setColor(finalColor);
        
        // Draw rounded rectangle for glass effect
        float radius = 20f;
        canvas.drawRoundRect(0, 0, getWidth(), getHeight(), radius, radius, paint);
    }

    public void setBlurRadius(float blurRadius) {
        this.blurRadius = blurRadius;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            applyBlurEffect();
        }
    }

    public void setAlpha(float alpha) {
        this.alpha = alpha;
        invalidate();
    }

    public void setGlassBackgroundColor(int color) {
        this.backgroundColor = color;
        invalidate();
    }

    public float getBlurRadius() {
        return blurRadius;
    }

    public float getGlassAlpha() {
        return alpha;
    }

    public int getGlassBackgroundColor() {
        return backgroundColor;
    }
}
