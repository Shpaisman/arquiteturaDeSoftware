package com.maua.exponegocios.persistence.repository;

import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maua.exponegocios.persistence.entity.Comerciante;


@Repository
public interface ComercianteRepository extends JpaRepository<Comerciante, Long>{
	
	List<Comerciante> findByHorarioAberturaGreaterThanEqualAndHorarioFechamentoLessThanEqual(LocalTime horarioAbertura, LocalTime horarioFechamento);
	
	List<Comerciante> findByHorarioFechamentoLessThanEqual(LocalTime horarioFechamento);
	
	List<Comerciante> findByHorarioAberturaGreaterThanEqual(LocalTime horarioAbertura);
	
	Comerciante findByNomeIgnoringCase (String nome);
	
	boolean existsByNomeIgnoringCase(String nome);

}
