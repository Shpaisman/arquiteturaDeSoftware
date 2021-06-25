package br.com.maua.relatorios.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_relatorio")
public class Relatorio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Integer qtdComerciante;
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

