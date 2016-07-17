package ua.dashan.caloriya;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.text.InputType;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

public class TargetDialog extends DialogFragment {
    //в этом классе происходит вызов диалогового окна целей
   private EditText editText;
    View v;
    Snackbar s;

    public TargetDialog(EditText editText,Snackbar s,View v) {
        this.editText = editText;
        this.s=s;
        this.v=v;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
         //создаём массив целей
        final String[] targets = getResources().getStringArray(R.array.target);
        //заполняем диалог названием, целями и указываем обработчик нажатия
        return new AlertDialog.Builder(getActivity()).setTitle(R.string.alert_dialog_title).setItems(R.array.target, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //здесь передаём edittext наш выбор
                editText.setText(targets[which].toString());

                s.make(v, "Вы выбрали "+ editText.getText().toString() , Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();



            }
        }).create();


    }
}
