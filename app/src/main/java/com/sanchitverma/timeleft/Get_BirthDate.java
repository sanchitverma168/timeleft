package com.sanchitverma.timeleft;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;

public class Get_BirthDate extends AppCompatActivity {
    protected static int MAX_YEAR = 100;
    Button get_date;
    EditText date, month, year;
    TextView time_left_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_birtdate);
//        AppCenter.start(getApplication(), String.valueOf(R.string.appCenterSecretKey),Analytics.class, Crashes.class);
        AppCenter.start(getApplication(), "a21addb5-e3b5-4bf3-a56e-a1ca49785f6b",Analytics.class, Crashes.class);
        date = findViewById(R.id.date);
        month = findViewById(R.id.month);
        year = findViewById(R.id.year);
        get_date = findViewById(R.id.get_date);
        time_left_text = findViewById(R.id.time_left_text);

        get_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int d, m, y;
              String de=  date.getText().toString();
                if(!de.equals("") && de.equals(null))
                {
                    Log.d("success","error");

                }
                else{
                    Log.d("error","error");
                }

//                d = Integer.parseInt(date.getText().toString());
//                m = Integer.parseInt(month.getText().toString());
//                y = Integer.parseInt(year.getText().toString());

//                SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());
//                String formattedDate = df.format(c);
                time_left_text.setText(formatting_date("m"));
            }
        });

    }

    protected String formatting_date(String format_type) {
        Date c = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat(format_type, Locale.getDefault());
        return df.format(c);
    }


}