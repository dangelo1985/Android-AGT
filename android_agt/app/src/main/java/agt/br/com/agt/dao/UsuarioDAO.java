package agt.br.com.agt.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import agt.br.com.agt.model.Rotas;
import agt.br.com.agt.model.Usuarios;

public class UsuarioDAO extends SQLiteOpenHelper {
    private static final int VERSAO_BANCO = 1;
    private static final String BANCO = "bd_agt";

    public UsuarioDAO(Context context){
        super(context, BANCO, null,VERSAO_BANCO);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE usuarios (id_usuarios INTEGER PRIMARY KEY, " +
                "nome_usuarios TEXT NOT NULL, " +
                "email_usuarios TEXT NOT NULL, " +
                "senha_usuarios TEXT NOT NULL);");
        db.execSQL("CREATE TABLE pontos (id_pontos INTEGER PRIMARY KEY, " +
                "nome_pontos TEXT NOT NULL, " +
                "latitude DOUBLE NOT NULL, " +
                "longitude DOUBLE NOT NULL);");
        db.execSQL("INSERT INTO usuarios VALUES (1,'Administrador','admin', 'admin')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "";
        switch (oldVersion){
            case 1:
                  sql = "DROP TABLE usuarios;";
                db.execSQL(sql);

        }
    }
    public void insere(Usuarios usuario){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = pegaDados(usuario);
        db.insert("usuarios",null,dados);
    }
    private ContentValues pegaDados(Usuarios usuario){
        ContentValues dados = new ContentValues();
        dados.put("nome_usuarios", usuario.getNome_usuarios());
        dados.put("email_usuarios", usuario.getEmail_usuario());
        dados.put("senha_usuarios",usuario.getSenha_usuarios());
        return dados;
    }
    public List<Usuarios> buscaUsuarios(){
        String sql = "SELECT * FROM usuarios;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql, null);

        List<Usuarios> usuarios = new ArrayList<>();
    while (c.moveToNext()){
        Usuarios usuario = new Usuarios();
        usuario.setId_usuarios(c.getLong(c.getColumnIndex("id_usuarios")));
        usuario.setNome_usuarios(c.getString(c.getColumnIndex("nome_usuarios")));
        usuario.setEmail_usuario(c.getString(c.getColumnIndex("email_usuarios")));
        usuario.setSenha_usuarios(c.getString(c.getColumnIndex("senha_usuarios")));

        usuarios.add(usuario);
        }
        c.close();

        return usuarios;
    }
    public boolean validarLogin(String login, String senha){
        System.out.println("Resultado: "+login);
        System.out.println("Resultado: "+senha);

        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM usuarios WHERE email_usuarios=? AND senha_usuarios=? ;",new String[]{login,senha});
        boolean resultado;
        if(c.getCount()>0){
            resultado = true;
        }else{
            resultado = false;
        }

        return resultado;
    }
    public void insereRotas(Rotas rotas){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = pegaDadosRotas(rotas);
        db.insert("pontos",null,dados);
    }
    private ContentValues pegaDadosRotas(Rotas rota){
        ContentValues dados = new ContentValues();
        dados.put("nome_pontos", rota.getNome_rotas());
        dados.put("latitude", rota.getLatitude_rotas());
        dados.put("longitude",rota.getLongitude_rotas());
        return dados;
    }
    public List<Rotas> buscaRotas(){
        String sql = "SELECT * FROM pontos;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql, null);

        List<Rotas> rotas = new ArrayList<>();
        while (c.moveToNext()){
            Rotas rota = new Rotas();
            rota.setId_rotas(c.getLong(c.getColumnIndex("id_pontos")));
            rota.setNome_rotas(c.getString(c.getColumnIndex("nome_pontos")));
            rota.setLatitude_rotas(c.getString(c.getColumnIndex("latitude")));
            rota.setLongitude_rotas(c.getString(c.getColumnIndex("longitude")));

            rotas.add(rota);
        }
        c.close();

        return rotas;
    }



}
