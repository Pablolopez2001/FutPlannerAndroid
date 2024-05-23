package com.futplanner.futplannerandroid;

public class PartidoModel {
    private String fecha;
    private String hora;
    private String lugar;
    private String equipoVisitante;

    public PartidoModel(String fecha, String hora, String lugar, String equipoVisitante) {
        this.fecha = fecha;
        this.hora = hora;
        this.lugar = lugar;
        this.equipoVisitante = equipoVisitante;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(String equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }
}

