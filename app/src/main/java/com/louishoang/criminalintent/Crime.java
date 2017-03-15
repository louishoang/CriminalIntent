package com.louishoang.criminalintent;

import java.util.UUID;

/**
 * Created by louishoang on 3/15/17.
 */

public class Crime {
  private UUID mId;

  private String mTitle;

  public Crime(){
    // Generate a unique indentifier;
    mId = UUID.randomUUID();
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
