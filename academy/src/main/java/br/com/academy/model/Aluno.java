package br.com.academy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.academy.enums.Curso;
import br.com.academy.enums.Status;

@Entity
public class Aluno {
    
    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "curso")
    private Curso curso;

    @Column(name = "matricula")
    private String matricula;

    @Column(name = "status")
    private Status status;

    @Column(name = "turno")
    private String turno;


    // Setters
    public void setId(Integer id) {
        this.id = id;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Status getStatus() {
        return status;
    }
    public void setTurno(String turno) {
        this.turno = turno;
    }
    public Curso getCurso() {
        return curso;
    }

    // Getters
    public Integer getId() {
        return id;
    }
    public String getMatricula() {
        return matricula;
    }
    public String getNome() {
        return nome;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public String getTurno() {
        return turno;
    }
    public void setCurso(Curso curso) {
        this.curso = curso;
    }

}
