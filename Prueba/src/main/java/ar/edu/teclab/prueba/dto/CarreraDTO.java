/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.teclab.prueba.dto;

import java.io.Serializable;




public class CarreraDTO {
 
    private Integer id;
    private int cantMaterias;
    private int planEstudio;
    private String descripcion;
    private String facultad;
    private String universidad;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantMaterias() {
        return cantMaterias;
    }

    public void setCantMaterias(int cantMaterias) {
        this.cantMaterias = cantMaterias;
    }

    public int getPlanEstudio() {
        return planEstudio;
    }

    public void setPlanEstudio(int planEstudio) {
        this.planEstudio = planEstudio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    public CarreraDTO(int id, int cantMaterias, int planEstudio, String descripcion, String facultad, String universidad) {
        this.id = id;
        this.cantMaterias = cantMaterias;
        this.planEstudio = planEstudio;
        this.descripcion = descripcion;
        this.facultad = facultad;
        this.universidad = universidad;
    }

    public CarreraDTO() {
    }   
    
}
