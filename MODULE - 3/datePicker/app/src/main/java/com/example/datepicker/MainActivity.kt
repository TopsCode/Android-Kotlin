package com.example.datepicker

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btn_date=findViewById<Button>(R.id.btn_date)
        var tv_displayDate=findViewById<TextView>(R.id.tv_displayDate)

        var btn_datePrevious=findViewById<Button>(R.id.btn_datePrevious)


        var btn_dateFuture=findViewById<Button>(R.id.btn_dateFuture)


        var popUpMenu=PopupMenu(this,btn_date);

        var calender=Calendar.getInstance();
        var year=calender.get(Calendar.YEAR);
        var month=calender.get(Calendar.MONTH);
        var day=calender.get(Calendar.DAY_OF_MONTH)




        btn_date.setOnClickListener {
            var dpd=DatePickerDialog(this,DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                tv_displayDate.text=getDateFormat(dayOfMonth,month,year);

            },year,month
                ,day)
        dpd.show();
        }
        btn_datePrevious.setOnClickListener {
            var dpd=DatePickerDialog(this,DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                tv_displayDate.text=getDateFormat(dayOfMonth,month,year);

            },year,month
                ,day)
            dpd.datePicker.maxDate=calender.timeInMillis;
            dpd.show();
        }
        btn_dateFuture.setOnClickListener {
            var dpd=DatePickerDialog(this,DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                tv_displayDate.text=getDateFormat(dayOfMonth,month,year);

            },year,month
                ,day)
            dpd.datePicker.minDate=calender.timeInMillis;
            dpd.show();


        }

    }

    fun getDateFormat(date1:Int ,month:Int ,year:Int): kotlin.String {

        return date1.toString() +"/"+month.toString()+"/"+year.toString();
    }

}



