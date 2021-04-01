package br.com.academy.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.academy.model.Usuario;

public interface UsuarioDao extends JpaRepository<Usuario, Long>{
    
    @Query("SELECT p FROM Usuario p WHERE p.email = :email")
    public Usuario findByEmail(String email);

}
