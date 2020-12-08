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

import com.students.dto.StudentDTO;
import com.students.exceptions.NoSuchEntityException;
import com.students.service.StudentService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {

	private StudentService studentService;

	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@RequestMapping(value = "students/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> cancelStudent(@PathVariable long id) {
		studentService.cancel(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/students", method = RequestMethod.POST)
	public StudentDTO createStudent(@RequestBody StudentDTO studentDTO) {
		return studentService.saveStudent(studentDTO);
	}

	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public List<StudentDTO> getAllStudents() {
		return studentService.findAll();
	}

	@RequestMapping(value = "/students/{vuzId}/{facultetId}/{kafedraId}/{gruppaId}/{specializaciaId}", method = RequestMethod.GET)
	public List<StudentDTO> getStudentsFiltered(@PathVariable long vuzId, @PathVariable long facultetId,
			@PathVariable long kafedraId, @PathVariable long gruppaId, @PathVariable long specializaciaId)
			throws NoSuchEntityException {
		return studentService.findAllFiltered(vuzId, facultetId, kafedraId, gruppaId, specializaciaId);
	}

	@RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
	public StudentDTO getStudent(@PathVariable long id) throws NoSuchEntityException {
		return studentService.findById(id);
	}

	@RequestMapping(value = "/students", method = RequestMethod.PUT)
	public StudentDTO updateStudent(@RequestBody StudentDTO studentDTO) throws NoSuchEntityException {
		return studentService.updateStudent(studentDTO);
	}

}
