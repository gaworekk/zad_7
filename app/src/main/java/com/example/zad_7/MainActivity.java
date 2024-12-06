package com.example.zad_7;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Patterns;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    private TextView like;
    private Button usun;
    private Button dod;
    private EditText mail;
    private EditText haslo;
    private EditText phaslo;
    private Button save;
    private Button check;
    private TextView wys;
    private int a=0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        like=findViewById(R.id.polubienia);
        usun=findViewById(R.id.del);
        dod=findViewById(R.id.dod);
        mail=findViewById(R.id.mail);
        haslo=findViewById(R.id.haslo);
        phaslo=findViewById(R.id.phaslo);
        save=findViewById(R.id.save);
        check=findViewById(R.id.check);
        wys=findViewById(R.id.wys);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input_email=mail.getText().toString().trim();
                String input_haslo=haslo.getText().toString().trim();
                String input_phaslo =phaslo.getText().toString().trim();

                if(input_email.isEmpty()){
                    wys.setText("Wypelnij pole E-mail");
                    return;
                }
                if(input_haslo.isEmpty()){
                    wys.setText("Wypelnij pole Haslo");
                    return;
                }
                if(input_phaslo.isEmpty()){
                    wys.setText("Wypelnij pole Powtorz haslo");
                    return;
                }
                if(!Patterns.EMAIL_ADDRESS.matcher(input_email).matches()){
                    wys.setText("Email jest nie poprawny");
                    return;
                }
                if(!input_phaslo.equals(input_haslo)){
                    wys.setText("Haslo musi sie powtarzac");
                    return;
                }
                if(!input_email.isEmpty() && !input_haslo.isEmpty() && !input_phaslo.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(input_email).matches() && input_phaslo.equals(input_haslo)){
                    wys.setText("Zajerestrowano "+input_email);

                }
            }
        });
        dod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a++;
                like.setText(a+" polubienia");
            }
        });
        usun.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(a>0){
                    a--;
                    like.setText(a+" polubienia");
                }
            }
        });
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input_email=mail.getText().toString().trim();
                if(input_email.isEmpty()){
                    wys.setText("Nie podano emaila");
                }else {
                    wys.setText(input_email);
                }
            }
        });
    }
}
