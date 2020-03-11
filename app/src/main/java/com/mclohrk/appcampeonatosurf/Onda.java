package com.mclohrk.appcampeonatosurf;

public class Onda {
    private  Integer id;
    private Surfista surfista;
    private Bateria bateria;


    public Onda() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Surfista getSurfista() {
        return surfista;
    }

    public void setSurfista(Surfista surfista) {
        this.surfista = surfista;
    }

    public Bateria getBateria() {
        return bateria;
    }

    public void setBateria(Bateria bateria) {
        this.bateria = bateria;
    }
}
