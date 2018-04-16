package com.testarms.common.fragment;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import com.testarms.R;
import com.testarms.common.view.fragment.LazyFragment;


public class FragmentCommon extends LazyFragment {

  TextView textView;
  public static final String INTENT_STRING_TABNAME = "intent_String_tabname";
  public static final String INTENT_INT_INDEX = "intent_int_index";
  private String tabName;
  private int index;

  public static FragmentCommon newInstance(String text, int index) {
    FragmentCommon fragmentCommon = new FragmentCommon();
    Bundle bundle = new Bundle();
    bundle.putString(INTENT_STRING_TABNAME, text);
    bundle.putInt(INTENT_INT_INDEX, index);
    fragmentCommon.setArguments(bundle);
    return fragmentCommon;
  }

  @Override
  protected void onCreateViewLazy(Bundle savedInstanceState) {
    super.onCreateViewLazy(savedInstanceState);
    setContentView(R.layout.fragment_common);

    Bundle bundle = getArguments();
    tabName = bundle.getString(INTENT_STRING_TABNAME);
    index = bundle.getInt(INTENT_INT_INDEX);

    textView = (TextView) findViewById(R.id.textView);
    textView.setText(tabName + "-->" + index);
  }


  @Override
  protected void onResumeLazy() {
    super.onResumeLazy();
    Log.d("cccc", "Fragment所在的Activity onResume, onResumeLazy " + this.tabName);
  }

  @Override
  protected void onFragmentStartLazy() {
    super.onFragmentStartLazy();
    Log.d("cccc", "Fragment 显示 " + this.tabName);
  }

  @Override
  protected void onFragmentStopLazy() {
    super.onFragmentStopLazy();
    Log.d("cccc", "Fragment 掩藏 " + this.tabName);
  }

}

