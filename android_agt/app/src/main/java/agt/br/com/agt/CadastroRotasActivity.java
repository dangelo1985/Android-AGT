package agt.br.com.agt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import agt.br.com.agt.dao.UsuarioDAO;
import agt.br.com.agt.helper.RotasHelper;
import agt.br.com.agt.helper.UsuarioHelper;
import agt.br.com.agt.model.Rotas;
import agt.br.com.agt.model.Usuarios;

public class CadastroRotasActivity extends AppCompatActivity {

    private RotasHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_rotas);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        helper = new RotasHelper(this);

        Button salvar = (Button) findViewById(R.id.rotas_salvar);

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Rotas rotas = helper.pegaRotas();

                    UsuarioDAO usuarioDAO = new UsuarioDAO(CadastroRotasActivity.this);
                    usuarioDAO.insereRotas(rotas);
                    usuarioDAO.close();

                    Toast.makeText(CadastroRotasActivity.this, "Rota Salvo", Toast.LENGTH_SHORT).show();
                    finish();
                }


        });
    }
}
