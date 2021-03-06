package com.liyuxiao.finalzhproject;

import android.Manifest;
import android.content.pm.PackageManager;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.app.ActivityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;
import com.liyuxiao.finalzhproject.adapter.FrangVp;
import com.liyuxiao.finalzhproject.app.AppConstants;
import com.liyuxiao.finalzhproject.base.BaseActivity;
import com.liyuxiao.finalzhproject.frangment.AboutFragment;
import com.liyuxiao.finalzhproject.frangment.CollectFragment;
import com.liyuxiao.finalzhproject.frangment.GankFragment;
import com.liyuxiao.finalzhproject.frangment.GoldFragment;
import com.liyuxiao.finalzhproject.frangment.SearchFragment;
import com.liyuxiao.finalzhproject.frangment.SettingsFragment;
import com.liyuxiao.finalzhproject.frangment.VtexFragment;
import com.liyuxiao.finalzhproject.frangment.WechatFragment;
import com.liyuxiao.finalzhproject.frangment.ZhihuFragment;
import com.liyuxiao.finalzhproject.util.ToastUtil;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;

import butterknife.BindView;

public class MainActivity extends BaseActivity {
    Toolbar toolbar;
    @BindView(R.id.fr)
    FrameLayout fr;
    @BindView(R.id.na)
    NavigationView na;
    @BindView(R.id.dr)
    DrawerLayout dr;
    @BindView(R.id.searchview)
    MaterialSearchView searchview;
    @BindView(R.id.frl)
    FrameLayout frl;
    private ArrayList<Fragment> list;
    private ArrayList<Integer> list1;
    private FrangVp vp;
    private FragmentManager manager;
    private MenuItem item;

    @Override
    protected int getlayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
        }
        super.initView();
        toolbar = (Toolbar) this.findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.zhihu);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, dr, toolbar, 0, 0);
        dr.addDrawerListener(toggle);
        toggle.syncState();

        initTitle();
        initgrangmt();
        manager = getSupportFragmentManager();
        addfrangmet();
        na.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.zhihu:
                        switchfrangt(AppConstants.Type_Zhihu);
                        break;
                    case R.id.wechat:
                        switchfrangt(AppConstants.Type_Wechat);
                        break;
                    case R.id.gank:
                        switchfrangt(AppConstants.Type_Gank);
                        break;
                    case R.id.vtex:
                        switchfrangt(AppConstants.Type_Vtex);
                        break;
                    case R.id.gold:
                        switchfrangt(AppConstants.Type_Gold);
                        break;
                    case R.id.collect:
                        switchfrangt(AppConstants.Type_Collect);
                        break;
                    case R.id.settings:
                        switchfrangt(AppConstants.Type_Setting);
                        break;
                    case R.id.about:
                        switchfrangt(AppConstants.Type_About);
                        break;
                }
                dr.closeDrawer(Gravity.LEFT);
                return true;
            }

        });
        searchview.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {
                ToastUtil.showShort("onSearchViewShown");
            }

            @Override
            public void onSearchViewClosed() {
                ToastUtil.showShort("onSearchViewClosed");

            }
        });
        searchview.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (Mylast==AppConstants.Type_Wechat){

                }else if (Mylast==AppConstants.Type_Gank){

                }
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    private int Mylast = 0;

    public void switchfrangt(int type) {
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment fragment = list.get(type);
        if (!fragment.isAdded()) {
            transaction.add(R.id.fr, fragment);
        }
        Fragment Mylastfragment1 = list.get(Mylast);
        transaction.hide(Mylastfragment1);
        transaction.show(fragment);
        transaction.commit();
        if (type==AppConstants.Type_Wechat||type==AppConstants.Type_Gank){
        item.setVisible(true);
        }else {
            item.setVisible(false);
        }
        Mylast = type;
        toolbar.setTitle(list1.get(type));

    }

    private void addfrangmet() {
        final FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.fr, list.get(0));
        transaction.commit();
    }

    private void initgrangmt() {
        list = new ArrayList<>();
        list.add(new ZhihuFragment());
        list.add(new WechatFragment());
        list.add(new GankFragment());
        list.add(new GoldFragment());
        list.add(new VtexFragment());
        list.add(new CollectFragment());
        list.add(new SettingsFragment());
        list.add(new AboutFragment());
        list.add(new SearchFragment());

    }

    private void initTitle() {
        list1 = new ArrayList<>();
        list1.add(R.string.zhihu);
        list1.add(R.string.wechat);
        list1.add(R.string.gank);
        list1.add(R.string.gold);
        list1.add(R.string.vtex);
        list1.add(R.string.collect);
        list1.add(R.string.settings);
        list1.add(R.string.about);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item2,menu);
        item = menu.findItem(R.id.aution_serachh);
        item.setVisible(false);
        //和菜单绑定
        searchview.setMenuItem(item);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onBackPressed() {
        if (searchview.isSearchOpen()){
        searchview.closeSearch();
        }else {
            super.onBackPressed();
        }
    }
}
