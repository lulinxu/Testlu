package demo.testlu.lumyapplication.activity;

import android.content.res.Resources;
import android.graphics.Color;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.jude.rollviewpager.hintview.ColorPointHintView;

import java.util.ArrayList;
import java.util.List;

import demo.testlu.lumyapplication.Adapter.MyAdapter;
import demo.testlu.lumyapplication.R;


public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    private RollPagerView mRollViewPager;
    private RecyclerView mRecyclerView;
    private List<Integer> datas;
    private MyAdapter adapter;
    private RecyclerView.ItemDecoration itemDecoration;
    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_main;
    }
    @Override
    protected void initViewsAndEvents() {
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        //轮播图
        mRollViewPager = (RollPagerView) findViewById(R.id.roll_view_pager);
//        //RecyclerView
        mRecyclerView= (RecyclerView) findViewById(R.id.main_recyclerView);
//        initRecycleViewData();
        initDate();
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                adapter.setType(3);
////        mRecyclerView.setBackgroundColor(getResources().getColor(R.color.colorAccent));
////        mRecyclerView.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT));
////        mRecyclerView.removeItemDecoration(itemDecoration);
////        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(5, StaggeredGridLayoutManager.VERTICAL));
//
//
//                startActivity(new Intent(MainActivity.this, TestActivity.class));
//
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });


//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.setDrawerListener(toggle);
//        toggle.syncState();
//
//        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);
    }

    /**
     * 添加VRecycleiew数据
     */
    private void initRecycleViewData() {
        datas = new ArrayList<>();
        for (int i = 0; i < 38; i++) {
            Resources res = getResources();
            datas.add(res.getIdentifier("ic_category_" + i, "mipmap", getPackageName()));
        }
        /**
         *用来确定每一个item如何进行排列摆放
         * LinearLayoutManager 相当于ListView的效果
         GridLayoutManager相当于GridView的效果
         StaggeredGridLayoutManager 瀑布流
         */
        /**第一步：设置布局管理器**/
    //listView
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
//     gridview
//         mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL));

//瀑布流
//        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(5, StaggeredGridLayoutManager.VERTICAL));
////
//        mRecyclerView.removeItemDecoration(itemDecoration);

//        /**第二步：添加分割线**/
//        itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST);
//
//        mRecyclerView.addItemDecoration(itemDecoration);
//        /**第三步：设置适配器**/
//        adapter = new MyAdapter(this, datas);
//        adapter.setType(3);
//        mRecyclerView.setAdapter(adapter);
//        adapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClickListener(int position, Integer data) {
//                Toast.makeText(MainActivity.this, "点击了" + position, Toast.LENGTH_SHORT).show();
//
//            }
//
//        });
//        adapter.setOnItemlongClickListener(new MyAdapter.OnItemLongClickListener() {
//            @Override
//            public void onItemLongClick(int position, Integer integer) {
//                adapter.notifyItemRemoved(position);
//            }
//        });



    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * @param item
     * @return 左边菜单栏选项
     */
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                    .setAction("Action", null).show();


        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }
        //返回
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void initDate() {
        //设置播放时间间隔
        mRollViewPager.setPlayDelay(2000);
        //设置透明度
        mRollViewPager.setAnimationDurtion(500);
        //设置适配器
        mRollViewPager.setAdapter(new TestNormalAdapter());
        //设置指示器（顺序依次）
        //自定义指示器图片
        //设置圆点指示器颜色
        //设置文字指示器
        // 隐藏指示器
        //mRollViewPager.setHintView(newIconHintView(this, R.drawable.point_focus, R.drawable.point_normal));
        mRollViewPager.setHintView(new ColorPointHintView(this,
                Color.YELLOW, Color.WHITE));
        //mRollViewPager.setHintView(newTextHintView(this));
        //mRollViewPager.setHintView(null);

    }


    private class TestNormalAdapter extends StaticPagerAdapter {

        private int[] imgs = {

                R.drawable.pic_ch_01,

                R.drawable.pic_ch_02,

                R.drawable.pic_ch_03,

                R.drawable.pic_ch_04,

        };

        public View getView(ViewGroup container, int position) {
            ImageView view = new ImageView(container.getContext());

            view.setImageResource(imgs[position]);

            view.setScaleType(ImageView.ScaleType.CENTER_CROP);

            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT));

            return view;

        }

        public int getCount() {

            return imgs.length;

        }


    }
}



