package demo.testlu.lumyapplication.activity;


import android.content.Intent;
import android.os.CountDownTimer;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.InjectView;
import butterknife.OnClick;
import demo.testlu.lumyapplication.R;

/**
 * Created by Administrator on 2017/4/7 0007.
 */

public class WelcomeActivity extends BaseActivity {
    @InjectView(R.id.ivBg)
    ImageView ivBg;
    @InjectView(R.id.tvSkip)
    TextView tvSkip;

    int[] imgs = new int[]{
            R.mipmap.irving,
            R.mipmap.bryant,
            R.mipmap.james,
            R.mipmap.harden,
            R.mipmap.curry};

    private CountDownTimer timer;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initViewsAndEvents() {
        int index = (int) (Math.random() * imgs.length);

        ivBg.setImageResource(imgs[index]);

        timer = new CountDownTimer(3500, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tvSkip.setText(String.format(getResources().getString(R.string.skip), (int) (millisUntilFinished / 1000 + 0.1)));
            }

            @Override
            public void onFinish() {
                tvSkip.setText(String.format(getResources().getString(R.string.skip), 0));
                startActivity(new Intent(mContext, MainActivity.class));
                finish();
            }
        };
        timer.start();
    }

    @OnClick(R.id.tvSkip)
    public void skip() {
        if (timer != null)
            timer.cancel();

        startActivity(new Intent(mContext, MainActivity.class));
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (timer != null) {
            timer.cancel();
        }
    }


}
