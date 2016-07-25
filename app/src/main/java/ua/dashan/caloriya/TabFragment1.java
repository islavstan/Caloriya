package ua.dashan.caloriya;

import android.app.Dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.content.DialogInterface.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;


public class TabFragment1 extends Fragment implements  AdapterView.OnItemSelectedListener {
    private Spinner spinner;
    private EditText target;
    private EditText weight;
    private EditText height;
    private EditText age;
    private Snackbar s;
    private Button button;
    private TextView dannie;
    private TextView ves;


  // private int selected;
    private String lifeStyle;
private Intent intent;


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.tab_fragment_1, container, false);
      /*  ImageView image = (ImageView)v.findViewById(R.id.image);
        image.setImageResource(R.drawable.wei);*/
         //dannie = (TextView)v.findViewById(R.id.dannie);
        ves = (TextView)v.findViewById(R.id.ves);
      /* ves.setCompoundDrawablesWithIntrinsicBounds(
                R.drawable.scale, 0, 0, 0);*/
       /* Typeface typeFace2 = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Roboto-Regular.ttf");
        ves.setTypeface(typeFace2);

        Typeface typeFace = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Roboto-Regular.ttf");
        dannie.setTypeface(typeFace);*/







        weight = (EditText)v.findViewById(R.id.weight);

       Typeface typeFace = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Roboto-Thin.ttf");
        weight.setTypeface(typeFace);

        height = (EditText)v.findViewById(R.id.height);
        Typeface typeFace2 = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Roboto-Thin.ttf");
        height.setTypeface(typeFace2);

        age = (EditText)v.findViewById(R.id.age);
        Typeface typeFace3 = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Roboto-Thin.ttf");
        age.setTypeface(typeFace3);

        button=(Button)v.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

              //делаем проверку на пустоту полей



                if(target.getText().toString().equals("")||weight.getText().toString().equals("")||height.getText().toString().equals("")||
                        age.getText().toString().equals("")||lifeStyle.equals("")||weight.getText().toString().startsWith("0")
                        ||height.getText().toString().startsWith("0")||age.getText().toString().startsWith("0")){
                   s.make(v, "Что-то здесь не так(" , Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();}


                  /*if (weight.getText().toString().length()>0){
                      vesProverka = weight.getText().toString().substring(0,1);
                      if(vesProverka.compareTo("0")==0){
                    s.make(v, "Вес не может начинаться с 0" , Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }s.make(v, "Введите вес" , Snackbar.LENGTH_LONG)
                              .setAction("Action", null).show();}*/



                else{

               // FragmentTransaction trans = getFragmentManager().beginTransaction();
               // trans.replace(R.id.root_frame, new SecondFragment());

                 intent = new Intent(getActivity(),DetailMan.class);
                intent.putExtra("target",target.getText().toString());
                intent.putExtra("weight",weight.getText().toString());
                intent.putExtra("height",height.getText().toString());
                intent.putExtra("age",age.getText().toString());
                intent.putExtra("spinner",lifeStyle);
                getActivity().startActivity(intent);}

/*String value= et.getText().toString();
                int finalValue=Integer.parseInt(value);*/
            }
        });
        target=(EditText)v.findViewById(R.id.target);
        Typeface typeFace4= Typeface.createFromAsset(getActivity().getAssets(), "fonts/Roboto-Thin.ttf");
        target.setTypeface(typeFace4);
        //отключает появление клавиатуры на edittext
        target.setInputType(InputType.TYPE_NULL);
        target.requestFocus();


        target.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager=getFragmentManager();
                TargetDialog dialog = new TargetDialog(target,s,v);
                dialog.show(manager,"target");

            }
        });
        //заполняем выподающий список данными
        spinner =(Spinner)v.findViewById(R.id.spinner);

      /*  ArrayAdapter<CharSequence> lifeStyleAdapter =  ArrayAdapter.createFromResource(getActivity(),R.array.lifestyle,
                android.R.layout.simple_spinner_item);
        lifeStyleAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(lifeStyleAdapter);*/
        MySpinnerAdapter adapter = new MySpinnerAdapter(
                getContext(),
                android.R.layout.simple_spinner_item,
                Arrays.asList(getResources().getStringArray(R.array.lifestyle))
        );spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);
        //в переменную selected передаём позицию выбранного значения
        /* selected = spinner.getSelectedItemPosition();
        if (selected==0){
            lifeStyle="малоактивный";
        }if(selected==1){
            lifeStyle="лёгкая активность";}
        if(selected==2){
            lifeStyle="средняя активность";}
        if(selected==3){
            lifeStyle="высокая активность";}*/
        return v;

    }



/*    @Override
    //метод для смены цвета таба, здесь передаём значение 1 в MainActivity, там есть метод который принимает эту еденицу
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser)
        {
            ColorChangeInterface colorChangeInterface = (ColorChangeInterface) getActivity();
            colorChangeInterface.setToolbarAndTabColor(1);
    }
}*/

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // Получаем выбранный объект
        Object item = parent.getItemAtPosition(position);
        lifeStyle = item.toString();
        //selection.setText(item.toString());
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

