package com.sharito.demo.micro_interfaces.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sharito.demo.micro_interfaces.dto.AutoDto;
import com.sharito.demo.micro_interfaces.entity.AutoEntity;
import com.sharito.demo.micro_interfaces.repository.AutoRepository;
import com.sharito.demo.micro_interfaces.service.AutoService;

@Service
public class AutoServiceImpl implements AutoService {

	@Autowired
	private AutoRepository autoRepository;

	@Override
	public AutoDto crear(AutoDto autoDto) {
		AutoEntity autoEntity = new AutoEntity();
		autoEntity.setMarca(autoDto.getMarca());
		autoEntity.setModelo(autoDto.getModelo());
		autoEntity.setAnio(autoDto.getAnio());
		autoRepository.save(autoEntity);
		autoDto.setId(autoEntity.getId());
		return autoDto;
	}

	@Override
	public AutoDto actualizar(AutoDto autoDto, Integer id) {
		AutoEntity autoEntity = autoRepository.findById(id).orElse(null);
		if (autoEntity != null) {
			autoEntity.setMarca(autoDto.getMarca());
			autoEntity.setModelo(autoDto.getModelo());
			autoEntity.setAnio(autoDto.getAnio());
			autoRepository.save(autoEntity);
			autoDto.setId(autoEntity.getId());
		}

		return autoDto;
	}

	@Override
	public List<AutoDto> consultarAuto() {
		List<AutoEntity> autosEntity = autoRepository.findAll();
		List<AutoDto> autosDto = new ArrayList<>();
		for (AutoEntity autoEntity : autosEntity) {
			AutoDto autoDto = new AutoDto();
			autoDto.setAnio(autoEntity.getAnio());
			autoDto.setMarca(autoEntity.getMarca());
			autoDto.setModelo(autoEntity.getModelo());
			autoDto.setId(autoEntity.getId());
			autosDto.add(autoDto);
		}

		return autosDto;
	}

	@Override
	public void eliminar(Integer id) {
		if (autoRepository.existsById(id)) {
			autoRepository.deleteById(id);
		}

	}

}
