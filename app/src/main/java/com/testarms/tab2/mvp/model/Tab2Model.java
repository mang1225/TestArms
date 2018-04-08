package com.testarms.tab2.mvp.model;

import android.app.Application;
import com.google.gson.Gson;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import com.jess.arms.di.scope.ActivityScope;
import javax.inject.Inject;

import com.testarms.tab2.mvp.contract.Tab2Contract;


@ActivityScope
public class Tab2Model extends BaseModel implements Tab2Contract.Model {

  @Inject
  Gson mGson;
  @Inject
  Application mApplication;

  @Inject
  public Tab2Model(IRepositoryManager repositoryManager) {
    super(repositoryManager);
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    this.mGson = null;
    this.mApplication = null;
  }
}