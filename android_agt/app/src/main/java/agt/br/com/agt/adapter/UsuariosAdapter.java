package agt.br.com.agt.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;
import java.util.ListIterator;

import agt.br.com.agt.R;
import agt.br.com.agt.model.Usuarios;

public class UsuariosAdapter extends BaseAdapter {
    private final List<Usuarios> usuarios;
    private Context context;

    public UsuariosAdapter(Context context, List<Usuarios> usuarios){
        this.context = context;
        this.usuarios = usuarios;
    }

    @Override
    public int getCount() {
        return usuarios.size();
    }

    @Override
    public Object getItem(int position) {
        return usuarios.get(position);
    }

    @Override
    public long getItemId(int position) {
        return usuarios.get(position).getId_usuarios();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Usuarios usuario = usuarios.get(position);

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = convertView;
        if(view == null){
            view = inflater.inflate(R.layout.list_item,parent,false);
        }
        TextView campoNome = (TextView) view.findViewById(R.id.item_nome);
        campoNome.setText(usuario.getNome_usuarios());

        TextView campoEmail = (TextView) view.findViewById(R.id.item_email);
        campoEmail.setText(usuario.getEmail_usuario());
        return view;
    }
}
