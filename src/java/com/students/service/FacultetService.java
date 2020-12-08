package com.students.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.students.dto.FacultetDTO;
import com.students.exceptions.NoSuchEntityException;
import com.students.models.Facultet;
import com.students.repositories.FacultetRepository;
import com.students.repositories.VuzRepository;
import com.students.utils.EntityAndDTOConverter;

@Service
public class FacultetService {

	private static final String NO_SUCH_APPOINTMENT_MESSAGE = "Facultet with such id is no found ";
	private FacultetRepository facultetRepository;
	private EntityAndDTOConverter converter;
	private VuzRepository vuzRepository;

	@Autowired
	public FacultetService(FacultetRepository facultetRepository, EntityAndDTOConverter converter,
			VuzRepository vuzRepository) {
		this.facultetRepository = facultetRepository;
		this.converter = converter;
		this.vuzRepository = vuzRepository;
	}

	public void cancel(long id) {
		facultetRepository.deleteById(id);
	}

	private Facultet convertDTOToEntity(FacultetDTO facultetDTO) {
		Facultet facultet = new Facultet();
		facultet.setId(facultetDTO.getId());
		facultet.setName(facultetDTO.getName());
		facultet.setCode(facultetDTO.getCode());
		facultet.setVuz(vuzRepository.findById(facultetDTO.getVuz().getId()).get());
		return facultet;
	}

	private FacultetDTO convertEntityToDTO(Facultet entity) {
		return converter.convert(entity, FacultetDTO.class);
	}

	public List<FacultetDTO> findAll() {
		return facultetRepository.findAll().stream().map(this::convertEntityToDTO).collect(Collectors.toList());
	}

	public FacultetDTO findById(long id) throws NoSuchEntityException {
		Facultet foundEntity = facultetRepository.findById(id)
				.orElseThrow(() -> new NoSuchEntityException(NO_SUCH_APPOINTMENT_MESSAGE + id));
		return convertEntityToDTO(foundEntity);
	}

	public FacultetDTO saveFacultet(FacultetDTO facultetDTO) {
		Facultet facultet = convertDTOToEntity(facultetDTO);
		return convertEntityToDTO(facultetRepository.save(facultet));
	}

	public FacultetDTO updateFacultet(FacultetDTO facultetDTO) throws NoSuchEntityException {
		Facultet facultet = facultetRepository.findById(facultetDTO.getId())
				.orElseThrow(() -> new NoSuchEntityException(NO_SUCH_APPOINTMENT_MESSAGE + facultetDTO.getId()));
		facultet.setName(facultetDTO.getName());
		facultet.setCode(facultetDTO.getCode());
		facultet.setVuz(vuzRepository.findById(facultetDTO.getVuz().getId()).get());
		return convertEntityToDTO(facultetRepository.save(facultet));
	}

}
