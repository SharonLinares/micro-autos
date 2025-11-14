package com.sharito.demo.micro_interfaces.dto;

public class AutoDto {

	public Integer id;
	public String marca;
	public String modelo;
	public Integer anio;

	public AutoDto() {
		super();
	}

	public AutoDto(Integer id, String marca, String modelo, Integer anio) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.anio = anio;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

}
