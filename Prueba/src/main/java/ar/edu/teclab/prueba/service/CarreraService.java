/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.teclab.prueba.service;

import ar.edu.teclab.prueba.dto.CarreraDTO;
import ar.edu.teclab.prueba.entity.Carrera;
import ar.edu.teclab.prueba.repository.CarreraRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CarreraService {

    @Autowired
    private CarreraRepository carreraRepository;

    public ResponseEntity<Object> findAll() {
        List<Carrera> list = carreraRepository.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    public ResponseEntity<Object> findById(int id) {
        Carrera c = carreraRepository.findOne(id);
        if (c == null) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    /*public ResponseEntity<Object> create(Carrera carrera) {
        return ResponseEntity.status(HttpStatus.CREATED).body(carreraRepository.save(carrera));
    }
     */
    public ResponseEntity<Object> create(CarreraDTO carreraDTO) {
        Carrera carrera = new Carrera();
        carrera.setCantMaterias(carreraDTO.getCantMaterias());
        carrera.setDescripcion(carreraDTO.getDescripcion());
        carrera.setFacultad(carreraDTO.getFacultad());
        carrera.setUniversidad(carreraDTO.getUniversidad());
        carrera.setPlanEstudio(carreraDTO.getPlanEstudio());
        carreraRepository.saveAndFlush(carrera);
        return new ResponseEntity("Carrera registrada exitosamente", HttpStatus.CREATED);
    }

    public ResponseEntity<Object> update(CarreraDTO carreraDTO, int id) {
        Carrera carrera = carreraRepository.findOne(id);
        if (carrera != null) {
            carrera.setCantMaterias(carreraDTO.getCantMaterias());
            carrera.setDescripcion(carreraDTO.getDescripcion());
            carrera.setFacultad(carreraDTO.getFacultad());
            carrera.setUniversidad(carreraDTO.getUniversidad());
            carrera.setPlanEstudio(carreraDTO.getPlanEstudio());
            carreraRepository.saveAndFlush(carrera);
            return new ResponseEntity("Datos de carrera modificados con exito", HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Eliminacion fisica!!
    public ResponseEntity<Object> delete(int id) {
        Carrera carrera = carreraRepository.findOne(id);
        if (carrera != null) {
            carreraRepository.delete(id);
        } else {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity("Datos de carrera eliminados con exito", HttpStatus.OK);
    }
}
