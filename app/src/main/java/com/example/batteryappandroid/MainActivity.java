package com.example.batteryappandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView chooseparametrBattery, capacityBattery, chooseDevice,
            powerDevice, numberDevice, voltageBattery, numberBattery;
    TextView resultText;
    private Spinner capacityBatterySpinner, voltageLampSpinner, numberOfLampSpinner,
            voltageBatterySpinner, voltageLedSpinner, numberOfLEDspinner,
            modulsCapacitySpinner, numberOfBatteriesSpinner, numberOfModulsSpinner;

    private CheckBox checkBoxLamp, checkBoxledTape, checkBoxModulLed;

    private Button calculate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultText = findViewById(R.id.resultText);
        chooseparametrBattery = findViewById(R.id.chooseparametrBattery);
        capacityBattery = findViewById(R.id.capacityBattery);
        chooseDevice = findViewById(R.id.chooseDevice);
        powerDevice = findViewById(R.id.powerDevice);
        numberDevice = findViewById(R.id.numberDevice);
        voltageBattery = findViewById(R.id.voltageBattery);
        numberBattery = findViewById(R.id.numberBattery);

        capacityBatterySpinner = findViewById(R.id.capacityBatterySpinner);


        numberOfBatteriesSpinner = findViewById(R.id.numberOfBatteriesSpinner);


        voltageBatterySpinner = findViewById(R.id.voltageBatterySpinner);


        voltageLampSpinner = findViewById(R.id.voltageLampSpinner);

        numberOfLampSpinner = findViewById(R.id.numberOfLampSpinner);


        voltageLedSpinner = findViewById(R.id.voltageLedSpinner);

        numberOfLEDspinner = findViewById(R.id.numberOfLEDspinner);

        modulsCapacitySpinner = findViewById(R.id.modulsCapacitySpinner);
        numberOfModulsSpinner = findViewById(R.id.numberOfModulsSpinner);


        calculate = findViewById(R.id.calculate);


        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                resultText.setText(calculateTime());
//                Intent intent = new Intent(Intent.ACTION_SEND);
//                intent.setType("text/plain");
//
//                intent.putExtra(Intent.EXTRA_TEXT, calculateTime());
//                startActivity(intent);
            }
        });


    }

    public String calculateTime() {
        int voltageLamp = Integer.valueOf((String) voltageLampSpinner.getSelectedItem());
        int numberOfLamp = Integer.valueOf((String) numberOfLampSpinner.getSelectedItem());
        int numberOfBatteries = Integer.valueOf((String) numberOfBatteriesSpinner.getSelectedItem());
        int capacityBattery = Integer.valueOf((String) capacityBatterySpinner.getSelectedItem());

        int voltageBattery = Integer.valueOf((String) voltageBatterySpinner.getSelectedItem());

        int voltageLed = Integer.valueOf((String) voltageLedSpinner.getSelectedItem());
        int numberOfLED = Integer.valueOf((String) numberOfLEDspinner.getSelectedItem());
        int modulsCapacity = Integer.valueOf((String) modulsCapacitySpinner.getSelectedItem());
        int numberOfModuls = Integer.valueOf((String) numberOfModulsSpinner.getSelectedItem());

        try {

            int lampAmper = (voltageLamp * numberOfLamp) / 12;
            int ledAmper = (voltageLed * numberOfLED) / 12;
            int modulAmper = (modulsCapacity * numberOfModuls)/12;

            int deviceAmper = lampAmper +ledAmper+modulAmper;


            int hoursOfWork = (capacityBattery * numberOfBatteries) / deviceAmper;
            int secOfWork = hoursOfWork * 3600;
            int hour = (secOfWork) / 3600;
            int min = (secOfWork) / 60 % 60;
            int sec = (secOfWork) / 1 % 60;
            String timeWork = String.format("%02d:%02d:%02d", hour, min, sec);
            return timeWork;
        } catch (ArithmeticException e) {
            System.out.println("divided on zero");
        }
        return "choose parametrs";
    }

}
