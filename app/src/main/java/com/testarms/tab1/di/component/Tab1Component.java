package com.testarms.tab1.di.component;

import com.jess.arms.di.scope.ActivityScope;
import dagger.Component;
import com.jess.arms.di.component.AppComponent;

import com.testarms.tab1.di.module.Tab1Module;

import com.testarms.tab1.mvp.ui.activity.Tab1Activity;

@ActivityScope
@Component(modules = Tab1Module.class, dependencies = AppComponent.class)
public interface Tab1Component {

  void inject(Tab1Activity activity);
}