package org.levimc.launcher.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RenderEffect;
import android.graphics.Shader;
import android.os.Build;
import android.util.AttributeSet;

import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatButton;

import org.levimc.launcher.R;

/**
 * GlassButton - A custom button with glass morphism (liquid glass) effect
 * Extends AppCompatButton to maintain Material Design compatibility
 */
public class GlassButton extends AppCompatButton {
    private float blurRadius = 15f;
    private float alpha = 0.7f;
    private int glassBackgroundColor = 0x80FFFFFF; // Default: semi-transparent white
    private Paint paint;

    public GlassButton(Context context) {
        super(context);
        init(context, null);
    }

    public GlassButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public GlassButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        paint = new Paint();
        paint.setAntiAlias(true);

        if (attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.GlassButton);
            blurRadius = a.getFloat(R.styleable.GlassButton_glassBlurRadius, 15f);
            alpha = a.getFloat(R.styleable.GlassButton_glassAlpha, 0.7f);
            glassBackgroundColor = a.getColor(R.styleable.GlassButton_glassBackgroundColor, 0x80FFFFFF);
            a.recycle();
        }

        // Apply blur effect for Android 12+
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            applyBlurEffect();
        }

        // Set text color to white for visibility on glass background
        setTextColor(0xFFFFFFFF);
    }

    @RequiresApi(Build.VERSION_CODES.S)
    private void applyBlurEffect() {
        RenderEffect blurEffect = RenderEffect.createBlurEffect(blurRadius, blurRadius, Shader.TileMode.CLAMP);
        this.setRenderEffect(blurEffect);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // Draw glass background before text
        drawGlassBackground(canvas);
        super.onDraw(canvas);
    }

    private void drawGlassBackground(Canvas canvas) {
        int color = glassBackgroundColor;
        int a = Math.round(alpha * 255);
        int finalColor = (a << 24) | (color & 0x00FFFFFF);
        paint.setColor(finalColor);

        // Draw rounded rectangle for glass effect
        float radius = getHeight() / 2f;
        canvas.drawRoundRect(0, 0, getWidth(), getHeight(), radius, radius, paint);
    }

    public void setBlurRadius(float blurRadius) {
        this.blurRadius = blurRadius;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            applyBlurEffect();
        }
    }

    public void setGlassAlpha(float alpha) {
        this.alpha = alpha;
        invalidate();
    }

    public void setGlassBackgroundColor(int color) {
        this.glassBackgroundColor = color;
        invalidate();
    }

    public float getBlurRadius() {
        return blurRadius;
    }

    public float getGlassAlpha() {
        return alpha;
    }

    public int getGlassBackgroundColor() {
        return glassBackgroundColor;
    }
}
