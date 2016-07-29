package ua.dashan.caloriya;


import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
//класс по созданию диалогового окна
public class CustomDialogFragment extends DialogFragment implements
        DialogInterface.OnClickListener {
    DetailMan detailMan =new DetailMan();
    private View form=null;



    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        form= getActivity().getLayoutInflater()
                .inflate(R.layout.emailform, null);
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        return(builder.setTitle("Для отправки данных на почту введите ваш email").setView(form)
                .setPositiveButton(android.R.string.ok, this)
                .setNegativeButton(android.R.string.cancel, null).create());

    }
    @Override
    public void onClick(DialogInterface dialog, int which) {
        EditText loginBox=(EditText)form.findViewById(R.id.email);
        final String email = loginBox.getText().toString();
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {

                  //  Bundle bundle = new Bundle();
                  //  String allDannie = bundle.getString("allDannie");

                  //  String allDannie = getArguments().getString("allDannie");
                   // String value = getIntent.getExtra("String key which you used when send value");
                    String allDannie = DetailMan.getAllInfo();

                    GMailSender sender = new GMailSender("stsndrd@gmail.com",
                            "password");



                    sender.sendMail("Caloriya",allDannie ,
                            "stsndrd@gmail.com", email);
                } catch (Exception e) {
                    Log.e("SendMail", e.getMessage(), e);
                }
            }

        }).start();


      /*  TextView loginText = (TextView)getActivity().findViewById(R.id.loginText);
        TextView passwordText = (TextView)getActivity().findViewById(R.id.passwordText);
        loginText.setText(login);
        passwordText.setText(password);*/
    }
    @Override
    public void onDismiss(DialogInterface unused) {
        super.onDismiss(unused);
    }
    @Override
    public void onCancel(DialogInterface unused) {
        super.onCancel(unused);
    }
}