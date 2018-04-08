package com.testarms.tab1.di.module;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

import com.testarms.tab1.mvp.contract.Tab1Contract;
import com.testarms.tab1.mvp.model.Tab1Model;


@Module
public class Tab1Module {

  private Tab1Contract.View view;

  /**
   * 构建Tab1Module时,将View的实现类传进来,这样就可以提供View的实现类给presenter
   */
  public Tab1Module(Tab1Contract.View view) {
    this.view = view;
  }

  @ActivityScope
  @Provides
  Tab1Contract.View provideTab1View() {
    return this.view;
  }

  @ActivityScope
  @Provides
  Tab1Contract.Model provideTab1Model(Tab1Model model) {
    return model;
  }
}