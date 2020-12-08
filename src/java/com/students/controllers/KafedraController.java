package com.students.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.students.dto.KafedraDTO;
import com.students.exceptions.NoSuchEntityException;
import com.students.service.KafedraService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class KafedraController {

    private KafedraService KafedraService;

    @Autowired
    public KafedraController(KafedraService KafedraService) {
        this.KafedraService = KafedraService;
    }

    @RequestMapping(value = "kafedras/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> cancelKafedra(@PathVariable long id) {
        KafedraService.cancel(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/kafedras", method = RequestMethod.POST)
    public KafedraDTO createKafedra(@RequestBody KafedraDTO KafedraDTO) {
        return KafedraService.saveKafedra(KafedraDTO);
    }

    @RequestMapping(value = "/kafedras", method = RequestMethod.GET)
    public List<KafedraDTO> getAllKafedras() {
        return KafedraService.findAll();
    }

    @RequestMapping(value = "/kafedras/{id}", method = RequestMethod.GET)
    public KafedraDTO getKafedra(@PathVariable long id) throws NoSuchEntityException {
        return KafedraService.findById(id);
    }

    @RequestMapping(value = "/kafedras", method = RequestMethod.PUT)
    public KafedraDTO updateKafedra(@RequestBody KafedraDTO KafedraDTO) throws NoSuchEntityException {
        return KafedraService.updateKafedra(KafedraDTO);
    }

}
