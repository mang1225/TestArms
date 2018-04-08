package com.testarms.tab2.mvp.ui.activity;

import static com.jess.arms.utils.Preconditions.checkNotNull;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;
import com.testarms.R;
import com.testarms.tab2.di.component.DaggerTab2Component;
import com.testarms.tab2.di.module.Tab2Module;
import com.testarms.tab2.mvp.contract.Tab2Contract;
import com.testarms.tab2.mvp.presenter.Tab2Presenter;


public class Tab2Activity extends BaseActivity<Tab2Presenter> implements Tab2Contract.View {

  @Override
  public void setupActivityComponent(@NonNull AppComponent appComponent) {
    DaggerTab2Component //如找不到该类,请编译一下项目
        .builder()
        .appComponent(appComponent)
        .tab2Module(new Tab2Module(this))
        .build()
        .inject(this);
  }

  @Override
  public int initView(@Nullable Bundle savedInstanceState) {
    return R.layout.activity_tab2; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
  }

  @Override
  public void initData(@Nullable Bundle savedInstanceState) {

  }

  @Override
  public void showLoading() {

  }

  @Override
  public void hideLoading() {

  }

  @Override
  public void showMessage(@NonNull String message) {
    checkNotNull(message);
    ArmsUtils.snackbarText(message);
  }

  @Override
  public void launchActivity(@NonNull Intent intent) {
    checkNotNull(intent);
    ArmsUtils.startActivity(intent);
  }

  @Override
  public void killMyself() {
    finish();
  }
}
