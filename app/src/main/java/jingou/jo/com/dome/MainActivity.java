package jingou.jo.com.dome;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.lauzy.freedom.lbehaviorlib.behavior.CommonBehavior;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,DemoAdapter.Onitemclick{
    private RecyclerView mRecyclerView;
    private Toolbar mToolbar;
    private LinearLayout mLayoutBottom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_demo1);
//        获取对应的id
        mToolbar = (Toolbar) findViewById(R.id.toolbar_common);
        mLayoutBottom = (LinearLayout) findViewById(R.id.layout_bottom);

        new DemoAdapter(this).setListten(this);

        FloatingActionButton fab2= (FloatingActionButton) findViewById(R.id.fab2_mode);
        fab2.setOnClickListener(this);
        findViewById(R.id.fab_mode).setOnClickListener(this);
//        findViewById(R.id.fab2_mode).setOnClickListener(this);
        findViewById(R.id.fab3_mode).setOnClickListener(this);
        FloatingActionButton fab4 = (FloatingActionButton) findViewById(R.id.fab4_mode);
        fab4.setOnClickListener(this);
        CommonBehavior.from(fab4).setCanScroll(true);//禁止右上角悬浮按钮动画
        CommonBehavior.from(fab2).setCanScroll(false);
        loadData();
        diyAnim();
//        设置跳转事件

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab_mode:
                Toast.makeText(this, "Fab1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fab2_mode:
                Toast.makeText(this, "Fab2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fab3_mode:
                Toast.makeText(this, "Fab3", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fab4_mode:
                Toast.makeText(this, "Fab4", Toast.LENGTH_SHORT).show();
                break;
        }

    }

    private void loadData() {
        new DemoAdapter(this).setListten(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new DemoAdapter(this));
        mRecyclerView.addItemDecoration(new DemoItemDecoration(this));
    }

    private void diyAnim() {
//        CommonBehavior.from(mFab1).setInterpolator(new AnticipateInterpolator());
//        CommonBehavior.from(mFab2).setInterpolator(new BounceInterpolator());
//        CommonBehavior.from(mFab3).setDuration(1000);
//        CommonBehavior.from(mFab3).setInterpolator(new AnticipateOvershootInterpolator());
//        CommonBehavior.from(mFab4).setInterpolator(new BounceInterpolator());
//        CommonBehavior.from(mFab4).setDuration(800);
//出现动画的效果new BounceInterpolator()
        CommonBehavior.from(mToolbar).setDuration(500).setInterpolator(new BounceInterpolator());
        CommonBehavior.from(mLayoutBottom).setDuration(600).setInterpolator(new LinearInterpolator());
    }

    @Override
    public void Itemclick(View v, int p) {
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        startActivity(intent);
    }
}
