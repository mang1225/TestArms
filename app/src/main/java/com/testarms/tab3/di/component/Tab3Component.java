package com.testarms.tab3.di.component;

import com.jess.arms.di.scope.ActivityScope;
import dagger.Component;
import com.jess.arms.di.component.AppComponent;

import com.testarms.tab3.di.module.Tab3Module;

import com.testarms.tab3.mvp.ui.activity.Tab3Activity;

@ActivityScope
@Component(modules = Tab3Module.class, dependencies = AppComponent.class)
public interface Tab3Component {

  void inject(Tab3Activity activity);
}