package com.students.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.students.dto.StudentDTO;
import com.students.exceptions.NoSuchEntityException;
import com.students.models.Student;
import com.students.repositories.GruppaRepository;
import com.students.repositories.StudentRepository;
import com.students.utils.EntityAndDTOConverter;

@Service
public class StudentService {

	private static final String NO_SUCH_APPOINTMENT_MESSAGE = "Student with such id is no found ";
	private StudentRepository studentRepository;
	private EntityAndDTOConverter converter;
	private GruppaRepository gruppaRepository;

	@Autowired
	public StudentService(StudentRepository studentRepository, EntityAndDTOConverter converter,
			GruppaRepository gruppaRepository) {
		this.studentRepository = studentRepository;
		this.converter = converter;
		this.gruppaRepository = gruppaRepository;
	}

	public void cancel(long id) {
		studentRepository.deleteById(id);
	}

	private Student convertDTOToEntity(StudentDTO studentDTO) {
		Student student = new Student();
		student.setId(studentDTO.getId());
		student.setFio(studentDTO.getFio());
		student.setGruppa(gruppaRepository.findById(studentDTO.getGruppa().getId()).get());
		return student;
	}

	private StudentDTO convertEntityToDTO(Student entity) {
		return converter.convert(entity, StudentDTO.class);
	}

	public List<StudentDTO> findAll() {
		return studentRepository.findAll().stream().map(this::convertEntityToDTO).collect(Collectors.toList());
	}

	public List<StudentDTO> findAllFiltered(long vuzId, long facultetId,
			long kafedraId, long gruppaId, long specializaciaId) {
		return studentRepository.findAllFiltered(vuzId, facultetId, kafedraId, gruppaId, specializaciaId).stream().map(this::convertEntityToDTO).collect(Collectors.toList());
	}
	public StudentDTO findById(long id) throws NoSuchEntityException {
		Student foundEntity = studentRepository.findById(id)
				.orElseThrow(() -> new NoSuchEntityException(NO_SUCH_APPOINTMENT_MESSAGE + id));
		return convertEntityToDTO(foundEntity);
	}

	public StudentDTO saveStudent(StudentDTO studentDTO) {
		Student student = convertDTOToEntity(studentDTO);
		return convertEntityToDTO(studentRepository.save(student));
	}

	public StudentDTO updateStudent(StudentDTO studentDTO) throws NoSuchEntityException {
		Student student = studentRepository.findById(studentDTO.getId())
				.orElseThrow(() -> new NoSuchEntityException(NO_SUCH_APPOINTMENT_MESSAGE + studentDTO.getId()));
		student.setFio(studentDTO.getFio());
		student.setGruppa(gruppaRepository.findById(studentDTO.getGruppa().getId()).get());
		return convertEntityToDTO(studentRepository.save(student));
	}

}
