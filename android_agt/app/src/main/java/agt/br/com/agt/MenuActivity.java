package agt.br.com.agt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import agt.br.com.agt.model.Rotas;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        Button entrarUsuarios = (Button) findViewById(R.id.menu_usuarios);
        entrarUsuarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent entrar = new Intent(MenuActivity.this, UsuariosActivity.class);
                startActivity(entrar);
            }
        });

        Button entrarRotas = (Button) findViewById(R.id.menu_pontos);
        entrarRotas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent entrar = new Intent(MenuActivity.this, CadastroRotasActivity.class);
                startActivity(entrar);
            }
        });
        Button entrarPontos = (Button) findViewById(R.id.menu_rotas);
        entrarPontos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent entrar = new Intent(MenuActivity.this, RotasActivity.class);
                startActivity(entrar);
            }
        });
    }
}
