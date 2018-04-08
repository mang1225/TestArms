package com.testarms.tab2.di.component;

import com.jess.arms.di.scope.ActivityScope;
import dagger.Component;
import com.jess.arms.di.component.AppComponent;

import com.testarms.tab2.di.module.Tab2Module;

import com.testarms.tab2.mvp.ui.activity.Tab2Activity;

@ActivityScope
@Component(modules = Tab2Module.class, dependencies = AppComponent.class)
public interface Tab2Component {

  void inject(Tab2Activity activity);
}