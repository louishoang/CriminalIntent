package com.louishoang.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by louishoang on 3/17/17.
 */

public class CrimeListActivity extends SingleFragmentActivity {

  @Override
  protected Fragment createFragment() {
    return new CrimeListFragment();
  }
}
