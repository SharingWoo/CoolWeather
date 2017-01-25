package com.coolweather.app.coolweather.actiivity;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Toast;

/**super class of all the activities
 * Created by SharingWoo on 2017/1/25.
 */

public class BasicActivity extends AppCompatActivity {
    private long firstTime=0 ;

    //consecutively press the return back button twice in a short duration(1s),we quit the application
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            long secondTime = System.currentTimeMillis();
            Log.i("BasicShowActivity",""+secondTime);
            if (secondTime - firstTime > 800) {//如果两次按键时间间隔大于800毫秒，则不退出
                Toast.makeText(this, "再按一次退出程序",
                        Toast.LENGTH_SHORT).show();
                firstTime = secondTime;//更新firstTime
                return true;
            } else {
                System.exit(0);//否则退出程序
            }
        }
        return super.onKeyUp(keyCode, event);
    }
}
