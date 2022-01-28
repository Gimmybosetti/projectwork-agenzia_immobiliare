package org.generation.italy.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Agente {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "Nome è obbligatorio, pirletta!")
	@NotNull
	private String nome;
	
	@NotEmpty(message = "Cognome è obbligatorio, pirletta!")
	@NotNull
	private String cognome;

	@OneToMany(mappedBy= "agente")
	private List<Appuntamento> appuntamenti;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public List<Appuntamento> getAppuntamenti() {
		return appuntamenti;
	}

	public void setAppuntamenti(List<Appuntamento> appuntamenti) {
		this.appuntamenti = appuntamenti;
	}

}
