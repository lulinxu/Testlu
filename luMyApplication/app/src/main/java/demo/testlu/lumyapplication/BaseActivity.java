package demo.testlu.lumyapplication;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 鲁林旭
 * Created by Administrator on 2017/3/7 0007.
 */

public  class BaseActivity extends AppCompatActivity implements View.OnClickListener {
    View rootView=null;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(LayoutInflater.from(this).inflate(layoutResID,null));
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        super.setContentView(view);
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        rootView=view;
        initView();
        initDate();
    }

    public void initDate() {
    }

    public void initView() {
    }

    public  View getView(int resID){
     return rootView.findViewById(resID);
    }

    public void SetClick(int... resID){
        for (int i=0;i<resID.length;i++){
          getView(resID[i]).setOnClickListener(this);
        }

    }
    public void SetClick(View... v){
        for (int i=0;i<v.length;i++){
            v[i].setOnClickListener(this);
        }

    }
    public  void onClick(View v){

    }




}
