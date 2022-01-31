package org.generation.italy.entityTransporter;

import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.generation.italy.model.Agente;
import org.generation.italy.model.Immobile;
import org.generation.italy.model.SlotOrari;

public class AppuntamentoTransporter {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private Immobile immobile;
    
    @NotEmpty(message="L'email è obbligatoria")
    private String email;
    
    @NotNull
    private LocalDate data;
    
    private Agente agente;
    
    @NotNull
    private SlotOrari slotOrari;
    
	private String nome;
    
	private String cognome;
	
	private String phone;
	
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Immobile getImmobile() {
		return immobile;
	}

	public void setImmobile(Immobile immobile) {
		this.immobile = immobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public SlotOrari getSlotOrari() {
		return slotOrari;
	}

	public void setSlotOrari(SlotOrari slotOrari) {
		this.slotOrari = slotOrari;
	}

	public Agente getAgente() {
		return agente;
	}

	public void setAgente(Agente agente) {
		this.agente = agente;
	}
	
}
