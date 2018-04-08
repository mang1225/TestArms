package com.testarms.tab3.di.module;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

import com.testarms.tab3.mvp.contract.Tab3Contract;
import com.testarms.tab3.mvp.model.Tab3Model;


@Module
public class Tab3Module {

  private Tab3Contract.View view;

  /**
   * 构建Tab3Module时,将View的实现类传进来,这样就可以提供View的实现类给presenter
   */
  public Tab3Module(Tab3Contract.View view) {
    this.view = view;
  }

  @ActivityScope
  @Provides
  Tab3Contract.View provideTab3View() {
    return this.view;
  }

  @ActivityScope
  @Provides
  Tab3Contract.Model provideTab3Model(Tab3Model model) {
    return model;
  }
}