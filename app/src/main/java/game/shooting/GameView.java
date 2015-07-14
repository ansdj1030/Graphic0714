package game.shooting;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import study.graphic0714.R;

/**
 * Created by moonsunhun on 2015-07-14.
 */
public class GameView extends View {
    Bitmap pacman;
    int posX;
    int posY;
    //조이스틱 크기
    RectF[] control = new RectF[5];
    int conW = 150;
    int conH = 150;

    Paint paint;

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public GameView(Context context) {
        super(context);
        init();
    }

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public void init() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pacman);
        pacman = Bitmap.createScaledBitmap(bitmap, 200, 200, false);
        paint = new Paint();
        paint.setColor(Color.BLUE);
        control[0] = new RectF(200, 1000, 200 + conW, 1000 + conH);
        control[1] = new RectF(200, 1200, 200 + conW, 1200 + conH);
        control[2] = new RectF(0, 1200, 0 + conW, 1200 + conH);
        control[3] = new RectF(400, 1200, 400 + conW, 1200 + conH);
        control[4] = new RectF(2400, 1200, 2400 + conW, 1200 + conH);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(pacman, posX, posY, null);
        paintJoyStick(canvas);
    }

    public void paintJoyStick(Canvas canvas) {
        for (int i = 0; i < control.length; i++) {
            canvas.drawRect(control[i], paint);
        }
    }
}
