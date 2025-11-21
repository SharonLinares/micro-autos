package com.sharito.demo.micro_interfaces.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sharito.demo.micro_interfaces.dto.AutoDto;
import com.sharito.demo.micro_interfaces.service.AutoService;

@RestController
@RequestMapping("autos")
public class AutoController {

	@Autowired
	private AutoService autoService;

	@PostMapping("/crear")
	public ResponseEntity<AutoDto> crear(@RequestBody AutoDto autoDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(autoService.crear(autoDto));
	}

	@PutMapping("/autualizar/{matricula}")
	public ResponseEntity<AutoDto> actualizar(@RequestBody AutoDto autoDto,  @PathVariable String matricula) {
		return ResponseEntity.status(HttpStatus.CREATED).body(autoService.actualizar(autoDto, matricula));

	}

	@GetMapping("/consultarautos")
	public ResponseEntity<List<AutoDto>> consultarAuto() {
		return ResponseEntity.ok(autoService.consultarAutos());
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
		autoService.eliminar(id);
		return ResponseEntity.noContent().build();
	}

}
