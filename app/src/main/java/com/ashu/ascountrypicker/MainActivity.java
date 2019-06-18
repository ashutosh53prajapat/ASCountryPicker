package com.ashu.ascountrypicker;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.ashu.as_codepicker.CountriesActivity;
import com.ashu.as_codepicker.Utils;

public class MainActivity extends AppCompatActivity {
    TextView tvCode;
    Activity activity=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvCode=findViewById(R.id.tvCode);
        tvCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(activity, CountriesActivity.class),Utils.INTENT_FOR_CODE);
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == Utils.INTENT_FOR_CODE) {
            if(resultCode == Activity.RESULT_OK){
                String rName=data.getStringExtra(Utils.KEY_FOR_NAME);
                String rCode=data.getStringExtra(Utils.KEY_FOR_CODE_WITH_PLUS);
                tvCode.setText(rCode+" "+rName);
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }
}
