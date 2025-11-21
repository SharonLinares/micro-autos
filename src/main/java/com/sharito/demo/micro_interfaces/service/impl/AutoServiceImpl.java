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

		if (!this.autoRepository.existsByMatricula(autoDto.getMatricula())) {
			autoRepository.save(autoEntity);

		} else {
			throw new IllegalArgumentException("ya existe esta matricula");
		}

		return autoDto;
	}

	@Override
	public AutoDto actualizar(AutoDto autoDto, String matricula) {
		if (autoRepository.existsByMatricula(matricula)) {
			if (autoRepository.existsByMatricula(autoDto.getMatricula())) {
				throw new IllegalArgumentException("ya existe esta matricula");
			}
			AutoEntity autoEntity = autoRepository.findByMatricula(matricula);
			
			autoEntity.setAnioDeMatriculacion(autoDto.getAnioDeMatriculacion());
			autoEntity.setMarca(autoDto.getMarca());
			autoEntity.setModelo(autoDto.getModelo());
			autoEntity.setMatricula(autoDto.getMatricula());
			autoRepository.save(autoEntity);
		} else {
			throw new IllegalArgumentException("NO existe esta matricula");
		}

		return autoDto;
	}

//AutoEntity autoEntity = autoRepository.existsByMatricula(matricula);
//if (autoEntity != null) {
//	autoEntity.setAnioDeMatriculacion(autoDto.getAnioDeMatriculacion());
//	autoEntity.setMarca(autoDto.getMarca());
//	autoEntity.setModelo(autoDto.getModelo());
//	autoEntity.setMatricula(autoDto.getMatricula());
//	autoRepository.save(autoEntity);

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
