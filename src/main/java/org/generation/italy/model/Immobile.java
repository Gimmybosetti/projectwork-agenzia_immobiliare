package org.generation.italy.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Immobile {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private Integer canone;
	
	@NotNull
	@NotEmpty(message="indirizzo non deve essere null")
	private String indirizzo;
	
	@NotNull(message="nBalconi non deve essere null")
	private Integer nBalconi;
	
	@NotNull(message="nBagni non deve essere null")
	private Integer nBagni;
	
	@NotNull(message="nStanze non deve essere null")
	private Integer nStanze;
	
	@NotNull(message="inVendita non deve essere null")
	private Boolean inVendita;
	
	@Column(nullable=false)
	private Boolean libero;

	@Column(nullable=false)
	private LocalDateTime dataIns;
	
	private Boolean cancellato;
	
	@NotEmpty(message="Il titolo è obbligatorio")
	private String titolo;
	
	@NotNull
	private Integer metri;
	
	@NotNull(message="tipologia non deve essere null")
	@ManyToOne
	private Tipologia tipologia;
	
	@NotNull(message="classeEnergetica non deve essere null")
	@ManyToOne
	private ClasseEnergetica classeEnergetica;
	
	private Integer numVisual;
	
	@NotNull(message="agente non deve essere null")
	@ManyToOne
	private Agente agente;
	
	@OneToMany(mappedBy = "immobile")
    private List<Appuntamento> appuntamenti;
	
	@ManyToMany
	private List<Foto> foto;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Boolean getCancellato() {
		return cancellato;
	}

	public void setCancellato(Boolean cancellato) {
		this.cancellato = cancellato;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public Integer getMetri() {
		return metri;
	}

	public void setMetri(Integer metri) {
		this.metri = metri;
	}

	public Tipologia getTipologia() {
		return tipologia;
	}

	public void setTipologia(Tipologia tipologia) {
		this.tipologia = tipologia;
	}

	public LocalDateTime getDataIns() {
		return dataIns;
	}
	public void setDataIns(LocalDateTime dataIns) {
		this.dataIns = dataIns;
	}
	public ClasseEnergetica getClasseEnergetica() {
		return classeEnergetica;
	}

	public void setClasseEnergetica(ClasseEnergetica classeEnergetica) {
		this.classeEnergetica = classeEnergetica;
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

	public List<Appuntamento> getAppuntamenti() {
		return appuntamenti;
	}

	public void setAppuntamenti(List<Appuntamento> appuntamenti) {
		this.appuntamenti = appuntamenti;
	}

	public List<Foto> getFoto() {
		return foto;
	}

	public void setFoto(List<Foto> foto) {
		this.foto = foto;
	}
	
}
















