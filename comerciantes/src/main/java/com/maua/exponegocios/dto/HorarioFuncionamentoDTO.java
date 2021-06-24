package com.maua.exponegocios.dto;

import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class HorarioFuncionamentoDTO {
	
	private LocalTime horarioAbertura;
	
	private LocalTime horarioFechamento;

}
