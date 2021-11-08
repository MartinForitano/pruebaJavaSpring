/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.teclab.prueba.service;

import java.util.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author marti
 */
@Service
public class TicketService {

    private static final String API_URL = "https://teclab1593636133.zendesk.com/api/v2/tickets/";

    @Value("${user.username}")
    private String username;

    @Value("${user.password}")
    private String password;

    public ResponseEntity<Object> findComments(Long ticketId) {
        String pathComments = API_URL + ticketId + "/comments";
        String credentials = username + ":" + password;
        String credentialsEncoded = Base64.getEncoder().encodeToString(credentials.getBytes());

        //https://www.baeldung.com/how-to-use-resttemplate-with-basic-authentication-in-spring
        // create headers
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + credentialsEncoded);

        // create request
        HttpEntity request = new HttpEntity(headers);
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> exchange = template.exchange(pathComments, HttpMethod.GET, request, String.class);
        return new ResponseEntity<>(exchange.getBody(), HttpStatus.OK);
    }

    public ResponseEntity<Object> makeCommentInTicket(Long ticketId, String comment) {
        String pathComments = API_URL + ticketId;
        String credentials = username + ":" + password;
        String credentialsEncoded = Base64.getEncoder().encodeToString(credentials.getBytes());
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + credentialsEncoded);
        HttpEntity request = new HttpEntity<>(comment, headers);
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> exchange = template.exchange(pathComments, HttpMethod.PUT, request, String.class);
        return new ResponseEntity<>(exchange.getBody(), HttpStatus.OK);
    }
}
