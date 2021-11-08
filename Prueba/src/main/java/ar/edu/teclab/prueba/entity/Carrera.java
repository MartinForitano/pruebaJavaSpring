/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.teclab.prueba.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "carrera")
public class Carrera implements Serializable {
 
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "idcarrera")
    private Integer id;
    @Column(name = "carrcantmaterias")
    private int cantMaterias;
    @Column(name = "carrplandeestudios")
    private int planEstudio;
    @Column(name = "carrdescripcion")
    private String descripcion;
    @Column(name = "carrnombrefacultad")
    private String facultad;
    @Column(name = "carrnombreuniversidad")
    private String universidad;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Carrera(int id, int cantMaterias, int planEstudio, String descripcion, String facultad, String universidad) {
        this.id = id;
        this.cantMaterias = cantMaterias;
        this.planEstudio = planEstudio;
        this.descripcion = descripcion;
        this.facultad = facultad;
        this.universidad = universidad;
    }

    public Carrera() {
    }   
    
}
