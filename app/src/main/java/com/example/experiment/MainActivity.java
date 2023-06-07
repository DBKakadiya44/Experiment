package com.example.experiment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.experiment.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TimePicker timePicker;
    TextView setTime;
    private String am_pm;
    ActivityMainBinding binding;

    ArrayList<String> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        // getting our root layout in our view.
        //View view = binding.getRoot();

        // below line is to set
        // Content view for our layout.
        setContentView(binding.getRoot());
//        setContentView(R.layout.activity_main);
        //timePicker=findViewById(R.id.timePicker);
        setTime=findViewById(R.id.setTime);

//        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
//            @Override
//            public void onTimeChanged(TimePicker timePicker, int hours, int minutes) {
//                setTime.setText(""+hours+":"+minutes);
//                timePicker.setVisibility(View.GONE);
//            }
//        });
        setTime.setOnClickListener(new View.OnClickListener() {
            Calendar calendar=Calendar.getInstance();
            @Override
            public void onClick(View view) {
                TimePickerDialog dialog=new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {

                   @Override
                    public void onTimeSet(TimePicker timePicker, int hours, int minutes) {
                       calendar.set(Calendar.HOUR_OF_DAY, hours);
                       calendar.set(Calendar.MINUTE, minutes);
                       if (calendar.get(Calendar.AM_PM) == Calendar.AM) {
                           am_pm = "AM";
                       } else if (calendar.get(Calendar.AM_PM) == Calendar.PM) {
                           am_pm = "PM";
                       }
                       String strHrsToShow = (calendar.get(Calendar.HOUR) == 0) ?"12":Integer.toString( calendar.get(Calendar.HOUR) );

                       setTime.setText(""+strHrsToShow+":"+minutes+" "+am_pm);

                    }
                },calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),false);
                dialog.show();
            }

        });
    binding.male.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            binding.setTime.setText(""+binding.male.getText().toString());
        }
    });
        binding.female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.setTime.setText(""+binding.female.getText().toString());
            }
        });

        binding.java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(binding.java.isChecked())
                {
                    list.add("Java/");
                    binding.setTime.setText(""+list.get(0));
                }
                else if(!binding.java.isChecked())
                {
                    list.remove("Java/");
                    binding.setTime.setText(""+list.get(0));
                }
               // binding.setTime.setText(""+binding.java.getText().toString());
            }
        });
        binding.kotlin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(binding.kotlin.isChecked())
                {
                    list.add("Kotlin/");
                    binding.setTime.setText(""+list.get(1));
                }
                else if(!binding.kotlin.isChecked())
                {
                    list.remove("Kotlin/");
                    binding.setTime.setText(""+list.get(1));
                }
            }
        });
        binding.python.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    if(binding.python.isChecked())
                    {
                        list.add("Python/");
                        binding.setTime.setText(""+list.get(2));
                    }
                    else if(!binding.python.isChecked())
                    {
                        list.remove("Python/");
                        binding.setTime.setText(""+list.get(2));
                    }
            }
        });
        //binding.setTime.setText(""+list);
    }

}