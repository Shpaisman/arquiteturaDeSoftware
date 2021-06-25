package br.com.maua.relatorios.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_relatorio")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Relatorio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="qtd_comerciante")
	private Integer qtdComerciante;
	
	@Column(name="qtd_consumidor")
	private Integer qtdConsumidor;
	
	public Relatorio incrementaConsumidor() {
		this.qtdConsumidor += 1;
		return this;
	}
	
	public Relatorio incrementaComerciante() {
		this.qtdComerciante += 1;
		return this;
	}
}

