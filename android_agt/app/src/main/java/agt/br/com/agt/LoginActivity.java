package agt.br.com.agt;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import agt.br.com.agt.dao.UsuarioDAO;


public class LoginActivity extends AppCompatActivity {
    private EditText usuario, senha;
    private Context context;
    UsuarioDAO dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        dao = new UsuarioDAO(this);

        usuario = (EditText) findViewById(R.id.login_usuario);
        senha = (EditText) findViewById(R.id.login_senha);

        Button novoUsuario = (Button) findViewById(R.id.botao_cadastrar);
        novoUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cadastrarUsuario = new Intent(LoginActivity.this, CadastrarUsuarioActivity.class);
                startActivity(cadastrarUsuario);
            }
        });

        Button entrar = (Button) findViewById(R.id.botao_entrar);
        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String login = usuario.getText().toString();
                String lSenha = senha.getText().toString();

                System.out.println("Login: "+login);
                System.out.println("Senha: "+lSenha);
                    if (login.equals("") || senha.equals("")){
                        Toast.makeText(LoginActivity.this,"Usuario ou Senha em branco",Toast.LENGTH_SHORT).show();
                    }else {
                        boolean resp = dao.validarLogin(login, lSenha);
                        if (resp == true) {
                            Intent entrar = new Intent(LoginActivity.this, MenuActivity.class);
                            startActivity(entrar);
                        } else {
                            Toast.makeText(LoginActivity.this, "Usuario ou senha Invalidos", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

        });


    }
}


