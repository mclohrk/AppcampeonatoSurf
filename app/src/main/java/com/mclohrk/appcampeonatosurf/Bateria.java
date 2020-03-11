package com.mclohrk.appcampeonatosurf;

public class Bateria {
    private  Integer id;
    private String surfista;
    private String nome;

    public Bateria() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSurfista() {
        return surfista;
    }

    public void setSurfista(String surfista) {
        this.surfista = surfista;
    }

    @Override
    public String toString(){
        return nome;
    }
}
