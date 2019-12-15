package com.view.animator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class STBView extends View {
    private Path path;
    private Path pathDoor;
    private Paint paint;
    private float baseLineY;
    private float baseLineMarginX;
    private RectF door;

    public STBView(Context context) {
        super(context);
    }

    public STBView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
        path = new Path();
        pathDoor = new Path();
    }

    public STBView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
        canvas.drawPath(path, paint);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);
        canvas.drawPath(pathDoor, paint);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(pathDoor, paint);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        baseLineY = h / 4 * 3;
        baseLineMarginX = w / 10;

        path.moveTo(baseLineMarginX, baseLineY);
        path.lineTo(w - baseLineMarginX, baseLineY);

        path.moveTo(baseLineMarginX + 100, baseLineY);
        path.lineTo(baseLineMarginX + 100, baseLineY - 600);
        path.lineTo(baseLineMarginX + 250, baseLineY - 620);
        path.lineTo(baseLineMarginX + 250, baseLineY);

        for (int i = 1; i <= 10; i++) {
            RectF rect = new RectF((int) baseLineMarginX + 100, (int) baseLineY - 560 + i * 40,
                    (int) baseLineMarginX + 200, (int) baseLineY - 560 + i * 40 + 20);
            path.addRect(rect, Path.Direction.CCW);
        }


        RectF right = new RectF(w - baseLineMarginX - 260, baseLineY - 400, w - baseLineMarginX - 100, baseLineY);
        path.addRect(right, Path.Direction.CCW);
        RectF rightMiddle = new RectF(w - baseLineMarginX - 260 + 20, baseLineY - 400 - 40,
                w - baseLineMarginX - 100 - 20, baseLineY - 400);
        path.addRect(rightMiddle, Path.Direction.CCW);
        RectF rightTop = new RectF(rightMiddle.centerX(), rightMiddle.centerY() - 80,
                rightMiddle.centerX(), rightMiddle.centerY() - 20);
        path.addRect(rightTop, Path.Direction.CCW);
        for (int i = 1; i <= 5; i++) {
            RectF f = new RectF(w - baseLineMarginX - 260 + i * 26, baseLineY - 400 + 40,
                    w - baseLineMarginX - 260 + i * 26, baseLineY);
            path.addRect(f, Path.Direction.CCW);
        }

        path.moveTo(baseLineMarginX + 400, baseLineY - 380);
        path.lineTo(w - baseLineMarginX - 420, baseLineY - 380);
        path.quadTo(w - baseLineMarginX - 410, baseLineY - 340, w - baseLineMarginX - 360, baseLineY - 320);
        path.lineTo(baseLineMarginX + 340, baseLineY - 320);
        path.quadTo(baseLineMarginX + 410, baseLineY - 340, baseLineMarginX + 400, baseLineY - 380);

        RectF rectF = new RectF(baseLineMarginX + 380, baseLineY - 320,
                w - baseLineMarginX - 400, baseLineY - 290);
        path.addRect(rectF, Path.Direction.CCW);
        path.moveTo(rectF.left, rectF.bottom);
        path.lineTo(rectF.right, rectF.bottom);
        path.quadTo(rectF.right, rectF.bottom + 20, rectF.right + 80, rectF.bottom + 30);
        path.lineTo(rectF.left - 80, rectF.bottom + 30);
        path.quadTo(rectF.left, rectF.bottom + 20, rectF.left, rectF.bottom);

        RectF rect = new RectF(baseLineMarginX + 380 - 30, baseLineY - 320 + 60,
                w - baseLineMarginX - 400 + 30, baseLineY - 290 + 60);
        path.addRect(rect, Path.Direction.CCW);
        RectF rectNext = new RectF(rect);
        rectNext.bottom = rectNext.bottom + 20;
        rectNext.offset(0, 30);
        path.addRect(rectNext, Path.Direction.CCW);
        door = new RectF(baseLineMarginX + 230, rectNext.bottom,
                w - baseLineMarginX - 225, baseLineY);
        pathDoor.addRect(door, Path.Direction.CCW);
        pathDoor.moveTo(door.left, door.top + 20);
        pathDoor.lineTo(door.right, door.top + 20);
        pathDoor.moveTo(door.centerX() + 40, baseLineY);
        pathDoor.lineTo(door.centerX() + 40, baseLineY - 90);
        pathDoor.quadTo(door.centerX(), baseLineY - 140, door.centerX() - 40, baseLineY - 90);
        pathDoor.lineTo(door.centerX() - 40, baseLineY);

        pathDoor.moveTo(door.centerX() + 100 + 60, baseLineY);
        pathDoor.lineTo(door.centerX() + 100 + 60, baseLineY - 70);
        pathDoor.quadTo(door.centerX() + 100 + 30, baseLineY - 120,
                door.centerX() + 100, baseLineY - 70);
        pathDoor.lineTo(door.centerX() + 100, baseLineY);
        pathDoor.moveTo(door.centerX() - 100 - 60, baseLineY);
        pathDoor.lineTo(door.centerX() - 100 - 60, baseLineY - 70);
        pathDoor.quadTo(door.centerX() - 100 - 30, baseLineY - 120,
                door.centerX() - 100, baseLineY - 70);
        pathDoor.lineTo(door.centerX() - 100, baseLineY);

        pathDoor.moveTo(door.centerX() + 210 + 60, baseLineY);
        pathDoor.lineTo(door.centerX() + 210 + 60, baseLineY - 70);
        pathDoor.quadTo(door.centerX() + 210 + 30, baseLineY - 120,
                door.centerX() + 210, baseLineY - 70);
        pathDoor.lineTo(door.centerX() + 210, baseLineY);
        pathDoor.moveTo(door.centerX() - 210 - 60, baseLineY);
        pathDoor.lineTo(door.centerX() - 210 - 60, baseLineY - 70);
        pathDoor.quadTo(door.centerX() - 210 - 30, baseLineY - 120,
                door.centerX() - 210, baseLineY - 70);
        pathDoor.lineTo(door.centerX() - 210, baseLineY);
    }
}
