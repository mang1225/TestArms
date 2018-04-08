package com.testarms.tab1.mvp.model;

import android.app.Application;
import com.google.gson.Gson;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import com.jess.arms.di.scope.ActivityScope;
import javax.inject.Inject;

import com.testarms.tab1.mvp.contract.Tab1Contract;


@ActivityScope
public class Tab1Model extends BaseModel implements Tab1Contract.Model {

  @Inject
  Gson mGson;
  @Inject
  Application mApplication;

  @Inject
  public Tab1Model(IRepositoryManager repositoryManager) {
    super(repositoryManager);
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    this.mGson = null;
    this.mApplication = null;
  }
}