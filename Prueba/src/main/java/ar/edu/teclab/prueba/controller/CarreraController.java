/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.teclab.prueba.controller;

import ar.edu.teclab.prueba.dto.CarreraDTO;
import ar.edu.teclab.prueba.entity.Carrera;
import ar.edu.teclab.prueba.service.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carreras")
public class CarreraController {

    @Autowired
    private CarreraService carreraService;

    @GetMapping
    public ResponseEntity<Object> findAllCarreras() {
        return carreraService.findAll();
    }

    @GetMapping("/{carreraId}")
    public ResponseEntity<Object> findCarrerasById(@PathVariable("carreraId") int carreraId) {
        return carreraService.findById(carreraId);
    }

    @PostMapping
    public ResponseEntity<Object> createCarrera(@RequestBody CarreraDTO carrera) {
        return carreraService.create(carrera);
    }

    @PutMapping("/{carreraId}")
    public ResponseEntity<Object> update(@RequestBody CarreraDTO carrera, @PathVariable int carreraId) {
        return carreraService.update(carrera, carreraId);
    }

    
    // TODO: Consultar sobre metodo a utilizar: Delete o put?
    @DeleteMapping("/{carreraId}")
    public ResponseEntity<Object> delete(@PathVariable int carreraId) {
        return carreraService.delete(carreraId);
    }
}
