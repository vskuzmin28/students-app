package com.students.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.students.dto.KafedraDTO;
import com.students.exceptions.NoSuchEntityException;
import com.students.models.Kafedra;
import com.students.repositories.KafedraRepository;
import com.students.repositories.FacultetRepository;
import com.students.utils.EntityAndDTOConverter;

@Service
public class KafedraService {

	private static final String NO_SUCH_APPOINTMENT_MESSAGE = "Kafedra with such id is no found ";
	private KafedraRepository kafedraRepository;
	private EntityAndDTOConverter converter;
	private FacultetRepository facultetRepository;

	@Autowired
	public KafedraService(KafedraRepository kafedraRepository, EntityAndDTOConverter converter,
			FacultetRepository facultetRepository) {
		this.kafedraRepository = kafedraRepository;
		this.converter = converter;
		this.facultetRepository = facultetRepository;
	}

	public void cancel(long id) {
		kafedraRepository.deleteById(id);
	}

	private Kafedra convertDTOToEntity(KafedraDTO kafedraDTO) {
		Kafedra kafedra = new Kafedra();
		kafedra.setId(kafedraDTO.getId());
		kafedra.setName(kafedraDTO.getName());
		kafedra.setCode(kafedraDTO.getCode());
		kafedra.setFacultet(facultetRepository.findById(kafedraDTO.getFacultet().getId()).get());
		return kafedra;
	}

	private KafedraDTO convertEntityToDTO(Kafedra entity) {
		return converter.convert(entity, KafedraDTO.class);
	}

	public List<KafedraDTO> findAll() {
		return kafedraRepository.findAll().stream().map(this::convertEntityToDTO).collect(Collectors.toList());
	}

	public KafedraDTO findById(long id) throws NoSuchEntityException {
		Kafedra foundEntity = kafedraRepository.findById(id)
				.orElseThrow(() -> new NoSuchEntityException(NO_SUCH_APPOINTMENT_MESSAGE + id));
		return convertEntityToDTO(foundEntity);
	}

	public KafedraDTO saveKafedra(KafedraDTO kafedraDTO) {
		Kafedra kafedra = convertDTOToEntity(kafedraDTO);
		return convertEntityToDTO(kafedraRepository.save(kafedra));
	}

	public KafedraDTO updateKafedra(KafedraDTO kafedraDTO) throws NoSuchEntityException {
		Kafedra kafedra = kafedraRepository.findById(kafedraDTO.getId())
				.orElseThrow(() -> new NoSuchEntityException(NO_SUCH_APPOINTMENT_MESSAGE + kafedraDTO.getId()));
		kafedra.setName(kafedraDTO.getName());
		kafedra.setCode(kafedraDTO.getCode());
		kafedra.setFacultet(facultetRepository.findById(kafedraDTO.getFacultet().getId()).get());
		return convertEntityToDTO(kafedraRepository.save(kafedra));
	}

}
