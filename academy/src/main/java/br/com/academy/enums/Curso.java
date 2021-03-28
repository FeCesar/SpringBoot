package br.com.academy.enums;

public enum Curso {
    
    ADMINISTRACAO("Administração"),
    INFORMATICA("Informática"),
    CONTABILIDADE("Contabilidade"),
    PROGRAMACAO("Programação"),
    ENFERMAGEM("Enfermagem");

    // Atributos
    private String curso;
    
    // Construct
    private Curso(String curso){
        this.curso = curso;
    }
    

}
