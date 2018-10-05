package agt.br.com.agt.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import agt.br.com.agt.R;
import agt.br.com.agt.model.Rotas;

public class RotasAdapter extends BaseAdapter {
    private final List<Rotas> rotas;
    private final Context context;

    public RotasAdapter(Context context, List<Rotas> rotas){
        this.context = context;
        this.rotas = rotas;
    }

    @Override
    public int getCount() {
        return rotas.size();
    }

    @Override
    public Object getItem(int position) {
        return rotas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return rotas.get(position).getId_rotas();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Rotas rota = rotas.get(position);

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = convertView;
        if(view == null){
            view = inflater.inflate(R.layout.list_item,parent,false);
        }
        TextView campoNome = (TextView) view.findViewById(R.id.item_nome);
        campoNome.setText(rota.getNome_rotas());

        TextView campoEmail = (TextView) view.findViewById(R.id.item_email);
        campoEmail.setText(rota.getLongitude_rotas());
        return view;
    }
}
