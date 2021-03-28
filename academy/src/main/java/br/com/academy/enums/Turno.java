package br.com.academy.enums;

public enum Turno {
    
    MANHA("Manhã"),
    TARDE("Tarde"),
    NOITE("Noite");

    private String turno;

    // Construct
    private Turno(String turno){
        this.turno = turno;
    }

    public String getTurno() {
        return turno;
    }



}
