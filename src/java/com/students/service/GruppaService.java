package com.students.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.students.dto.GruppaDTO;
import com.students.exceptions.NoSuchEntityException;
import com.students.models.Gruppa;
import com.students.models.Specializacia;
import com.students.repositories.GruppaRepository;
import com.students.repositories.KafedraRepository;
import com.students.repositories.SpecializaciaRepository;
import com.students.utils.EntityAndDTOConverter;

@Service
public class GruppaService {

	private static final String NO_SUCH_APPOINTMENT_MESSAGE = "Gruppa with such id is no found ";
	private GruppaRepository gruppaRepository;
	private EntityAndDTOConverter converter;
	private KafedraRepository facultetRepository;
	private SpecializaciaRepository specializaciaRepository;

	@Autowired
	public GruppaService(GruppaRepository gruppaRepository, EntityAndDTOConverter converter,
			KafedraRepository kafedraRepository, SpecializaciaRepository specializaciaRepository) {
		this.gruppaRepository = gruppaRepository;
		this.converter = converter;
		this.facultetRepository = kafedraRepository;
		this.specializaciaRepository = specializaciaRepository;
	}

	public void cancel(long id) {
		gruppaRepository.deleteById(id);
	}

	private Gruppa convertDTOToEntity(GruppaDTO gruppaDTO) {
		Gruppa gruppa = new Gruppa();
		gruppa.setId(gruppaDTO.getId());
		gruppa.setName(gruppaDTO.getName());
		gruppa.setCode(gruppaDTO.getCode());
		gruppa.setKafedra(facultetRepository.findById(gruppaDTO.getKafedra().getId()).get());
		gruppa.setSpecializacia(specializaciaRepository.findById(gruppaDTO.getSpecializacia().getId()).get());
		return gruppa;
	}

	private GruppaDTO convertEntityToDTO(Gruppa entity) {
		return converter.convert(entity, GruppaDTO.class);
	}

	public List<GruppaDTO> findAll() {
		return gruppaRepository.findAll().stream().map(this::convertEntityToDTO).collect(Collectors.toList());
	}

	public GruppaDTO findById(long id) throws NoSuchEntityException {
		Gruppa foundEntity = gruppaRepository.findById(id)
				.orElseThrow(() -> new NoSuchEntityException(NO_SUCH_APPOINTMENT_MESSAGE + id));
		return convertEntityToDTO(foundEntity);
	}

	public GruppaDTO saveGruppa(GruppaDTO gruppaDTO) {
		Gruppa gruppa = convertDTOToEntity(gruppaDTO);
		return convertEntityToDTO(gruppaRepository.save(gruppa));
	}

	public GruppaDTO updateGruppa(GruppaDTO gruppaDTO) throws NoSuchEntityException {
		Gruppa gruppa = gruppaRepository.findById(gruppaDTO.getId())
				.orElseThrow(() -> new NoSuchEntityException(NO_SUCH_APPOINTMENT_MESSAGE + gruppaDTO.getId()));
		gruppa.setName(gruppaDTO.getName());
		gruppa.setCode(gruppaDTO.getCode());
		gruppa.setKafedra(facultetRepository.findById(gruppaDTO.getKafedra().getId()).get());
		gruppa.setSpecializacia(specializaciaRepository.findById(gruppaDTO.getSpecializacia().getId()).get());
		return convertEntityToDTO(gruppaRepository.save(gruppa));
	}

}
