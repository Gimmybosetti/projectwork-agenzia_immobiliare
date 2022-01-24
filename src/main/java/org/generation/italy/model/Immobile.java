package org.generation.italy.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Immobile {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	private Integer canone;
	
	@NotNull
	@NotEmpty
	private String indirizzo;
	
	@NotNull
	private Integer nBalconi;
	
	@NotNull
	private Integer nBagni;
	
	@NotNull
	private Integer nStanze;
	
	@NotNull
	private Boolean inVendita;
	
	@NotNull
	private Boolean libero;

	@NotNull
	private LocalDateTime dataIns;
	
	@NotNull
	@ManyToOne
	private Tipologia tipologia;
	
	@NotNull
	@ManyToOne
	private ClasseEnergetica classeEner;
	
	private Integer numVisual;
	
	@NotNull
	@ManyToOne
	private Agente agente;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCanone() {
		return canone;
	}

	public void setCanone(Integer canone) {
		this.canone = canone;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public Integer getnBalconi() {
		return nBalconi;
	}

	public void setnBalconi(Integer nBalconi) {
		this.nBalconi = nBalconi;
	}

	public Integer getnBagni() {
		return nBagni;
	}

	public void setnBagni(Integer nBagni) {
		this.nBagni = nBagni;
	}

	public Integer getnStanze() {
		return nStanze;
	}

	public void setnStanze(Integer nStanze) {
		this.nStanze = nStanze;
	}

	public Boolean getInVendita() {
		return inVendita;
	}

	public void setInVendita(Boolean inVendita) {
		this.inVendita = inVendita;
	}

	public Boolean getLibero() {
		return libero;
	}

	public void setLibero(Boolean libero) {
		this.libero = libero;
	}

	public Tipologia getTipologiaId() {
		return tipologia;
	}

	public void setTipologiaId(Tipologia tipologiaId) {
		this.tipologia = tipologiaId;
	}

	public LocalDateTime getDataIns() {
		return dataIns;
	}

	public ClasseEnergetica getClasseEner() {
		return classeEner;
	}

	public void setClasseEner(ClasseEnergetica classeEner) {
		this.classeEner = classeEner;
	}

	public Integer getNumVisual() {
		return numVisual;
	}

	public void setNumVisual(Integer numVisual) {
		this.numVisual = numVisual;
	}

	public Agente getAgente() {
		return agente;
	}

	public void setAgente(Agente agente) {
		this.agente = agente;
	}
	
}
















