package com.example.myapplication02;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;
//明日学院 P46 日期选择器
public class MainActivity extends Activity {
    int year,month,day;
    DatePicker datePicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        datePicker = findViewById(R.id.datepicker);
        Calendar calendar = Calendar.getInstance(); //定义一个日期对象
        year =calendar.get(Calendar.YEAR);
        month=calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                MainActivity.this.year=year;
                MainActivity.this.month=monthOfYear;
                MainActivity.this.day=dayOfMonth;
                show(year,monthOfYear,dayOfMonth);
            }
        });
    }
    private  void show(int year,int month,int day){
        String str=year+"年"+(month+1)+"月"+day+"日";
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}
