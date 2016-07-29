package ua.dashan.caloriya;


import android.app.ActionBar;
import android.app.Activity;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

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
    private TextView belki;
    private TextView fat;
    private TextView carbohydrate;
    Snackbar menu;
    private Intent intent;
    private static String allInfo;

    public static String getAllInfo() {
        return allInfo;
    }

    public static void setAllInfo(String allInfo) {
        DetailMan.allInfo = allInfo;
    }
    //private TextView textView7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_man);
        //здесь всё относится к ToolBar
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setTitle("Детали");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        TextView textView=(TextView)findViewById(R.id.textView2);
        belki=(TextView)findViewById(R.id.belki);
        fat=(TextView)findViewById(R.id.fat);
        carbohydrate=(TextView)findViewById(R.id.carbohydrate);
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

        Intent intent1 =new Intent(DetailMan.this,DetailExercise.class);
        intent.putExtra("target",fTarget);
         startActivity(intent);

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
            textView.setText("Вам нужно потреблять "+form3+" каллорий в день.");
            int belki1 = (int) (form3*0.3)/4;
            int belki2 = (int) (form3*0.35)/4;
            belki.setText(Html.fromHtml("<b>Белки</b> (нижний предел) = "+belki1+"г. "+"<b>Белки</b> (верхний предел) = "+belki2+"г. "));


            int fat1 = (int) (form3*0.15)/9;
            int fat2 = (int) (form3*0.20)/9;
            fat.setText(Html.fromHtml("<b>Жиры</b> (нижний предел) = "+fat1+"г. "+"<b>Жиры</b> (верхний предел) = "+fat2+"г. "));

            int carbohydrate1 = (int) (form3*0.45)/4;
            int carbohydrate2 = (int) (form3*0.50)/4;
            carbohydrate.setText(Html.fromHtml("<b>Углеводы</b> (нижний предел) = "+carbohydrate1+"г. "+"<b>Углеводы</b> (верхний предел) = "+carbohydrate2+"г. "));



        } if(fTarget.equals("удержание веса")){
            textView.setText("Вам нужно потреблять "+form2+" каллорий в день.");
            int belki1 = (int) (form2*0.3)/4;
            int belki2 = (int) (form2*0.35)/4;
            belki.setText(Html.fromHtml("<b>Белки</b> (нижний предел) = "+belki1+"г. "+"<b>Белки</b> (верхний предел) = "+belki2+"г. "));


            int fat1 = (int) (form2*0.15)/9;
            int fat2 = (int) (form2*0.20)/9;
            fat.setText(Html.fromHtml("<b>Жиры</b> (нижний предел) = "+fat1+"г. "+"<b>Жиры</b> (верхний предел) = "+fat2+"г. "));

            int carbohydrate1 = (int) (form2*0.45)/4;
            int carbohydrate2 = (int) (form2*0.50)/4;
            carbohydrate.setText(Html.fromHtml("<b>Углеводы</b> (нижний предел) = "+carbohydrate1+"г. "+"<b>Углеводы</b> (верхний предел) = "+carbohydrate2+"г. "));


        }if(fTarget.equals("набор массы")){
            form3=form2+(form2/100*15);
            textView.setText("Вам нужно потреблять "+form3+" каллорий в день.");
            int belki1 = (int) (form3*0.3)/4;
            int belki2 = (int) (form3*0.35)/4;
            belki.setText(Html.fromHtml("<b>Белки</b> (нижний предел) = "+belki1+"г. "+"<b>Белки</b> (верхний предел) = "+belki2+"г. "));

            int fat1 = (int) (form3*0.15)/9;
            int fat2 = (int) (form3*0.20)/9;
            fat.setText(Html.fromHtml("<b>Жиры</b> (нижний предел) = "+fat1+"г. "+"<b>Жиры</b> (верхний предел) = "+fat2+"г. "));

            int carbohydrate1 = (int) (form3*0.45)/4;
            int carbohydrate2 = (int) (form3*0.50)/4;
            carbohydrate.setText(Html.fromHtml("<b>Углеводы</b> (нижний предел) = "+carbohydrate1+"г. "+"<b>Углеводы</b> (верхний предел) = "+carbohydrate2+"г. "));

        }



//вставляем фрагмент со списком в контейнер
        ExerciseFragment frag = (ExerciseFragment)getSupportFragmentManager().findFragmentByTag("mainFrag");
        if(frag==null) {
            frag = new ExerciseFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.exercise_container, frag, "mainFrag");
            ft.commit();
        }

        allInfo = textView.getText().toString()+" Для достижения Вашей цели рекомендуем: " +belki.getText().toString()+
                fat.getText().toString()+carbohydrate.getText().toString();

       // intent = new Intent(DetailMan.this,GMailSender.class);
       // intent.putExtra("allDannie",allDannie);

       /* //передаём всю инфу в CustomDialogFragment чтобы потом отправить всё по почте
        Bundle bundle =new Bundle();
        bundle.putString("allDannie",allDannie);
        CustomDialogFragment dialogFragment =new CustomDialogFragment();
        dialogFragment.setArguments(bundle);
*/


         /*String value= et.getText().toString();
                int finalValue=Integer.parseInt(value);*/

       // textView.setText(fTarget);
        //textView2.setText(fWeight);
       // textView3.setText(fHeight);
        //textView4.setText(fAge);
        //textView5.setText(fSpinner);
        //textView6.setText("формула "+formula);


    }
  /*  public static CustomDialogFragment newInstance(String f) {
        CustomDialogFragment d = new CustomDialogFragment();

        Bundle args = new Bundle();
        args.putString("allDannie", f);
        d.setArguments(args);

        return d;
    }*/

    //добавляем элементы в список
    public List<Exercise> getSetExerciseList () {

        List<Exercise> listAux = new ArrayList<Exercise>();
        if (fTarget.equals("похудение")) {
            String[] name = {"Вода", "Прыжки на скакалке","Сковорода"};
            String[] description = {"8 стаканов в день", "интенсивные упражнения","здоровое питание"};
            int[] photos = {R.drawable.voda, R.drawable.skakalka, R.drawable.scovoroda};
           listAux = new ArrayList<Exercise>();
            for (int i = 0; i < name.length; i++) {
                Exercise e = new Exercise(name[i], description[i], photos[i]);
                listAux.add(e);
            }
            return (listAux);
        }

        if (fTarget.equals("удержание веса")) {
            String[] name = {"Вода", "Питание","Спорт"};
            String[] description = {"8 стаканов в день", "важнейшая составляющая","активный образ жизни"};
            int[] photos = {R.drawable.voda, R.drawable.pitanie,R.drawable.fitness };
           listAux = new ArrayList<Exercise>();
            for (int i = 0; i < name.length; i++) {
                Exercise e = new Exercise(name[i], description[i], photos[i]);
                listAux.add(e);
            }
            return (listAux);
        }

        else if(fTarget.equals("набор массы")) {
            String[] name = {"Вода", " Большие и малые веса","Правильный хват","Становая тяга"};
            String[] description = {"8 стаканов в день", "чередуйте большие и малые веса","вырабатываем правильный хват","откатываем штангу назад"};
            int[] photos = {R.drawable.voda, R.drawable.vesa,R.drawable.hvat,R.drawable.stanovaya};
           listAux = new ArrayList<Exercise>();
            for (int i = 0; i < name.length; i++) {
                Exercise e = new Exercise(name[i], description[i], photos[i]);
                listAux.add(e);
            }
            return (listAux);
        }

       return (listAux);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        } if(id == R.id.send){

           new CustomDialogFragment().show(getSupportFragmentManager(),
                    "login");
        /*   new Thread(new Runnable() {

                @Override
                public void run() {
                    try {
                        GMailSender sender = new GMailSender("email",
                                "password");
                        sender.sendMail("Hello from JavaMail", "Даша",
                                "stsndrd@gmail.com", "islavstan@gmail.com");
                    } catch (Exception e) {
                        Log.e("SendMail", e.getMessage(), e);
                    }
                }

            }).start();

*/
        }

        return super.onOptionsItemSelected(item);
    }

}
