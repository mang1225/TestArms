/*
 * Copyright 2017 JessYan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.testarms.tab4.mvp.ui.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import com.jess.arms.base.BaseHolder;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.http.imageloader.ImageLoader;
import com.jess.arms.http.imageloader.glide.ImageConfigImpl;
import com.jess.arms.utils.ArmsUtils;
import com.testarms.R;
import com.testarms.tab4.mvp.model.entity.User;
import io.reactivex.Observable;

/**
 * ================================================ 展示 {@link BaseHolder} 的用法 <p> Created by JessYan
 * on 9/4/16 12:56 <a href="mailto:jess.yan.effort@gmail.com">Contact me</a> <a
 * href="https://github.com/JessYanCoding">Follow me</a> ================================================
 */
public class UserItemHolder extends BaseHolder<User> {

  @BindView(R.id.iv_avatar)
  ImageView mAvatar;
  @BindView(R.id.tv_name)
  TextView mName;
  private AppComponent mAppComponent;
  private ImageLoader mImageLoader;//用于加载图片的管理类,默认使用 Glide,使用策略模式,可替换框架

  public UserItemHolder(View itemView) {
    super(itemView);
    //可以在任何可以拿到 Context 的地方,拿到 AppComponent,从而得到用 Dagger 管理的单例对象
    mAppComponent = ArmsUtils.obtainAppComponentFromContext(itemView.getContext());
    mImageLoader = mAppComponent.imageLoader();
  }

  @Override
  public void setData(User data, int position) {
    Observable.just(data.getLogin())
        .subscribe(s -> mName.setText(s));

    //itemView 的 Context 就是 Activity, Glide 会自动处理并和该 Activity 的生命周期绑定
    mImageLoader.loadImage(itemView.getContext(),
        ImageConfigImpl
            .builder()
            .url(data.getAvatarUrl())
            .imageView(mAvatar)
            .build());
  }


  @Override
  protected void onRelease() {
    mImageLoader.clear(mAppComponent.application(), ImageConfigImpl.builder()
        .imageViews(mAvatar)
        .build());
  }
}
