package demo.testlu.lumyapplication.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;

import com.yuyh.easyadapter.abslistview.EasyLVAdapter;
import com.yuyh.easyadapter.abslistview.EasyLVHolder;
import com.yuyh.library.utils.toast.ToastUtils;
import com.yuyh.library.view.viewpager.XViewPager;

import java.lang.reflect.Method;
import java.util.List;

import butterknife.InjectView;
import demo.testlu.lumyapplication.Adapter.VPHomeAdapter;
import demo.testlu.lumyapplication.R;
import demo.testlu.lumyapplication.View.HomeView;
import demo.testlu.lumyapplication.utils.NavigationEntity;

/**
 * Created by Administrator on 2017/4/10 0010.
 */

public class Main extends BaseActivity implements HomeView{
    @InjectView(R.id.home_container)
    XViewPager mViewPager;
    @InjectView(R.id.home_navigation_list)
    ListView mNavListView;
    @InjectView(R.id.home_drawer)
    DrawerLayout mDrawerLayout;

    private ActionBarDrawerToggle mActionBarDrawerToggle = null;
    private EasyLVAdapter<NavigationEntity> mNavListAdapter = null;

    private static long DOUBLE_CLICK_TIME = 0L;
    private static int REQUEST_DATE_CODE = 1;
    private int mCurrentMenuCheckedPos = 0;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_main_1;
    }
    @Override
    protected void initViewsAndEvents() {

    }

    @Override
    public void initializeViews(List<BaseLazyFragment> fragments, List<NavigationEntity> navigationList) {
        if (null != fragments && !fragments.isEmpty()) {
            mViewPager.setEnableScroll(false);
            mViewPager.setOffscreenPageLimit(fragments.size());
            mViewPager.setAdapter(new VPHomeAdapter(getSupportFragmentManager(), fragments));
        }

        mActionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_open, R.string.drawer_close) {

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                if (null != mNavListAdapter) {
                    setTitle(((NavigationEntity) mNavListAdapter.getItem(mCurrentMenuCheckedPos)).getName());
                }
            }
        };
        mActionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.addDrawerListener(mActionBarDrawerToggle);

        mNavListAdapter = new EasyLVAdapter<NavigationEntity>(Main.this, navigationList, R.layout.item_list_navigation) {
            @Override
            public void convert(EasyLVHolder viewHolder, int position, NavigationEntity item) {
                viewHolder.setImageResource(R.id.list_item_navigation_icon, item.getIconResId())
                        .setText(R.id.list_item_navigation_name, item.getName());
            }
        };

        mNavListView.setAdapter(mNavListAdapter);
        mNavListAdapter.notifyDataSetChanged();

        mNavListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mCurrentMenuCheckedPos = position;
                mNavListAdapter.notifyDataSetChanged();
                mDrawerLayout.closeDrawer(Gravity.LEFT);
                mViewPager.setCurrentItem(mCurrentMenuCheckedPos, false);
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_MENU && mDrawerLayout != null) {
            if (mDrawerLayout.isDrawerOpen(Gravity.LEFT)) {
                mDrawerLayout.closeDrawer(Gravity.LEFT);
            } else {
                mDrawerLayout.openDrawer(Gravity.LEFT);
            }
            return true;
        } else if(mViewPager.getCurrentItem() != 0){
            mCurrentMenuCheckedPos = 0;
            mNavListAdapter.notifyDataSetChanged();
            mDrawerLayout.closeDrawer(Gravity.LEFT);
            mViewPager.setCurrentItem(mCurrentMenuCheckedPos, true);
            setTitle(((NavigationEntity) mNavListAdapter.getItem(mCurrentMenuCheckedPos)).getName());
            return true;
        } else if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            if (mDrawerLayout.isDrawerOpen(Gravity.LEFT)) {
                mDrawerLayout.closeDrawer(Gravity.LEFT);
            } else {
                if ((System.currentTimeMillis() - DOUBLE_CLICK_TIME) > 2000) {
                    ToastUtils.showSingleToast("再按一次退出");
                    DOUBLE_CLICK_TIME = System.currentTimeMillis();
                } else {
                    finish();
                }
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        if (mActionBarDrawerToggle != null) {
            mActionBarDrawerToggle.syncState();
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (mActionBarDrawerToggle != null) {
            mActionBarDrawerToggle.onConfigurationChanged(newConfig);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        //JCVideoPlayer.releaseAllVideos();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }



    /**
     * 显示overflower菜单图标
     */
    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        if (featureId == Window.FEATURE_ACTION_BAR && menu != null) {
            if (menu.getClass().getSimpleName().equals("MenuBuilder")) {
                try {
                    Method m = menu.getClass().getDeclaredMethod("setOptionalIconsVisible", Boolean.TYPE);
                    m.setAccessible(true);
                    m.invoke(menu, true);
                } catch (Exception e) {
                }
            }
        }
        return super.onMenuOpened(featureId, menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.clear();
        MenuInflater inflater = this.getMenuInflater();
//        switch (mCurrentMenuCheckedPos) {
////            case 1:
////                inflater.inflate(R.menu.menu_schedule, menu);
////                break;
////            default:
////                inflater.inflate(R.menu.menu_home, menu);
//                break;
//        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_schedule, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mActionBarDrawerToggle != null && mActionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

//        switch (item.getItemId()) {
//            case R.id.action_calendar:
////                CalendarActivity.start(this, REQUEST_DATE_CODE);
//                break;
//            case R.id.action_live:
////                MatchVideoLiveListActivity.start(this);
//                break;
//            default:
//                break;
//        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == REQUEST_DATE_CODE && resultCode == RESULT_OK) {
//            String date = data.getStringExtra(CalendarActivity.CALENDAR_DATE);
//            if (!TextUtils.isEmpty(date))
//                EventBus.getDefault().post(new CalendarEvent(date));
//        }
    }


}
