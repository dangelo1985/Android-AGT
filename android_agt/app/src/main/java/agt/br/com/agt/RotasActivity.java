package agt.br.com.agt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import agt.br.com.agt.adapter.RotasAdapter;
import agt.br.com.agt.adapter.UsuariosAdapter;
import agt.br.com.agt.dao.UsuarioDAO;
import agt.br.com.agt.model.Rotas;
import agt.br.com.agt.model.Usuarios;

public class RotasActivity extends AppCompatActivity {
    private ListView listaRotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotas);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        listaRotas = (ListView) findViewById(R.id.lista_usuarios);

    }
    private void carregaLista(){
        UsuarioDAO dao = new UsuarioDAO(this);
        List<Rotas> rotas = dao.buscaRotas();
        dao.close();

        RotasAdapter adapter = new RotasAdapter(this,rotas);
        listaRotas.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregaLista();
    }
}
