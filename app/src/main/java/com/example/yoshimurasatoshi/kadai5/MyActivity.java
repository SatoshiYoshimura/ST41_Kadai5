package com.example.yoshimurasatoshi.kadai5;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MyActivity extends Activity {

    TextView[] textViewArray = new TextView[4];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);


        textViewArray[0] = (TextView)findViewById(R.id.textView5);
        textViewArray[0].setText(binaryText(ActionBar.DISPLAY_HOME_AS_UP,8) + ":");
        textViewArray[1] = (TextView)findViewById(R.id.textView6);
        textViewArray[1].setText(binaryText(ActionBar.DISPLAY_SHOW_HOME,8) + ":");
        textViewArray[2] = (TextView)findViewById(R.id.textView7);
        textViewArray[2].setText(binaryText(ActionBar.DISPLAY_SHOW_TITLE,8) + ":");
        textViewArray[3] = (TextView)findViewById(R.id.textView8);
        textViewArray[3].setText(binaryText(ActionBar.DISPLAY_USE_LOGO,8) + ":");

        TextView tv = (TextView)findViewById(R.id.textView9);
        tv.setText(binaryText(getActionBar().getDisplayOptions(), 8));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onOnButtonClick(View button){
        //今の奴取得
        int nowFlg = getActionBar().getDisplayOptions();
        Log.w("nowFlg",":" + nowFlg);
        //To DISPLAY_HOME_AS_UP
        if(button.getTag().equals("DISPLAY_HOME_AS_UP")){
            int homeAsUpTrue = ActionBar.DISPLAY_HOME_AS_UP;
            int newFlg = nowFlg | homeAsUpTrue;
            getActionBar().setDisplayOptions(newFlg);
            TextView tv = (TextView)findViewById(R.id.textView9);
            tv.setText(binaryText(newFlg,8));
        }
        else if (button.getTag().equals("DISPLAY_SHOW_HOME")){
            int showHome = ActionBar.DISPLAY_SHOW_HOME;
            int newFlg = nowFlg | showHome;
            getActionBar().setDisplayOptions(newFlg);
            TextView tv = (TextView)findViewById(R.id.textView9);
            tv.setText(binaryText(newFlg,8));
        }
        else if(button.getTag().equals("DISPLAY_SHOW_TITLE")){
            int showTitle = ActionBar.DISPLAY_SHOW_TITLE;
            int newFlg = nowFlg | showTitle;
            getActionBar().setDisplayOptions(newFlg);
            TextView tv = (TextView)findViewById(R.id.textView9);
            tv.setText(binaryText(newFlg,8));
        }
        else if(button.getTag().equals("DISPLAY_USE_LOGO")){
            int useLogo = ActionBar.DISPLAY_USE_LOGO;
            int newFlg = nowFlg | useLogo;
            getActionBar().setDisplayOptions(newFlg);
            TextView tv = (TextView)findViewById(R.id.textView9);
            tv.setText(binaryText(newFlg,8));
        }
    }

    public  void onOffButtonClick(View button){
        //今の奴取得
        int nowFlg = getActionBar().getDisplayOptions();

        if(button.getTag().equals("DISPLAY_HOME_AS_UP")){
            int thisFlg = ActionBar.DISPLAY_HOME_AS_UP;
            int newFlg = nowFlg & ~thisFlg;
            getActionBar().setDisplayOptions(newFlg);
            TextView tv = (TextView)findViewById(R.id.textView9);
            tv.setText(binaryText(newFlg,8));
        }
        else if (button.getTag().equals("DISPLAY_SHOW_HOME")){
            int thisFlg = ActionBar.DISPLAY_SHOW_HOME;
            int newFlg = nowFlg & ~thisFlg;
            getActionBar().setDisplayOptions(newFlg);
            TextView tv = (TextView)findViewById(R.id.textView9);
            tv.setText(binaryText(newFlg,8));
        }
        else if(button.getTag().equals("DISPLAY_SHOW_TITLE")){
            int thisFlg = ActionBar.DISPLAY_SHOW_TITLE;
            int newFlg = nowFlg & ~thisFlg;
            getActionBar().setDisplayOptions(newFlg);
            TextView tv = (TextView)findViewById(R.id.textView9);
            tv.setText(binaryText(newFlg,8));
        }
        else if(button.getTag().equals("DISPLAY_USE_LOGO")){
            int thisFlg = ActionBar.DISPLAY_USE_LOGO;
            int newFlg = nowFlg & ~thisFlg;
            getActionBar().setDisplayOptions(newFlg);
            TextView tv = (TextView)findViewById(R.id.textView9);
            tv.setText(binaryText(newFlg,8));
        }
    }

    public void onToggleButtonClick(View button){
        int nowFlg = getActionBar().getDisplayOptions();

        if(button.getTag().equals("DISPLAY_HOME_AS_UP")){
            int thisFlg = ActionBar.DISPLAY_HOME_AS_UP;
            int newFlg = nowFlg ^ thisFlg;
            getActionBar().setDisplayOptions(newFlg);
            TextView tv = (TextView)findViewById(R.id.textView9);
            tv.setText(binaryText(newFlg,8));
        }
        else if (button.getTag().equals("DISPLAY_SHOW_HOME")){
            int thisFlg = ActionBar.DISPLAY_SHOW_HOME;
            int newFlg = nowFlg ^ thisFlg;
            getActionBar().setDisplayOptions(newFlg);
            TextView tv = (TextView)findViewById(R.id.textView9);
            tv.setText(binaryText(newFlg,8));
        }
        else if(button.getTag().equals("DISPLAY_SHOW_TITLE")){
            int thisFlg = ActionBar.DISPLAY_SHOW_TITLE;
            int newFlg = nowFlg ^ thisFlg;
            getActionBar().setDisplayOptions(newFlg);
            TextView tv = (TextView)findViewById(R.id.textView9);
            tv.setText(binaryText(newFlg,8));
        }
        else if(button.getTag().equals("DISPLAY_USE_LOGO")){
            int thisFlg = ActionBar.DISPLAY_USE_LOGO;
            int newFlg = nowFlg ^ thisFlg;
            getActionBar().setDisplayOptions(newFlg);
            TextView tv = (TextView)findViewById(R.id.textView9);
            tv.setText(binaryText(newFlg,8));
        }
    }

    public String binaryText(int n, int keta){
        String s = String.format("%" + keta + "s", Integer.toBinaryString(n)).replace(' ', '0');
        if(s.length() > keta){
            s = s.substring(s.length() - keta);
        }
        return s;
    }
}
