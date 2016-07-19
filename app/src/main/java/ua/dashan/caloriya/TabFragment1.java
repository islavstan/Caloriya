package ua.dashan.caloriya;

import android.app.Dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
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
import android.widget.Spinner;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;


public class TabFragment1 extends Fragment implements  AdapterView.OnItemSelectedListener {
    private Spinner spinner;
    private EditText target;
    private EditText weight;
    private EditText height;
    private EditText age;
    private Snackbar s;
    private Button button;
  // private int selected;
    private String lifeStyle;
private Intent intent;


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.tab_fragment_1, container, false);
        weight = (EditText)v.findViewById(R.id.weight);
        height = (EditText)v.findViewById(R.id.height);
        age = (EditText)v.findViewById(R.id.age);
        button=(Button)v.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // FragmentTransaction trans = getFragmentManager().beginTransaction();
               // trans.replace(R.id.root_frame, new SecondFragment());
                 intent = new Intent(getActivity(),DetailMan.class);
                intent.putExtra("target",target.getText().toString());
                intent.putExtra("weight",weight.getText().toString());
                intent.putExtra("height",height.getText().toString());
                intent.putExtra("age",age.getText().toString());
                intent.putExtra("spinner",lifeStyle);


                /*String value= et.getText().toString();
                int finalValue=Integer.parseInt(value);*/
                getActivity().startActivity(intent);


            }
        });
        target=(EditText)v.findViewById(R.id.target);
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
        ArrayAdapter<CharSequence> lifeStyleAdapter =  ArrayAdapter.createFromResource(getActivity(),R.array.lifestyle,
                android.R.layout.simple_spinner_item);
        lifeStyleAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(lifeStyleAdapter);
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



    @Override
    //метод для смены цвета таба, здесь передаём значение 1 в MainActivity, там есть метод который принимает эту еденицу
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser)
        {
            ColorChangeInterface colorChangeInterface = (ColorChangeInterface) getActivity();
            colorChangeInterface.setToolbarAndTabColor(1);
    }
}

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

