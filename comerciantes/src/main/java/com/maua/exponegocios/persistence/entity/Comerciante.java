package com.maua.exponegocios.persistence.entity;

import java.time.LocalTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "COMERCIANTES", schema = "public")
@Entity
public class Comerciante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "NOME", nullable = false, unique = true)
	private String nome;
	
	@Column(name = "ENDERECO_VIRTUAL")
	private String enderecoVirtual;
	
	@Column(name = "DATA_ABERTURA")
	@Convert(converter =Jsr310JpaConverters.LocalTimeConverter.class)
	private LocalTime horarioAbertura;
	
	@Column(name = "DATA_FECHAMENTO")
	@Convert(converter =Jsr310JpaConverters.LocalTimeConverter.class)
	private LocalTime horarioFechamento;
	
	@Column(name = "FORMAS_PAGAMENTO")
	@ElementCollection(targetClass = String.class)
	private List<String> formaPagamento;
	
}
