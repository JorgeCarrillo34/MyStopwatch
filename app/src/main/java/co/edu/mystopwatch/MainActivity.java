package co.edu.mystopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Chronometer cronometro;
    private long pausaOffset;
    private boolean avance;
    private int i=0;
    private int j=0;
    private ArrayList<String> vueltas = new ArrayList<>();
    private StringBuilder brandsFormatted = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cronometro= findViewById(R.id.chronometer);
//        cronometro.setFormat("Time: %s");
//        cronometro.setBase(SystemClock.elapsedRealtime());
        //cronometro.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            //@Override
            //public void onChronometerTick(Chronometer chronometer) {
              //  if ((SystemClock.elapsedRealtime()-chronometer.getBase()) >= 10000){
                   // cronometro.setBase(SystemClock.elapsedRealtime());
                   // Toast.makeText(MainActivity.this, "Bing", Toast.LENGTH_SHORT).show();
               // }
            //}
        //});
    }

    public void startCronometro(View view){
        if (!avance){
            cronometro.setBase(SystemClock.elapsedRealtime() - pausaOffset);
            cronometro.start();
            avance=true;
        }
    }

    public void pauseCronometro(View view){
        if (avance){
            cronometro.stop();
            pausaOffset= SystemClock.elapsedRealtime() - cronometro.getBase();
            avance=false;
        }
    }

    public void resetCronometro(View view){
        //long elapsed = (SystemClock.elapsedRealtime() - cronometro.getBase());
        String crono = cronometro.getText().toString();
        vueltas.add(crono);
        i++;
        brandsFormatted.append(i + ". ").append(vueltas.get(j)).append('\n');
        j++;
        TextView brand = (TextView)findViewById(R.id.vuelt);
        brand.setText(brandsFormatted);
        cronometro.setBase(SystemClock.elapsedRealtime());
        pausaOffset = 0;
    }

}