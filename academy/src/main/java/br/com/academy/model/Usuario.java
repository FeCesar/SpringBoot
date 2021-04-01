package br.com.academy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {
    
    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "email")
    private String email;

    @Column(name = "user")
    private String user;

    @Column(name = "senha")
    private String senha;



    // Getters
    public String getEmail() {
        return email;
    }
    public long getId() {
        return id;
    }
    public String getSenha() {
        return senha;
    }
    public String getUser() {
        return user;
    }

    // Setters
    public void setEmail(String email) {
        this.email = email;
    }
    public void setId(long id) {
        this.id = id;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public void setUser(String user) {
        this.user = user;
    }
}
