package br.com.academy.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.academy.model.Usuario;

public interface UsuarioDao extends JpaRepository<Usuario, Long>{
    
    @Query("SELECT p FROM Usuario p WHERE p.email = :email")
    public Usuario findByEmail(String email);

    @Query("SELECT p FROM Usuario p WHERE p.user = :user AND p.senha = :senha")
    public Usuario findByLoginSenha(String user, String senha);

}
