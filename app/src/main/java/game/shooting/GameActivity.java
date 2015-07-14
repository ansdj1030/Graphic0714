package game.shooting;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;

import study.graphic0714.R;

/**
 * Created by moonsunhun on 2015-07-14.
 */
public class GameActivity extends Activity {
    GameView gameView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        gameView = (GameView)findViewById(R.id.gameview);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        move();
        return super.onTouchEvent(event);
    }
    //우주선을 날리자 Bitmap의 x축을 변경후 invalidate() 호출
    public void move(){
        int x = gameView.getPosX();
        x+=10;
        gameView.setPosX(x);
        /*int y = gameView.getPosY();
        y+=20;
        gameView.setPosY(y);*/
        gameView.invalidate();
    }
}
