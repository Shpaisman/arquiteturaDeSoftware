package com.maua.exponegocios.dto;

import java.time.LocalTime;
import java.util.List;

import com.maua.exponegocios.persistence.entity.Comerciante;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComercianteupdateDTO {
	
	private String nome;

	private String enderecoVirtual;
	
	private LocalTime horarioAbertura;

	private LocalTime horarioFechamento;

	private List<String> formaPagamento;
	
	public Comerciante fromModel(ComercianteupdateDTO comerciante) {
		new Comerciante();
		return Comerciante.builder()
						.nome(comerciante.getNome())
						.enderecoVirtual(comerciante.getEnderecoVirtual())
						.horarioAbertura(comerciante.getHorarioAbertura())
						.horarioFechamento(comerciante.getHorarioFechamento())
						.formaPagamento(comerciante.getFormaPagamento())
						.build();
	}
}
