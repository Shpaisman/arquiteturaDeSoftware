package br.com.maua.relatorios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.maua.relatorios.service.RelatorioService;

@RestController
@RequestMapping("/relatorio")
public class RelatorioController {

	RelatorioService relatorioService;
	
	@Autowired
	public RelatorioController(RelatorioService relatorioService){
		this.relatorioService = relatorioService;
	}
	
	@PutMapping("/comerciante")
	public ResponseEntity<?> incrementarComerciante() {
		relatorioService.incrementarComerciante();
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/consumidor")
	public ResponseEntity<?> incrementarConsumidor() {
		relatorioService.incrementarConsumidor();
		return ResponseEntity.ok().build();
	}
}
