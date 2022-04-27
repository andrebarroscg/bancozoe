package com.example.bancozoe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.bancozoe.Model.UserModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;

public class registrousuario extends AppCompatActivity {

    private EditText btn_email_registro;
    private EditText btn_senha_registro;
    private EditText btn_senha_repetir;
    private FirebaseAuth mAuth;
    private ProgressBar progressbar_registro;
    private Button btn_registrar_usuario;
    private Button btn_login_registrar;
    private CheckBox check_senha_registro;
    private EditText nome;
    private EditText sobrenome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrousuario);


        btn_email_registro = findViewById(R.id.btn_email_registro);
        btn_senha_registro = findViewById(R.id.btn_senha_registro);
        btn_senha_repetir = findViewById(R.id.btn_senha_repetir);
        mAuth = FirebaseAuth.getInstance();
        progressbar_registro = findViewById(R.id.progressbar_registro);
        btn_registrar_usuario = findViewById(R.id.btn_registrar_usuario);
        btn_login_registrar = findViewById(R.id.btn_login_registrar);
        check_senha_registro = findViewById(R.id.check_senha_registro);
        nome=findViewById(R.id.btn_nome);
        sobrenome=findViewById(R.id.btn_sobrenome);


        check_senha_registro.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    btn_senha_registro.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    btn_senha_repetir.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    btn_senha_registro.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    btn_senha_repetir.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });

        btn_registrar_usuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                UserModel userModel = new UserModel();

                userModel.setEmail( btn_email_registro.getText().toString());
                userModel.setNome(nome.getText().toString());
                userModel.setSobrenome(sobrenome.getText().toString());
                userModel.setSenha(btn_senha_registro.getText().toString());
                String repertirsenha = btn_senha_repetir.getText().toString();

                if (!TextUtils.isEmpty(userModel.getNome()) && !TextUtils.isEmpty(userModel.getSobrenome())&&!TextUtils.isEmpty(userModel.getEmail()) && !TextUtils.isEmpty(userModel.getSenha()) && !TextUtils.isEmpty(repertirsenha)) {
                    if (userModel.getSenha().equals(repertirsenha)) {
                        progressbar_registro.setVisibility(View.VISIBLE);

                        mAuth.createUserWithEmailAndPassword(userModel.getEmail(), userModel.getSenha()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    userModel.setId(mAuth.getUid());
                                    userModel.salvar();
                                    inicial();

                                }else{
                                    String error;
                                    try{

                                        throw task.getException();

                                    }catch (FirebaseAuthWeakPasswordException e){
                                        error  = "Sua senha da ZOE BANK deve conter no mínimo 6 caracteres";
                                    }catch (FirebaseAuthInvalidCredentialsException e){
                                        error = "Email que você quer cadastrar na ZOE BANK é inválido";
                                    }catch (FirebaseAuthUserCollisionException e){
                                        error = "Usário já existe na ZOE BANK, cadastre outro!";
                                    }catch (Exception e){
                                        error = "Erro ao efetuar o cadastro na ZOE BANK";
                                        e.printStackTrace();

                                    }
                                    Toast.makeText(registrousuario.this,error, Toast.LENGTH_LONG).show();

                                }
                                progressbar_registro.setVisibility(View.INVISIBLE);
                            }
                        });
                    }else{
                        Toast.makeText(registrousuario.this, "A senha deve ser a mesma em ambos os campos!",Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(registrousuario.this,"Preencha todos os campos!",Toast.LENGTH_LONG).show();
                }
            }
        });

        btn_login_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private void inicial() {
        Intent paginainiciail = new Intent(getApplicationContext(), registrousuario.class);
        startActivity(paginainiciail);
        finish();
    }
}