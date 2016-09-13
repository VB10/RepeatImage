package com.vb.customad;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private ImageView ımageView;
    private int index;
    private Timer timer;
    private TimerTask timerTask;
    private int [] resimler = {
            R.drawable.resim1,
            R.drawable.resim2,
            R.drawable.resim3
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Handler handler= new Handler() ;
        Timer timer= new Timer();
        ımageView= (ImageView) findViewById(R.id.img);




        final  Runnable DurumGuncelle = new Runnable() {
            @Override
            public void run() {
                SlaytResim();
            }
        };
        int tekrar = 1000; //1sn
        int tur = 6000;//3 snde bir tekrar


        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(DurumGuncelle);
            }
        },tekrar,tur);



    }

    private void SlaytResim() {

        if(index>2) index=0;

        ımageView.setImageResource(resimler[index%resimler.length]);
        index++;

    }


}
