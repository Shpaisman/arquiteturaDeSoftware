package br.com.maua.relatorios.service;

import java.util.Optional;

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
		
		Optional<Relatorio> relatorioOptional = relatorioRepo.findById(1);
		if(!relatorioOptional.isPresent()) {
			relatorioRepo.save(new Relatorio(1, 0, 1));
		}else {
			Relatorio saved = relatorioOptional.get().incrementaConsumidor();
			
			relatorioRepo.save(saved);
		}
	}
	
	public void incrementarComerciante() {
		Optional<Relatorio> relatorioOptional = relatorioRepo.findById(1);
		if(!relatorioOptional.isPresent()) {
			relatorioRepo.save(new Relatorio(1, 1, 0));
		}else {
			Relatorio saved = relatorioOptional.get().incrementaComerciante();
			
			relatorioRepo.save(saved);
		}
	}
}
