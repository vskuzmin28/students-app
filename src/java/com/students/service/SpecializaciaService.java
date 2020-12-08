package com.students.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.students.dto.SpecializaciaDTO;
import com.students.exceptions.NoSuchEntityException;
import com.students.models.Specializacia;
import com.students.repositories.GruppaRepository;
import com.students.repositories.SpecializaciaRepository;
import com.students.utils.EntityAndDTOConverter;

@Service
public class SpecializaciaService {

	private static final String NO_SUCH_APPOINTMENT_MESSAGE = "Specializacia with such id is not found ";
	private SpecializaciaRepository specializaciaRepository;
	private EntityAndDTOConverter converter;

	@Autowired
	public SpecializaciaService(SpecializaciaRepository specializaciaRepository, EntityAndDTOConverter converter,
			GruppaRepository gruppaRepository) {
		this.specializaciaRepository = specializaciaRepository;
		this.converter = converter;
	}

	public void cancel(long id) {
		specializaciaRepository.deleteById(id);
	}

	private Specializacia convertDTOToEntity(SpecializaciaDTO specializaciaDTO) {
		Specializacia specializacia = new Specializacia();
		specializacia.setId(specializaciaDTO.getId());
		specializacia.setName(specializaciaDTO.getName());
		specializacia.setShifr(specializaciaDTO.getShifr());

		return specializacia;
	}

	private SpecializaciaDTO convertEntityToDTO(Specializacia entity) {
		return converter.convert(entity, SpecializaciaDTO.class);
	}

	public List<SpecializaciaDTO> findAll() {
		return specializaciaRepository.findAll().stream().map(this::convertEntityToDTO).collect(Collectors.toList());
	}

	public SpecializaciaDTO findById(long id) throws NoSuchEntityException {
		Specializacia foundEntity = specializaciaRepository.findById(id)
				.orElseThrow(() -> new NoSuchEntityException(NO_SUCH_APPOINTMENT_MESSAGE + id));
		return convertEntityToDTO(foundEntity);
	}

	public SpecializaciaDTO saveSpecializacia(SpecializaciaDTO specializaciaDTO) {
		Specializacia specializacia = convertDTOToEntity(specializaciaDTO);
		return convertEntityToDTO(specializaciaRepository.save(specializacia));
	}

	public SpecializaciaDTO updateSpecializacia(SpecializaciaDTO specializaciaDTO) throws NoSuchEntityException {
		Specializacia specializacia = specializaciaRepository.findById(specializaciaDTO.getId())
				.orElseThrow(() -> new NoSuchEntityException(NO_SUCH_APPOINTMENT_MESSAGE + specializaciaDTO.getId()));
		specializacia.setName(specializaciaDTO.getName());
		specializacia.setShifr(specializaciaDTO.getShifr());
		return convertEntityToDTO(specializaciaRepository.save(specializacia));
	}

}
