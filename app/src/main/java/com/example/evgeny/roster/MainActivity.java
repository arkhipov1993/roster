package com.example.evgeny.roster;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    public SharedPreferences prefs;
    public SharedPreferences.Editor  prefsEditor;


    private static SeekBar seekbarone, seekbartwo,seekbarthree;
    private static TextView textviewone,textviewtwo,textviewthree;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Spinner mySpinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.eyes));

        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mySpinner.setAdapter(myAdapter);

        prefs = getSharedPreferences("MyApp",MODE_PRIVATE);
        prefsEditor= prefs.edit();

//        Getting value for editTexts
        String s =prefs.getString("firstName",null);
        EditText t = (EditText)findViewById(R.id.editText3);
        t.setText(s);
        ((EditText)findViewById(R.id.editText2)).setText(prefs.getString("lastName",null));

//        Getting value for checkbox
        Boolean checkload = prefs.getBoolean("checkbox",false);
        CheckBox ch = (CheckBox)findViewById(R.id.checkBox);
        ch.setChecked(checkload);
//        Getting calendar value
        int day = prefs.getInt("day", 1);
        int month =prefs.getInt("month",1);
        int year = prefs.getInt("year",1993);
        DatePicker dp = (DatePicker)findViewById(R.id.datePicker);
        dp.updateDate(year,month,day);

//        getting radio buttons values
        Boolean button2 = prefs.getBoolean("button2",false);
        RadioButton rb2 = (RadioButton)findViewById(R.id.radioButton2);
        rb2.setChecked(button2);

        Boolean button3 = prefs.getBoolean("button3",false);
        RadioButton rb3 = (RadioButton)findViewById(R.id.radioButton3);
        rb3.setChecked(button3);

        Boolean button4 = prefs.getBoolean("button4",false);
        RadioButton rb4 = (RadioButton)findViewById(R.id.radioButton4);
        rb4.setChecked(button4);

        Boolean button5 = prefs.getBoolean("button5",false);
        RadioButton rb5 = (RadioButton)findViewById(R.id.radioButton5);
        rb5.setChecked(button5);

        Boolean button6 = prefs.getBoolean("button6",false);
        RadioButton rb6 = (RadioButton)findViewById(R.id.radioButton6);
        rb6.setChecked(button6);

        Boolean button7 = prefs.getBoolean("button7",false);
        RadioButton rb7 = (RadioButton)findViewById(R.id.radioButton7);
        rb7.setChecked(button7);

//        getting seekbar values
        int size1 = prefs.getInt("size1",4);
        SeekBar sb1 = (SeekBar)findViewById(R.id.seekBar1);
        sb1.setProgress(size1);

        int size2 = prefs.getInt("size2",4);
        SeekBar sb2 = (SeekBar)findViewById(R.id.seekBar2);
        sb2.setProgress(size2);

        int size3 = prefs.getInt("size3",4);
        SeekBar sb3 = (SeekBar)findViewById(R.id.seekBar3);
        sb3.setProgress(size3);


//        getting spinner items position
        int spinnerposition = prefs.getInt("spinnerPosition",1);
        Spinner sp1 = (Spinner)findViewById(R.id.spinner);
        sp1.setSelection(spinnerposition);

        PantsSize();
        ShirtSize();
        ShoeSize();






    }

    public void PantsSize(){
         seekbarone =(SeekBar) findViewById(R.id.seekBar1);
        textviewone=(TextView)findViewById(R.id.textView01);
        textviewone.setText("size: "+seekbarone.getProgress()+ "/"+seekbarone.getMax());

        seekbarone.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            int progressValue;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressValue=progress;
                textviewone.setText("size: "+seekbarone.getProgress()+ "/"+seekbarone.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }


    public void ShirtSize(){
        seekbartwo =(SeekBar) findViewById(R.id.seekBar2);
        textviewtwo=(TextView)findViewById(R.id.textView02);
        textviewtwo.setText("size: "+seekbartwo.getProgress()+ "/"+seekbartwo.getMax());

        seekbartwo.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            int progressValue;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressValue=progress;
                textviewtwo.setText("size: "+seekbartwo.getProgress()+ "/"+seekbartwo.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }


    public void ShoeSize(){
        seekbarthree =(SeekBar) findViewById(R.id.seekBar3);
        textviewthree=(TextView)findViewById(R.id.textView03);
        textviewthree.setText("size: "+(seekbarthree.getProgress()+4)+ "/"+(seekbarthree.getMax()+4));

        seekbarthree.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            int progressValue;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressValue=progress;
                textviewthree.setText("size: "+ (seekbarthree.getProgress()+4)+ "/"+(seekbarthree.getMax()+4));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void saveForm (View v){

//        editText Saving
        EditText t = (EditText)findViewById(R.id.editText3);
        String s= t.getText().toString();
        prefsEditor.putString("firstName",s);
        prefsEditor.putString("lastName",((EditText)findViewById(R.id.editText2)).getText().toString());

//        checkbox saving
        CheckBox ch = (CheckBox)findViewById(R.id.checkBox);
        Boolean ch2 = ch.isChecked();
        prefsEditor.putBoolean("checkbox",ch2);

//        calendar saving
        DatePicker dp = (DatePicker)findViewById(R.id.datePicker);
        int day = dp.getDayOfMonth();
        prefsEditor.putInt("day",day);
        int month = dp.getMonth();
        prefsEditor.putInt("month",month);
        int year = dp.getYear();
        prefsEditor.putInt("year",year);

//        radio buttons saving
        RadioButton rb2 = (RadioButton)findViewById(R.id.radioButton2);
        Boolean button2= rb2.isChecked();
        prefsEditor.putBoolean("button2",button2);

        RadioButton rb3 = (RadioButton)findViewById(R.id.radioButton3);
        Boolean button3= rb3.isChecked();
        prefsEditor.putBoolean("button3",button3);

        RadioButton rb4 = (RadioButton)findViewById(R.id.radioButton4);
        Boolean button4= rb4.isChecked();
        prefsEditor.putBoolean("button4",button4);

        RadioButton rb5 = (RadioButton)findViewById(R.id.radioButton5);
        Boolean button5= rb5.isChecked();
        prefsEditor.putBoolean("button5",button5);

        RadioButton rb6 = (RadioButton)findViewById(R.id.radioButton6);
        Boolean button6= rb6.isChecked();
        prefsEditor.putBoolean("button6",button6);

        RadioButton rb7 = (RadioButton)findViewById(R.id.radioButton7);
        Boolean button7= rb7.isChecked();
        prefsEditor.putBoolean("button7",button7);

//        seekbar value saving
        SeekBar sb1 = (SeekBar)findViewById(R.id.seekBar1);
        int size1 = sb1.getProgress();
        prefsEditor.putInt("size1", size1);

        SeekBar sb2 = (SeekBar)findViewById(R.id.seekBar2);
        int size2 = sb2.getProgress();
        prefsEditor.putInt("size2", size2);

        SeekBar sb3 = (SeekBar)findViewById(R.id.seekBar3);
        int size3 = sb3.getProgress();
        prefsEditor.putInt("size3", size3);


//      saving dropdown list
        Spinner sp = (Spinner)findViewById(R.id.spinner);
        int spinnerPosition = sp.getSelectedItemPosition();
        prefsEditor.putInt("spinnerPosition",spinnerPosition);


        prefsEditor.commit();



    }
}
