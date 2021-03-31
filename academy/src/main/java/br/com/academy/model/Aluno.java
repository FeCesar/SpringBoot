package br.com.academy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import br.com.academy.enums.Curso;
import br.com.academy.enums.Status;
import br.com.academy.enums.Turno;

@Entity
public class Aluno {
    
    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "curso")
    @Enumerated(EnumType.STRING)
    private Curso curso;

    @Column(name = "matricula")
    private String matricula;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "turno")
    @Enumerated(EnumType.STRING)
    private Turno turno;


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
    public void setStatus(Status status) {
        this.status = status;
    }
    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    public void setTurno(Turno turno) {
        this.turno = turno;
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
    public Turno getTurno() {
        return turno;
    }
    public Status getStatus() {
        return status;
    }
    public Curso getCurso() {
        return curso;
    }


}
