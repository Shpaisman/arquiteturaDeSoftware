package com.maua.exponegocios.controller;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maua.exponegocios.dto.ComercianteDTO;
import com.maua.exponegocios.dto.ComercianteupdateDTO;
import com.maua.exponegocios.persistence.entity.Comerciante;
import com.maua.exponegocios.service.ComercianteService;

@RestController
@RequestMapping("exponegocio")
public class ComercianteController {
	
	@Autowired
	private ComercianteService service;
	
	@GetMapping("/comerciantes")
	public List<ComercianteDTO> getAll(){
			return service.getAll();
	}
	
	@GetMapping("/comerciante/{busca}")
	public ComercianteDTO getByIdOrName(@PathVariable(name = "busca") String busca) {
		
		try {
			Long parseLong = Long.parseLong(busca);
			
			return service.getById(parseLong);
		}catch (NumberFormatException e) {
			return service.getByNome(busca.replace("_", " "));
		}
	}
	
	@GetMapping("/horarios/{abertura&&fechamento}")
	public List<ComercianteDTO> getByHorarioFuncionamento(@PathVariable(name = "abertura&&fechamento") String horarios){
		String[] horario = horarios.split("&&");
		return service.getByHorarioFuncionamento(horario[0],horario[1]);
	}
	
	@PostMapping("/cadastro")
	public Comerciante create(@RequestBody Comerciante comerciante) {
		return service.create(comerciante);
	}
	
	@PutMapping("/comerciante/{id}/atualizar")
	public ComercianteDTO update(@PathVariable(name = "id") Long id,@RequestBody ComercianteupdateDTO comerciante) {
		return service.update(id, comerciante);
	}
	
	@DeleteMapping("/comerciante/{id}/deletar")
	public void delete(@PathVariable(name = "id") Long id) {
		service.delete(id);
	}

}
