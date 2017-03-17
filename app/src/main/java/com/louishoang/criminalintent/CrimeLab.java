package com.louishoang.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by louishoang on 3/16/17.
 */

public class CrimeLab {
  private static CrimeLab sCrimeLab;
  private Context mAppContext;
  private ArrayList<Crime> mCrimes;

  public Crime getCrime(UUID id){
    for(Crime c : mCrimes){
      if(c.getId().equals(id)){
        return c;
      }
    }
    return null;
  }

  public ArrayList<Crime> getCrimes() {
    return mCrimes;
  }

  private CrimeLab(Context appContext){
    mAppContext = appContext;
    mCrimes = new ArrayList<Crime>();

    for(int i = 0; i < 100; i++){
      Crime c = new Crime();
      c.setTitle("Crime #" + i);
      c.setmSolved(i % 2 == 0);
      mCrimes.add(c);
    }
  }

  public static CrimeLab get(Context c){
    if (sCrimeLab == null){
      sCrimeLab = new CrimeLab(c.getApplicationContext());
    }
    return sCrimeLab;
  }

}
