	package com.maua.exponegocios.service.impl;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.maua.exponegocios.dto.ComercianteDTO;
import com.maua.exponegocios.dto.ComercianteupdateDTO;
import com.maua.exponegocios.persistence.entity.Comerciante;
import com.maua.exponegocios.persistence.repository.ComercianteRepository;
import com.maua.exponegocios.service.ComercianteService;

@Service
public class ComercianteServiceImpl implements ComercianteService {

	@Autowired
	private ComercianteRepository repository;
	
	private String NOT_FOUND_ENTITY = "Id informado nao encontrado";
	
	@Override
	public List<ComercianteDTO> getAll() {
		return new ComercianteDTO().fromEntity(repository.findAll());
	}

	@Override
	public ComercianteDTO getById(Long id) {
		return new ComercianteDTO().fromEntity(repository.findById(id).get());
	}

	@Override
	public ComercianteDTO getByNome(String nome) {
		return new ComercianteDTO().fromEntity(repository.findByNomeIgnoringCase(nome));
	}
	
	@Override
	public List<ComercianteDTO> getByHorarioFuncionamento(String horarioAbertura, String horarioFechamento) {
		
		//nao passou horario de abertura nem fechamento
		if(horarioAbertura.equals("%") && horarioFechamento.equals("%"))
			return new ArrayList<>();
		
		//passou apenas horario abertura
		else if(!horarioAbertura.equals("%") && horarioFechamento.equals("%"))
			return new ComercianteDTO()
					.fromEntity(
							repository
								.findByHorarioAberturaGreaterThanEqual(
										LocalTime.parse(horarioAbertura)));
		
		//passou apenas horario fechamento
		else if(horarioAbertura.equals("%") && !horarioFechamento.equals("%"))
			return new ComercianteDTO()
					.fromEntity(
							repository
								.findByHorarioFechamentoLessThanEqual(
										LocalTime.parse(horarioFechamento)));
		
		//passou os 2 horarios
		else
			return new ComercianteDTO()
					.fromEntity(
							repository
								.findByHorarioAberturaGreaterThanEqualAndHorarioFechamentoLessThanEqual(
										LocalTime.parse(horarioAbertura), LocalTime.parse(horarioFechamento)));
	}

	@Override
	public Comerciante create(Comerciante comerciante) {
		
		if(repository.existsByNomeIgnoringCase(comerciante.getNome()))
			throw new DuplicateKeyException("Nome já cadastrado na base de dados");
		else
			return repository.save(comerciante);
		
	}

	@Override
	public ComercianteDTO update(Long id, ComercianteupdateDTO comerciante) {
		boolean present = repository.findById(id).isPresent();
		
		if (present)
			return new ComercianteDTO().fromEntity(
					repository.save(new ComercianteDTO().fromModel(id, comerciante))
						);
		else
			return null;
	}

	@Override
	public void delete(Long id) {
		boolean present = repository.findById(id).isPresent();
		
		if(present)
			repository.deleteById(id);
		else
			throw new Error(NOT_FOUND_ENTITY);
	}


}
