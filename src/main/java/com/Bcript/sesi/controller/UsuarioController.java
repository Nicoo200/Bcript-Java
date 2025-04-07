package com.Bcript.sesi.controller;

import com.Bcript.sesi.dto.UsuarioDTO;
import com.Bcript.sesi.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping(value = "save")
    public ResponseEntity<UsuarioDTO> cadastrar(@RequestBody UsuarioDTO dto){
        dto = usuarioService.salvarUsuario(dto);
        return ResponseEntity.ok(dto);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<?> logar(@RequestBody UsuarioDTO dto){
        boolean test = usuarioService.login(dto);
        if(test){
            return ResponseEntity.ok("Sucesso !");
        }
        return ResponseEntity.status(401).body("Senha ou Login incorreto !");
    }
}
