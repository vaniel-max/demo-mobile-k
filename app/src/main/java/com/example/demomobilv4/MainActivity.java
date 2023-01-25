package com.example.demomobilv4;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.demomobilv4.dto.RespuestaLogin;
import com.example.demomobilv4.dto.User;
import com.example.demomobilv4.service.NewtonService;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.text.DateFormat;
import java.util.Calendar;

public class
MainActivity extends AppCompatActivity {
    private Button buttonLog;
    private TextInputLayout user;
    private TextInputLayout password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user=(TextInputLayout)findViewById(R.id.tiUsuarioLO);
        password=(TextInputLayout)findViewById(R.id.tiPassLO);
        buttonLog = (Button) findViewById(R.id.buttonLogLO);
        buttonLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://desa03.konecta.com.py:8187/smppadmin/api/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                if (user.getEditText().getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Favor ingrese su usuario", Toast.LENGTH_LONG).show();

                }
                else if (password.getEditText().getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Favor ingrese su password", Toast.LENGTH_LONG).show();

                }
                else {
                    User userParams= new User();
                    //se setea lo que viene del input de pantalla
                    userParams.setUsername(user.getEditText().getText().toString());
                    userParams.setPassword(password.getEditText().getText().toString());
                    NewtonService service = retrofit.create(NewtonService.class);
                    Call<RespuestaLogin> response=service.login(userParams);
                    //llamada asincrona
                    response.enqueue(new Callback<RespuestaLogin>() {
                        @Override
                        public void onResponse(Call<RespuestaLogin> call, Response<RespuestaLogin> response) {
                            //camino feliz, status 200
                            RespuestaLogin contenidoRespuesta=response.body();
                            Toast.makeText(MainActivity.this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();
                            openNav();



                        }

                        @Override
                        public void onFailure(Call<RespuestaLogin> call, Throwable t) {
                            //camino fallido, erro 500, 400, etc
                            Toast.makeText(MainActivity.this, "Inicio de sesión fallido, favor verifique sus credenciales", Toast.LENGTH_LONG).show();

                        }
                    });
                }


            }
        });
    }

    public void  openNav(){
        Intent intent = new Intent(this, NavMain2Activity.class);
        startActivity(intent);
    }
}