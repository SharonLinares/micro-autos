package com.sharito.demo.micro_interfaces.service;

import java.util.List;

import com.sharito.demo.micro_interfaces.dto.AutoDto;

public interface AutoService {

	public AutoDto crear(AutoDto autoDto);

	public AutoDto actualizar(AutoDto autoDto, Integer id);

	public List<AutoDto> consultarAutos();

	public void eliminar(Integer id);

}
