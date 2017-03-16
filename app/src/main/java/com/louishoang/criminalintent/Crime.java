package com.louishoang.criminalintent;

import java.util.Date;
import java.util.UUID;

/**
 * Created by louishoang on 3/15/17.
 */

public class Crime {
  private UUID mId;
  private String mTitle;

  public Date getmDate() {
    return mDate;
  }

  public void setmDate(Date mDate) {
    this.mDate = mDate;
  }

  public boolean ismSolved() {
    return mSolved;
  }

  public void setmSolved(boolean mSolved) {
    this.mSolved = mSolved;
  }

  private Date mDate;
  private boolean mSolved;

  public Crime(){
    // Generate a unique indentifier;
    mId = UUID.randomUUID();
    mDate = new Date();
  }

  public UUID getId() {
    return mId;
  }

  public String getTitle() {
    return mTitle;
  }

  public void setTitle(String title) {
    mTitle = title;
  }
}
