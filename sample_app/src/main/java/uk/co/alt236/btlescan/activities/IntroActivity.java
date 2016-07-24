package uk.co.alt236.btlescan.activities;
import android.os.*;
import android.app.Activity;
import android.content.*;
import android.view.*;

import uk.co.alt236.btlescan.R;

/**
 * Created by jarvis on 16. 7. 9.
 */
public class IntroActivity extends Activity {

    Handler h;//핸들러 선언

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); // 타이틀바 제거
        setContentView(R.layout.activity_intro);
        h= new Handler(); // 딜레이 생성을 위한 핸들러
        h.postDelayed(mrun, 1000); // 딜레이 ( Runnable 객체는 mrun, 시간 2초)
    }

    Runnable mrun = new Runnable(){
        @Override
        public void run(){
            Intent i = new Intent(IntroActivity.this, MainActivity.class); //인텐트 생성(현 액티비티, 새로 실행할 액티비티)
            startActivity(i);
            finish();
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            //fade in,out 효과를준다
        }
    };
    //인트로 중에 뒤로가기를 누를 경우 핸들러를 끊어버려 아무일 없게 만드는 부분
    //미 설정시 인트로 중 뒤로가기를 누르면 인트로 후에 홈화면이 나옴.
    @Override
    public void onBackPressed(){
        super.onBackPressed();
        h.removeCallbacks(mrun);
    }

}