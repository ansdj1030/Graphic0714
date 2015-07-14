package study.graphic0714;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends Activity {
    String tag;
    MyView myView;
    ArrayList<Point> list = new ArrayList<Point>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myView = (MyView) findViewById(R.id.myview);
        tag = this.getClass().getName();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(tag, String.valueOf(event.getX()));
        Log.d(tag, String.valueOf(event.getY()));
        //Toast.makeText(this,"잘 찍히냐?",Toast.LENGTH_SHORT).show();
        Point point = new Point((int) event.getX(), (int) event.getY());
        list.add(point);
        move(list);
        return false;
    }

    public void move(ArrayList list) {
        //정해진 좌표를 이용하여 MyView 다시 그리기
        myView.list = list;
        myView.invalidate();
    }
}
