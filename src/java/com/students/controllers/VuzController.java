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

import com.students.dto.VuzDTO;
import com.students.exceptions.NoSuchEntityException;
import com.students.service.VuzService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class VuzController {

	private VuzService vuzService;

	@Autowired
	public VuzController(VuzService vuzService) {
		this.vuzService = vuzService;
	}

	@RequestMapping(value = "vuzs/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> cancelVuz(@PathVariable long id) {
		vuzService.cancel(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/vuzs", method = RequestMethod.POST)
	public VuzDTO createVuz(@RequestBody VuzDTO vuzDTO) {
		return vuzService.saveVuz(vuzDTO);
	}

	@RequestMapping(value = "/vuzs", method = RequestMethod.GET)
	public List<VuzDTO> getAllVuzs() {
		return vuzService.findAll();
	}

	@RequestMapping(value = "/vuzs/{id}", method = RequestMethod.GET)
	public VuzDTO getVuz(@PathVariable long id) throws NoSuchEntityException {
		return vuzService.findById(id);
	}

	@RequestMapping(value = "/vuzs", method = RequestMethod.PUT)
	public VuzDTO updateVuz(@RequestBody VuzDTO vuzDTO) throws NoSuchEntityException {
		return vuzService.updateVuz(vuzDTO);
	}

}
