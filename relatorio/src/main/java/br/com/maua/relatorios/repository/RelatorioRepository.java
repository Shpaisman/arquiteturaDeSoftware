package br.com.maua.relatorios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.maua.relatorios.model.Relatorio;

@Repository
public interface RelatorioRepository extends JpaRepository<Relatorio, Integer>{

}
