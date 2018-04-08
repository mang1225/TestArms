package com.testarms.tab2.di.module;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

import com.testarms.tab2.mvp.contract.Tab2Contract;
import com.testarms.tab2.mvp.model.Tab2Model;


@Module
public class Tab2Module {

  private Tab2Contract.View view;

  /**
   * 构建Tab2Module时,将View的实现类传进来,这样就可以提供View的实现类给presenter
   */
  public Tab2Module(Tab2Contract.View view) {
    this.view = view;
  }

  @ActivityScope
  @Provides
  Tab2Contract.View provideTab2View() {
    return this.view;
  }

  @ActivityScope
  @Provides
  Tab2Contract.Model provideTab2Model(Tab2Model model) {
    return model;
  }
}