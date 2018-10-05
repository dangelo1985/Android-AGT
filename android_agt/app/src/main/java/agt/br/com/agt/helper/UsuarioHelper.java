package agt.br.com.agt.helper;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.EditText;


import agt.br.com.agt.CadastrarUsuarioActivity;
import agt.br.com.agt.R;
import agt.br.com.agt.dao.UsuarioDAO;
import agt.br.com.agt.model.Usuarios;

public class UsuarioHelper extends Activity{
    private final EditText campoNome;
    private final EditText campoEmail;
    private final EditText campoSenha;
    private final EditText campoTesteSenha;


    String nome;
    String email;
    String senha;
    String testeSenha;
    Mensagem mensagem = new Mensagem();

    private Usuarios usuario;
    private boolean res;


    public UsuarioHelper(CadastrarUsuarioActivity activity){
        campoNome = (EditText) activity.findViewById(R.id.usuario_nome);
        campoEmail = (EditText) activity.findViewById(R.id.usuario_email);
        campoSenha = (EditText) activity.findViewById(R.id.usuario_senha);
        campoTesteSenha = (EditText) activity.findViewById(R.id.usuario_confirmaSenha);
        usuario = new Usuarios();

    }
    public boolean validaCampos(Activity activity){

        res = false;

         nome = campoNome.getText().toString();
         email = campoEmail.getText().toString();
         senha = campoSenha.getText().toString();
         testeSenha = campoTesteSenha.getText().toString();

        if(res = isCampoVazio(nome)){
                mensagem.Alert(activity,"Nome não pode ser em branco!");
              campoNome.requestFocus();
        }else if(res = !isEmailValido(email)){
            mensagem.Alert(activity,"Email em Branco ou Inválido!");
            campoEmail.requestFocus();
        }else if (res = isCampoVazio(senha)){
            mensagem.Alert(activity,"Senha não pode ser em branco!");
            campoSenha.requestFocus();
        }else if (res = testaSenha(senha,testeSenha)== false){
            System.out.println(senha + "-" + testeSenha);
            mensagem.Alert(activity,"Senhas Incompativeis!");
            campoSenha.requestFocus();
        }
       return res;

    }

    public Usuarios pegaUsuario(){
        validaCampos(this);
                usuario.setNome_usuarios(nome);
                usuario.setEmail_usuario(email);
                usuario.setSenha_usuarios(senha);

                return usuario;

    }
    private boolean isCampoVazio(String valor){
        boolean resultado = (TextUtils.isEmpty(valor) || valor.trim().isEmpty());
        return resultado;
    }
    private boolean isEmailValido(String email){
        boolean resultado = (!isCampoVazio(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
        return resultado;
    }
    private boolean testaSenha(String senha, String testeSenha){
        boolean resultado = (senha.equals(testeSenha));
        return resultado;

    }
    public void preencherFormulario(Usuarios usuario){
        campoNome.setText(usuario.getNome_usuarios());
        campoEmail.setText(usuario.getEmail_usuario());
        campoSenha.setText(usuario.getSenha_usuarios());
        this.usuario = usuario;
    }


}
