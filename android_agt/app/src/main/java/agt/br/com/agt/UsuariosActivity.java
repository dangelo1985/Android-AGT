package agt.br.com.agt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import agt.br.com.agt.adapter.UsuariosAdapter;
import agt.br.com.agt.dao.UsuarioDAO;
import agt.br.com.agt.model.Usuarios;

public class UsuariosActivity extends AppCompatActivity {
    private ListView listaUsuarios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuarios);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        listaUsuarios = (ListView) findViewById(R.id.lista_usuarios);

    }
    private void carregaLista(){
        UsuarioDAO dao = new UsuarioDAO(this);
        List<Usuarios> usuarios = dao.buscaUsuarios();
        dao.close();

        UsuariosAdapter adapter = new UsuariosAdapter(this,usuarios);
        listaUsuarios.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregaLista();
    }
}
