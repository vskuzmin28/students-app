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

import com.students.dto.GruppaDTO;
import com.students.exceptions.NoSuchEntityException;
import com.students.service.GruppaService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class GruppaController {

    private GruppaService GruppaService;

    @Autowired
    public GruppaController(GruppaService GruppaService) {
        this.GruppaService = GruppaService;
    }

    @RequestMapping(value = "gruppas/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> cancelGruppa(@PathVariable long id) {
        GruppaService.cancel(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/gruppas", method = RequestMethod.POST)
    public GruppaDTO createGruppa(@RequestBody GruppaDTO GruppaDTO) {
        return GruppaService.saveGruppa(GruppaDTO);
    }

    @RequestMapping(value = "/gruppas", method = RequestMethod.GET)
    public List<GruppaDTO> getAllGruppas() {
        return GruppaService.findAll();
    }

    @RequestMapping(value = "/gruppas/{id}", method = RequestMethod.GET)
    public GruppaDTO getGruppa(@PathVariable long id) throws NoSuchEntityException {
        return GruppaService.findById(id);
    }

    @RequestMapping(value = "/gruppas", method = RequestMethod.PUT)
    public GruppaDTO updateGruppa(@RequestBody GruppaDTO GruppaDTO) throws NoSuchEntityException {
        return GruppaService.updateGruppa(GruppaDTO);
    }

}
