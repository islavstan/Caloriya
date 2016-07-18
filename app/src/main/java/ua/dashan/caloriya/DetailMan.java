package ua.dashan.caloriya;


import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetailMan extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_man);
        TextView textView=(TextView)findViewById(R.id.textView2);
        Intent intent = getIntent();
        String fTarget = intent.getStringExtra("target");
        textView.setText(fTarget);


    }


}
