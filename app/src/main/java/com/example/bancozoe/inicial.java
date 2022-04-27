package com.example.bancozoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class inicial extends AppCompatActivity {


   private FirebaseAuth mAuth;
   ImageButton acessobotaopix;
   ImageButton acessobotaobigpix;
   ImageButton acessobotaobigsaf;
   ImageButton acessobotaoqrcode;
   ImageButton acessobotaoboleto;
   ImageButton acessobotaoseguro;
   ImageButton acessobotaoiptu;
   ImageButton acessobotaoipva;
   ImageButton acessobotaoescolafaculdade;
   ImageButton acessobotaomaterialescolar;
   ImageButton acessobotaoseguropequeno;
   ImageButton acessobotaoviagem;
   Button acessobotaosair;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicial);
        Toast.makeText(getApplicationContext(),"Bem vindo a ZOE BANK!", Toast.LENGTH_LONG).show();

       acessobotaopix=findViewById(R.id.botaopixiniciar);
        acessobotaopix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent paginapixincial = new Intent(getApplicationContext(),inicialpix.class);
                startActivity(paginapixincial);
            }
        });

        acessobotaobigpix=findViewById(R.id.botaobigpixiniciar);
        acessobotaobigpix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent paginabigpixiniciar = new Intent(getApplicationContext(),paginabigpix.class);
                startActivity(paginabigpixiniciar);
            }
        });

        acessobotaobigsaf=findViewById(R.id.botaobigsafiniciar);
        acessobotaobigsaf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent paginabigsafeiniciar =new Intent(getApplicationContext(),paginabigsaf.class);
                startActivity(paginabigsafeiniciar);
            }
        });

        acessobotaoqrcode=findViewById(R.id.botaoqrcodeiniciar);
        acessobotaoqrcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent paginaqrcodeiniciar = new Intent(getApplicationContext(),paginaqrcode.class);
                startActivity(paginaqrcodeiniciar);
            }
        });

        acessobotaoboleto=findViewById(R.id.botaoboletoiniciar);
        acessobotaoboleto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent paginaboletoiniciar = new Intent(getApplicationContext(),paginaboleto.class);
                startActivity(paginaboletoiniciar);
            }
        });

        acessobotaoseguro=findViewById(R.id.botaoseguroiniciar);
        acessobotaoseguro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent paginaseguroiniciar = new Intent(getApplicationContext(),paginaseguro.class);
                startActivity(paginaseguroiniciar);
            }
        });

        acessobotaoiptu=findViewById(R.id.botaoinciariptu);
        acessobotaoiptu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent paginaiptuiniciar = new Intent(getApplicationContext(),paginaiptu.class);
                startActivity(paginaiptuiniciar);

            }
        });

        acessobotaoipva=findViewById(R.id.botaoinciaripva);
        acessobotaoipva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent paginaipvainiciar = new Intent(getApplicationContext(),paginaipva.class);
                startActivity(paginaipvainiciar);
            }
        });

        acessobotaoescolafaculdade=findViewById(R.id.botaoinciarescolafaculdade);
        acessobotaoescolafaculdade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent paginaescolafaculdadeiniciar = new Intent(getApplicationContext(),paginaescolafaculdade.class);
                startActivity(paginaescolafaculdadeiniciar);
            }
        });

        acessobotaomaterialescolar=findViewById(R.id.botaoinciarmaterialescolar);
        acessobotaomaterialescolar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent paginamaterialescolariniciar=new Intent(getApplicationContext(),paginamaterialescolar.class);
                startActivity(paginamaterialescolariniciar);
            }
        });

        acessobotaoseguropequeno=findViewById(R.id.botaoinciarseguropix);
        acessobotaoseguropequeno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent paginasegurpequenoiniciar= new Intent(getApplicationContext(),paginaseguropequeno.class);
                startActivity(paginasegurpequenoiniciar);
            }
        });

        acessobotaoviagem=findViewById(R.id.botaoinciarviagem);
        acessobotaoviagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent paginaviageminiciar=new Intent(getApplicationContext(),paginaviagem.class);
                startActivity(paginaviageminiciar);
            }
        });


        mAuth= FirebaseAuth.getInstance();
        acessobotaosair=findViewById(R.id.btn_sair);
        acessobotaosair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();

                Intent paginasair =new Intent(getApplicationContext(),MainActivity.class);
                startActivity(paginasair);
                finish();

            }
        });


    }

}