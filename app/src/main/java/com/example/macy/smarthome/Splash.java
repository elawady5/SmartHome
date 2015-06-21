package com.example.macy.smarthome;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by Macy on 6/21/15.
 */
public class Splash extends Activity{

    static Socket s; // = new Socket()

    protected void onCreate(Bundle ZakiBeans) {
        super.onCreate(ZakiBeans);
        setContentView(R.layout.splash);
        Thread timer = new Thread(){
            public void run(){
                try{
                    long end=System.currentTimeMillis()+1000;
                    s = new Socket("192.168.1.200", 2300); //connecting to the car @ ip:192.168.1.100, port:2300
                    while(System.currentTimeMillis()<end)sleep(50);
                } catch(InterruptedException e){
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    Intent openMain = new Intent("com.example.macy.smarthome.AIAuth");
                    startActivity(openMain);
                }
            }
        };
        timer.start();
    }

}
