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
		autoEntity.setAnioDeMatriculacion(autoDto.getAnioDeMatriculacion());
		autoEntity.setMarca(autoDto.getMarca());
		autoEntity.setModelo(autoDto.getModelo());
		autoEntity.setMatricula(autoDto.getMatricula());
		autoRepository.save(autoEntity);
		return autoDto;
	}

	@Override
	public AutoDto actualizar(AutoDto autoDto, Integer id) {
		AutoEntity autoEntity = autoRepository.findById(id).orElse(null);
		if (autoEntity != null) {
			autoEntity.setAnioDeMatriculacion(autoDto.getAnioDeMatriculacion());
			autoEntity.setMarca(autoDto.getMarca());
			autoEntity.setModelo(autoDto.getModelo());
			autoEntity.setMatricula(autoDto.getMatricula());
			autoRepository.save(autoEntity);

		}

		return autoDto;
	}

	@Override
	public List<AutoDto> consultarAutos() {
		List<AutoEntity> autosEntity = autoRepository.findAll();
		List<AutoDto> autosDto = new ArrayList<>();
		for (AutoEntity autoEntity : autosEntity) {
			AutoDto autoDto = new AutoDto();
			autoDto.setAnioDeMatriculacion(autoEntity.getAnioDeMatriculacion());
			autoDto.setMarca(autoEntity.getMarca());
			autoDto.setMatricula(autoEntity.getMatricula());
			autoDto.setModelo(autoEntity.getModelo());

		}

		return null;
	}

	@Override
	public void eliminar(Integer id) {
		if (autoRepository.existsById(id)) {
			autoRepository.deleteById(id);
		}
	}

}
