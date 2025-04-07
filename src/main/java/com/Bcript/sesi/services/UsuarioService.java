package com.Bcript.sesi.services;

import com.Bcript.sesi.dto.UsuarioDTO;
import com.Bcript.sesi.entities.Usuario;
import com.Bcript.sesi.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    PasswordEncoder config; // pegando a classe encarregada de encripitografmos

    public UsuarioDTO salvarUsuario(UsuarioDTO dto){ // Metodo para criar-mos um novo usuario
        Usuario usuario = new Usuario();

        usuario.setEmail(dto.getEmail());
        usuario.setSenha(config.encode(dto.getSenha())); //Dessa forma ja estamos encripitografmos a nossa senha

        usuario = usuarioRepository.save(usuario);

        return new UsuarioDTO(usuario);
    }

    public boolean login(UsuarioDTO dto){//Metodo para verificar se o ussario esta logado
        Usuario usuario = usuarioRepository.findByEmail(dto.getEmail());//verifica se o email criado existe
        if(usuario == null){
            return false;// se o email do usuario nao existir retorna falso
        }
        return config.matches(dto.getSenha(), usuario.getSenha());
    }
}
