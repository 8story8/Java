package com.example.kosta_inst.step3_imagelongclickevent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv=(ImageView)findViewById(R.id.imageView);
        iv.setOnLongClickListener(new ImageHandler());
    }
    /*
           롱클릭시 ImageView의 image가 번갈아가면서 화면에 제공되도록 처리
           ImageView의 setImageResource(image id);
     */
    private class ImageHandler implements View.OnLongClickListener {
        private int count;
        @Override
        public boolean onLongClick(View v) {
            Log.i("imgTest", "longclick");
            if(count%2==0)
            iv.setImageResource(R.drawable.iu2);
            else
                iv.setImageResource(R.drawable.iu);
            count++;
            return true;
        }
    }
}












