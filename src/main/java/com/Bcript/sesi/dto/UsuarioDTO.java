package com.Bcript.sesi.dto;

import com.Bcript.sesi.entities.Usuario;

public class UsuarioDTO {

    private Long id;
    private String email;
    private String senha;

    public UsuarioDTO() {
    }

    public UsuarioDTO(Long id, String senha, String email) {
        this.id = id;
        this.email = email;
        this.senha = senha;

    }

    public UsuarioDTO(Usuario entity) { //Criando construtor da entidade
        id = entity.getId();
        email = entity.getEmail();
        senha = entity.getSenha();
    }

    //GET
    public String getSenha() {
        return senha;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    //SET
    public void setId(Long id) {
        this.id = id;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
