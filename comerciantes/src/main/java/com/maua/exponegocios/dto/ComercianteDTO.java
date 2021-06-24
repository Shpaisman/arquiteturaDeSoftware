package com.maua.exponegocios.dto;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.maua.exponegocios.persistence.entity.Comerciante;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ComercianteDTO {
	
	private Long id;
	
	private String nome;

	private String enderecoVirtual;
	
	private LocalTime horarioAbertura;

	private LocalTime horarioFechamento;

	private List<String> formaPagamento;
	
	public ComercianteDTO fromEntity(Comerciante comerciante) {
		return builder()
						.id(comerciante.getId())
						.nome(comerciante.getNome())
						.enderecoVirtual(comerciante.getEnderecoVirtual())
						.horarioAbertura(comerciante.getHorarioAbertura())
						.horarioFechamento(comerciante.getHorarioFechamento())
						.formaPagamento(comerciante.getFormaPagamento())
						.build();
	}
	
	public List<ComercianteDTO> fromEntity(List<Comerciante> comerciantes) {
		
		List<ComercianteDTO> lista = new ArrayList<>();
		
		for(Comerciante comerciante : comerciantes) {
			var comercianteDto = new ComercianteDTO();
				comercianteDto.setId(comerciante.getId());
				comercianteDto.setNome(comerciante.getNome());
				comercianteDto.setEnderecoVirtual(comerciante.getEnderecoVirtual());
				comercianteDto.setHorarioAbertura(comerciante.getHorarioAbertura());
				comercianteDto.setHorarioFechamento(comerciante.getHorarioFechamento());
				comercianteDto.setFormaPagamento(comerciante.getFormaPagamento());
			
			lista.add(comercianteDto);
		}
		return lista;
	}
	
	public Comerciante fromModel(ComercianteDTO comerciante) {
		var entity = new Comerciante();
			entity.setNome(comerciante.nome);
			entity.setEnderecoVirtual(comerciante.getEnderecoVirtual());
			entity.setHorarioAbertura(comerciante.getHorarioAbertura());
			entity.setHorarioFechamento(comerciante.getHorarioFechamento());
			entity.setFormaPagamento(comerciante.getFormaPagamento());
			
			return entity;
		
	}
	
	public Comerciante fromModel(Long id, ComercianteupdateDTO comerciante) {
		var entity = new Comerciante();
				entity.setId(id);
				entity.setNome(comerciante.getNome());
				entity.setEnderecoVirtual(comerciante.getEnderecoVirtual());
				entity.setHorarioAbertura(comerciante.getHorarioAbertura());
				entity.setHorarioFechamento(comerciante.getHorarioFechamento());
				entity.setFormaPagamento(comerciante.getFormaPagamento());
		
		return entity;
	}

}
