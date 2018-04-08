package com.testarms.tab3.mvp.model;

import android.app.Application;
import com.google.gson.Gson;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import com.jess.arms.di.scope.ActivityScope;
import javax.inject.Inject;

import com.testarms.tab3.mvp.contract.Tab3Contract;


@ActivityScope
public class Tab3Model extends BaseModel implements Tab3Contract.Model {

  @Inject
  Gson mGson;
  @Inject
  Application mApplication;

  @Inject
  public Tab3Model(IRepositoryManager repositoryManager) {
    super(repositoryManager);
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    this.mGson = null;
    this.mApplication = null;
  }
}