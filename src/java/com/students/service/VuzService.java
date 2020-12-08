package com.students.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.students.dto.VuzDTO;
import com.students.exceptions.NoSuchEntityException;
import com.students.models.Vuz;
import com.students.repositories.GruppaRepository;
import com.students.repositories.VuzRepository;
import com.students.utils.EntityAndDTOConverter;

@Service
public class VuzService {

	private static final String NO_SUCH_APPOINTMENT_MESSAGE = "Vuz with such id is not found ";
	private VuzRepository vuzRepository;
	private EntityAndDTOConverter converter;

	@Autowired
	public VuzService(VuzRepository vuzRepository, EntityAndDTOConverter converter,
			GruppaRepository gruppaRepository) {
		this.vuzRepository = vuzRepository;
		this.converter = converter;
	}

	public void cancel(long id) {
		vuzRepository.deleteById(id);
	}

	private Vuz convertDTOToEntity(VuzDTO vuzDTO) {
		Vuz vuz = new Vuz();
		vuz.setId(vuzDTO.getId());
		vuz.setName(vuzDTO.getName());
		vuz.setAddress(vuzDTO.getAddress());
		vuz.setRegNum(vuzDTO.getRegNum());
		return vuz;
	}

	private VuzDTO convertEntityToDTO(Vuz entity) {
		return converter.convert(entity, VuzDTO.class);
	}

	public List<VuzDTO> findAll() {
		return vuzRepository.findAll().stream().map(this::convertEntityToDTO).collect(Collectors.toList());
	}

	public VuzDTO findById(long id) throws NoSuchEntityException {
		Vuz foundEntity = vuzRepository.findById(id)
				.orElseThrow(() -> new NoSuchEntityException(NO_SUCH_APPOINTMENT_MESSAGE + id));
		return convertEntityToDTO(foundEntity);
	}

	public VuzDTO saveVuz(VuzDTO vuzDTO) {
		Vuz vuz = convertDTOToEntity(vuzDTO);
		return convertEntityToDTO(vuzRepository.save(vuz));
	}

	public VuzDTO updateVuz(VuzDTO vuzDTO) throws NoSuchEntityException {
		Vuz vuz = vuzRepository.findById(vuzDTO.getId())
				.orElseThrow(() -> new NoSuchEntityException(NO_SUCH_APPOINTMENT_MESSAGE + vuzDTO.getId()));
		vuz.setName(vuzDTO.getName());
		vuz.setAddress(vuzDTO.getAddress());
		vuz.setRegNum(vuzDTO.getRegNum());
		return convertEntityToDTO(vuzRepository.save(vuz));
	}

}
