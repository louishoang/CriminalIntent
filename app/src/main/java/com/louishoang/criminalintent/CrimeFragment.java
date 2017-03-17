package com.louishoang.criminalintent;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.util.UUID;

/**
 * Created by louishoang on 3/15/17.
 */

public class CrimeFragment extends Fragment {
  private Crime mCrime;
  private EditText mTitleField;
  private Button mDateButton;
  private CheckBox mSolvedCheckBox;
  public static final String EXTRA_CRIME_ID = "com.louishoang.criminalintent.crime_id";

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    UUID crimeId = (UUID)getArguments().getSerializable(EXTRA_CRIME_ID);
    mCrime = CrimeLab.get(getActivity()).getCrime(crimeId);
  }

  public static CrimeFragment newInstance(UUID crimeId){
    Bundle args = new Bundle();
    args.putSerializable(EXTRA_CRIME_ID, crimeId);

    CrimeFragment fragment = new CrimeFragment();
    fragment.setArguments(args);

    return fragment;
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.fragment_crime, parent, false);

    mDateButton = (Button)v.findViewById(R.id.crime_date);
    mDateButton.setText(mCrime.getmDate().toString());
    mDateButton.setEnabled(false);

    mSolvedCheckBox = (CheckBox)v.findViewById(R.id.crime_solved);
    mSolvedCheckBox.setChecked(mCrime.ismSolved());
    mSolvedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        mCrime.setmSolved(isChecked);
      }
    });

    mTitleField = (EditText)v.findViewById(R.id.crime_title);
    mTitleField.setText(mCrime.getTitle());
    mTitleField.addTextChangedListener(new TextWatcher() {
      @Override
      public void beforeTextChanged(CharSequence s, int start, int count, int after) {

      }

      @Override
      public void onTextChanged(CharSequence s, int start, int before, int count) {
        mCrime.setTitle(s.toString());
      }

      @Override
      public void afterTextChanged(Editable s) {

      }
    });
    return v;
  }
}
