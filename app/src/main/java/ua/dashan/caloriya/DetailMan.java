package ua.dashan.caloriya;


import android.app.ActionBar;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DetailMan extends AppCompatActivity {
    private String maloaktiv="малоактивный";
    private String legkaya_aktiv="лёгкая активность";
    private String srednaya_aktiv="средняя активность";
    private String visokaya_aktiv="высокая активность";
    private  int form2;
    private  int form3;
    private  String fTarget;
//private TextView textView7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_man);
        TextView textView=(TextView)findViewById(R.id.textView2);
        //TextView textView2=(TextView)findViewById(R.id.textView3);
       // TextView textView3=(TextView)findViewById(R.id.textView4);
        //TextView textView4=(TextView)findViewById(R.id.textView5);
       // TextView textView5=(TextView)findViewById(R.id.textView6);
       // TextView textView6=(TextView)findViewById(R.id.formula);
        // textView7=(TextView)findViewById(R.id.sovpadenie);
        Intent intent = getIntent();
         fTarget = intent.getStringExtra("target");
        String fWeight = intent.getStringExtra("weight");
        int weight =Integer.parseInt(fWeight);
        String fHeight = intent.getStringExtra("height");
        int height =Integer.parseInt(fHeight);
        String fAge = intent.getStringExtra("age");
        int age =Integer.parseInt(fAge);
        String fSpinner = intent.getStringExtra("spinner");

        int formula = (int) ((9.99*weight)+(6.25*height)-(4.92*age)+5);

      if(fSpinner.equals(maloaktiv)) {
           form2 = (int) (1.2 * formula);
         // textView7.setText(Integer.toString(form2));
      } else if(fSpinner.equals(legkaya_aktiv)){
            form2 = (int) (1.4*formula);
          //textView7.setText(Integer.toString(form2));
        }else if(fSpinner.equals(srednaya_aktiv)) {
          form2 = (int) (1.6 * formula);
         // textView7.setText(Integer.toString(form2));
      }else if(fSpinner.equals(visokaya_aktiv)){
            form2 = (int) (1.8*formula);
         // textView7.setText(Integer.toString(form2));
      }
        if(fTarget.equals("похудение")){
            form3=form2-(form2/100*15);
            textView.setText("Вам нужно потреблять "+form3+" каллорий в день");
        } if(fTarget.equals("удержание веса")){
            textView.setText("Вам нужно потреблять "+form2+" каллорий в день");
        }if(fTarget.equals("набор массы")){
            form3=form2+(form2/100*15);
            textView.setText("Вам нужно потреблять "+form3+" каллорий в день");
        }
//вставляем фрагмент со списком в контейнер
        ExerciseFragment frag = (ExerciseFragment)getSupportFragmentManager().findFragmentByTag("mainFrag");
        if(frag==null) {
            frag = new ExerciseFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.exercise_container, frag, "mainFrag");
            ft.commit();
        }




         /*String value= et.getText().toString();
                int finalValue=Integer.parseInt(value);*/

       // textView.setText(fTarget);
        //textView2.setText(fWeight);
       // textView3.setText(fHeight);
        //textView4.setText(fAge);
        //textView5.setText(fSpinner);
        //textView6.setText("формула "+formula);


    }
    //добавляем элементы в список
    public List<Exercise> getSetExerciseList () {
        List<Exercise> listAux = new ArrayList<Exercise>();
        if (fTarget.equals("похудение")) {
            String[] name = {"Бег", "Прыжки на скакалке"};
            String[] description = {"Уморительный", "Быстрые"};
            int[] photos = {R.drawable.maxresdefault, R.drawable.skakalka};
           listAux = new ArrayList<Exercise>();
            for (int i = 0; i < name.length; i++) {
                Exercise e = new Exercise(name[i], description[i], photos[i]);
                listAux.add(e);
            }
            return (listAux);
        }

        if (fTarget.equals("удержание веса")) {
            String[] name = {"Присед", "Жим лёжа"};
            String[] description = {"Уморительный", "Быстрые"};
            int[] photos = {R.drawable.maxresdefault, R.drawable.skakalka};
           listAux = new ArrayList<Exercise>();
            for (int i = 0; i < name.length; i++) {
                Exercise e = new Exercise(name[i], description[i], photos[i]);
                listAux.add(e);
            }
            return (listAux);
        }

        else if(fTarget.equals("набор массы")) {
            String[] name = {"Еда", "Комп"};
            String[] description = {"Уморительный", "Быстрые"};
            int[] photos = {R.drawable.maxresdefault, R.drawable.skakalka};
           listAux = new ArrayList<Exercise>();
            for (int i = 0; i < name.length; i++) {
                Exercise e = new Exercise(name[i], description[i], photos[i]);
                listAux.add(e);
            }
            return (listAux);
        }

       return (listAux);
    }

}
