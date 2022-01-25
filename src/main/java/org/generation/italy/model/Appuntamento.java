package org.generation.italy.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Appuntamento {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "immobile_id")
    private Immobile immobile;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;    
    
    @NotNull
    private LocalDateTime data;
    
    @ManyToOne
    private Agente agente;
    
    @ManyToOne
    private SlotOrari slotOrari;

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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public SlotOrari getSlotOrari() {
		return slotOrari;
	}

	public void setSlotOrari(SlotOrari slotOrari) {
		this.slotOrari = slotOrari;
	}
    
}
