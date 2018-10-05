package agt.br.com.agt.helper;

import android.widget.EditText;

import agt.br.com.agt.CadastroRotasActivity;
import agt.br.com.agt.R;
import agt.br.com.agt.model.Rotas;

public class RotasHelper {
    private final EditText campoNomeRotas;
    private final EditText campoLatitude;
    private final EditText campolongitude;
    private Rotas rota;

    public RotasHelper(CadastroRotasActivity activity){
        campoNomeRotas = (EditText) activity.findViewById(R.id.rotas_nome);
        campoLatitude = (EditText) activity.findViewById(R.id.rotas_latitude);
        campolongitude = (EditText) activity.findViewById(R.id.rotas_longitude);
        rota = new Rotas();
    }
    public Rotas pegaRotas(){
        rota.setNome_rotas(campoNomeRotas.getText().toString());
        rota.setLatitude_rotas(campoLatitude.getText().toString());
        rota.setLongitude_rotas(campolongitude.getText().toString());
        return rota;
    }
    public void preencherRotas(Rotas rota){
        campoNomeRotas.setText(rota.getNome_rotas());
        campoLatitude.setText(rota.getLatitude_rotas());
        campolongitude.setText(rota.getLongitude_rotas());
        this.rota = rota;
    }
}
