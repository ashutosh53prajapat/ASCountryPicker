package com.ashu.as_codepicker;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.List;

public class CountriesActivity extends AppCompatActivity {
    Activity activity=this;
    private List<ModelCountyCode> list;
    RecyclerView rvCode;
    EditText etSearch;
    String countryName="",selectedCode="";
    private CountryCodeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countries);
        rvCode=findViewById(R.id.rvCode);
        etSearch=findViewById(R.id.etSearch);
        setUpViews();
        setUpRv();

    }

    private void setUpViews() {
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }


    private void setUpRv() {

        rvCode.setLayoutManager(new LinearLayoutManager(activity));
        list= Utils.getLibraryMasterCountriesEnglish();

        adapter=new CountryCodeAdapter(list, activity, new RvClick() {
            @Override
            public void onClick(String nm, String code) {

                selectedCode=code;
                countryName=nm;
                returnIntent();
            }
        });
        rvCode.setAdapter(adapter);
    }


    private void returnIntent(){
        Intent returnIntent = new Intent();
        returnIntent.putExtra(Utils.KEY_FOR_NAME,countryName);
        returnIntent.putExtra(Utils.KEY_FOR_CODE,selectedCode);
        returnIntent.putExtra(Utils.KEY_FOR_CODE_WITH_PLUS,"+"+selectedCode);
        setResult(Activity.RESULT_OK,returnIntent);
        finish();
    }

}
