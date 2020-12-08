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

import com.students.dto.FacultetDTO;
import com.students.exceptions.NoSuchEntityException;
import com.students.service.FacultetService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class FacultetController {

    private FacultetService FacultetService;

    @Autowired
    public FacultetController(FacultetService FacultetService) {
        this.FacultetService = FacultetService;
    }

    @RequestMapping(value = "facultets/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> cancelFacultet(@PathVariable long id) {
        FacultetService.cancel(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/facultets", method = RequestMethod.POST)
    public FacultetDTO createFacultet(@RequestBody FacultetDTO FacultetDTO) {
        return FacultetService.saveFacultet(FacultetDTO);
    }

    @RequestMapping(value = "/facultets", method = RequestMethod.GET)
    public List<FacultetDTO> getAllFacultets() {
        return FacultetService.findAll();
    }

    @RequestMapping(value = "/facultets/{id}", method = RequestMethod.GET)
    public FacultetDTO getFacultet(@PathVariable long id) throws NoSuchEntityException {
        return FacultetService.findById(id);
    }

    @RequestMapping(value = "/facultets", method = RequestMethod.PUT)
    public FacultetDTO updateFacultet(@RequestBody FacultetDTO FacultetDTO) throws NoSuchEntityException {
        return FacultetService.updateFacultet(FacultetDTO);
    }

}
