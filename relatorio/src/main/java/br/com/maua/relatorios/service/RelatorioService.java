package br.com.maua.relatorios.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.maua.relatorios.model.Relatorio;
import br.com.maua.relatorios.repository.RelatorioRepository;

@Service
public class RelatorioService {
	
	RelatorioRepository relatorioRepo;
	
	@Autowired
	public RelatorioService(RelatorioRepository relatorioRepo) {
		this.relatorioRepo = relatorioRepo;
	}

	public void incrementarConsumidor() {
		
		Relatorio relatorio = relatorioRepo.findById(1).get();
		Relatorio saved = relatorio.incrementaConsumidor();
		
		relatorioRepo.save(saved);
	}
	
	public void incrementarComerciante() {
		Relatorio relatorio = relatorioRepo.findById(1).get();
		Relatorio saved = relatorio.incrementaComerciante();
		
		relatorioRepo.save(saved);
	}
}
