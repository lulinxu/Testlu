package demo.testlu.lumyapplication.activity;

import android.support.design.widget.Snackbar;
import android.view.View;

import demo.testlu.lumyapplication.R;

/**
 * Created by Administrator on 2017/3/7 0007.
 */

public class TestActivity extends BaseActivity {
    @Override
    protected int getContentViewLayoutID() {
        return R.layout.text_man;
    }

    @Override
    protected void initViewsAndEvents() {
        initView();
    }
//    private int i;
//    private View v;
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.text_man);
//
//        initView();
//    }
    public void initView(){
        View v=findViewById(R.id.test_main);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });



    }



}
