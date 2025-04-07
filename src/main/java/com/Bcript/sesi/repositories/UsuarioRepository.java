package com.Bcript.sesi.repositories;

import com.Bcript.sesi.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>  { // aqui passamos a nossa entidade e o tipo do id que estamos usando

    Usuario findByEmail(String email); // criamos esse metodo para buscar o email do ususario
}
