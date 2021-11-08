/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.teclab.prueba.controller;

import ar.edu.teclab.prueba.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;
    
    @GetMapping("/{ticketId}/comments")
    public ResponseEntity<Object> findCommentsByTicketId(@PathVariable("ticketId") Long ticketId) {
        return ticketService.findComments(ticketId);
    }

    @PutMapping("/{ticketId}")
        public ResponseEntity<Object> makeCommentInTicket(@PathVariable("ticketId") Long ticketId, @RequestBody String comentario) {
        return ticketService.makeCommentInTicket(ticketId, comentario);
    }
}
