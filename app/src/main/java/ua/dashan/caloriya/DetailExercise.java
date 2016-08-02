package ua.dashan.caloriya;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DetailExercise  extends AppCompatActivity {
    List<Exercise> exerciseList;
    DetailMan detailMan;
    private CollapsingToolbarLayout collapsingToolbarLayout = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_exercise);


       /* Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int position =bundle.getInt("position");*/
        int position = getIntent().getExtras().getInt("position");
//        exerciseList=detailMan.getSetExerciseList();
         //DetailMan.getSetExerciseList();
       //String info = exerciseList.get(position).getDescription();


        ImageView imageView =(ImageView)findViewById(R.id.image);
        imageView.setImageResource(DetailMan.getSetExerciseList().get(position).getPhoto());

        TextView textExercise=(TextView)findViewById(R.id.text_exercise);
        textExercise.setText( DetailMan.getSetExerciseList().get(position).getDescription());


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle(DetailMan.getSetExerciseList().get(position).getName());
    }
}
