package agt.br.com.agt.model;

import java.io.Serializable;
/*
*
*/

public class Usuarios implements Serializable{
    private Long id_usuarios;
    private String nome_usuarios;
    private String email_usuario;
    private String senha_usuarios;

    public Long getId_usuarios() {
        return id_usuarios;
    }

    public void setId_usuarios(Long id_usuarios) {
        this.id_usuarios = id_usuarios;
    }

    public String getNome_usuarios() {
        return nome_usuarios;
    }

    public void setNome_usuarios(String nome_usuarios) {
        this.nome_usuarios = nome_usuarios;
    }

    public String getEmail_usuario() {
        return email_usuario;
    }

    public void setEmail_usuario(String email_usuario) {
        this.email_usuario = email_usuario;
    }

    public String getSenha_usuarios() {
        return senha_usuarios;
    }

    public void setSenha_usuarios(String senha_usuarios) {
        this.senha_usuarios = senha_usuarios;
    }

    @Override
    public String toString() {
        return getNome_usuarios();
    }
}
