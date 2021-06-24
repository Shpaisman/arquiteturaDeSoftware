package com.maua.exponegocios.service;

import java.time.LocalTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.maua.exponegocios.dto.ComercianteDTO;
import com.maua.exponegocios.dto.ComercianteupdateDTO;
import com.maua.exponegocios.persistence.entity.Comerciante;

@Service
public interface ComercianteService {

	public List<ComercianteDTO> getAll();
	
	public ComercianteDTO getById(Long id);
	
	public ComercianteDTO getByNome(String nome);
	
	public List<ComercianteDTO> getByHorarioFuncionamento(String horarioAbertura, String horarioFechamento);
	
	public Comerciante create(Comerciante comerciante);
	
	public ComercianteDTO update(Long id, ComercianteupdateDTO comerciante);
	
	public void delete(Long id);
	
}
