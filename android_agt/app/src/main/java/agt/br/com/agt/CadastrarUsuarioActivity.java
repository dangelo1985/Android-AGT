package agt.br.com.agt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import agt.br.com.agt.dao.UsuarioDAO;
import agt.br.com.agt.helper.UsuarioHelper;
import agt.br.com.agt.model.Usuarios;

public class CadastrarUsuarioActivity extends AppCompatActivity {

    private UsuarioHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_usuario);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        helper = new UsuarioHelper(this);

        Button salvar = (Button) findViewById(R.id.usuario_salvar);

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if (helper.validaCampos(CadastrarUsuarioActivity.this) == false) {

                    Usuarios usuario = helper.pegaUsuario();

                    UsuarioDAO usuarioDAO = new UsuarioDAO(CadastrarUsuarioActivity.this);
                    usuarioDAO.insere(usuario);
                    usuarioDAO.close();

                    Toast.makeText(CadastrarUsuarioActivity.this, "Usuario Salvo", Toast.LENGTH_SHORT).show();
                    finish();
                }

            }
        });

    }
}
