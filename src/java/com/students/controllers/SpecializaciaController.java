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

import com.students.dto.SpecializaciaDTO;
import com.students.exceptions.NoSuchEntityException;
import com.students.service.SpecializaciaService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class SpecializaciaController {

    private SpecializaciaService SpecializaciaService;

    @Autowired
    public SpecializaciaController(SpecializaciaService SpecializaciaService) {
        this.SpecializaciaService = SpecializaciaService;
    }

    @RequestMapping(value = "specializacias/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> cancelSpecializacia(@PathVariable long id) {
        SpecializaciaService.cancel(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/specializacias", method = RequestMethod.POST)
    public SpecializaciaDTO createSpecializacia(@RequestBody SpecializaciaDTO SpecializaciaDTO) {
        return SpecializaciaService.saveSpecializacia(SpecializaciaDTO);
    }

    @RequestMapping(value = "/specializacias", method = RequestMethod.GET)
    public List<SpecializaciaDTO> getAllSpecializacias() {
        return SpecializaciaService.findAll();
    }

    @RequestMapping(value = "/specializacias/{id}", method = RequestMethod.GET)
    public SpecializaciaDTO getSpecializacia(@PathVariable long id) throws NoSuchEntityException {
        return SpecializaciaService.findById(id);
    }

    @RequestMapping(value = "/specializacias", method = RequestMethod.PUT)
    public SpecializaciaDTO updateSpecializacia(@RequestBody SpecializaciaDTO SpecializaciaDTO) throws NoSuchEntityException {
        return SpecializaciaService.updateSpecializacia(SpecializaciaDTO);
    }

}
