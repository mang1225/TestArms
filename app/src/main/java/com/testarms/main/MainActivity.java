package com.testarms.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import com.testarms.R;
import com.testarms.common.FragmentCommon;
import com.testarms.view.tab.TabView;
import com.testarms.view.tab.TabViewChild;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  TabView tabView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
//    startActivity(new Intent(this, UserActivity.class));
    initTab();
  }


  public void initTab() {
    tabView = (TabView) findViewById(R.id.tabView);
    //start add data
    List<TabViewChild> tabViewChildList = new ArrayList<>();
    TabViewChild tabViewChild01 = new TabViewChild(R.drawable.tab01_sel, R.drawable.tab01_unsel,
        "首页", FragmentCommon.newInstance("首页"));
    TabViewChild tabViewChild02 = new TabViewChild(R.drawable.tab02_sel, R.drawable.tab02_unsel,
        "分类", FragmentCommon.newInstance("分类"));
    TabViewChild tabViewChild03 = new TabViewChild(R.drawable.tab03_sel, R.drawable.tab03_unsel,
        "资讯", FragmentCommon.newInstance("资讯"));
    TabViewChild tabViewChild04 = new TabViewChild(R.drawable.tab04_sel, R.drawable.tab04_unsel,
        "购物车", FragmentCommon.newInstance("购物车"));
    TabViewChild tabViewChild05 = new TabViewChild(R.drawable.tab05_sel, R.drawable.tab05_unsel,
        "我的", FragmentCommon.newInstance("我的"));
    tabViewChildList.add(tabViewChild01);
    tabViewChildList.add(tabViewChild02);
    tabViewChildList.add(tabViewChild03);
    tabViewChildList.add(tabViewChild04);
    tabViewChildList.add(tabViewChild05);
    //end add data
    tabView.setTabViewDefaultPosition(0);
    tabView.setTabViewChild(tabViewChildList, getSupportFragmentManager());
    tabView.setOnTabChildClickListener(new TabView.OnTabChildClickListener() {
      @Override
      public void onTabChildClick(int position, ImageView currentImageIcon, TextView currentTextView) {
        // Toast.makeText(getApplicationContext(),"position:"+position,Toast.LENGTH_SHORT).show();
      }
    });
  }
}
