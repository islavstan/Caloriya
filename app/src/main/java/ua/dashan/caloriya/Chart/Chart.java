package ua.dashan.caloriya.Chart;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.numetriclabz.numandroidcharts.ChartData;
import com.numetriclabz.numandroidcharts.DonutChart;
import com.numetriclabz.numandroidcharts.SemiCircle;

import ua.dashan.caloriya.DetailMan;
import ua.dashan.caloriya.R;


public class Chart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chart);

        SemiCircle semiChart = (SemiCircle) findViewById(R.id.semi_circle_chart);

        ChartData values = new ChartData();

        values.setSectorValue(DetailMan.getBelki1());
        values.setSectorLabel("Белки " +DetailMan.getBelki1()+"г.");
        semiChart.addSector(values);

        values = new ChartData();
        values.setSectorValue(DetailMan.getFat1());
        values.setSectorLabel("Жиры "+DetailMan.getFat1()+"г.");
        semiChart.addSector(values);

        values = new ChartData();
        values.setSectorValue(DetailMan.getCarbohydrate1());
        values.setSectorLabel("Углеводы "+DetailMan.getCarbohydrate1()+"г.");
        semiChart.addSector(values);


    }
}
