package org.generation.italy.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.generation.italy.entityTransporter.AppuntamentoTransporter;
//import javax.validation.constraints.Pattern;

@Entity
public class Cliente {
	
	public Cliente () {	}
	
	public Cliente (AppuntamentoTransporter appTrans) throws Exception{
		
		if (appTrans.getNome() == null) {
			throw new Exception("Nome da inserire");
		}
		
		this.nome = appTrans.getNome();
		this.cognome = appTrans.getCognome();
		this.phone = appTrans.getPhone();
		this.email = appTrans.getEmail();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@NotNull(message="Inserisci un nome")
	private String nome;
	
	@NotEmpty
	@NotNull(message="Inserisci un cognome")
	private String cognome;
	
	@NotNull(message="Inserisci un numero di telefono")
	//@Pattern(regexp="^[2-9]\\d{2}-\\d{3}-\\d{4}$")
	private String phone;
	
	@NotEmpty
	@NotNull(message="Inserisci un email")
	//@Pattern(regexp="^[a-zA-Z0-9.!#$%&'*+\\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}\r\n"
	//		+ "[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$")
	private String email;
	
	@OneToMany(mappedBy = "cliente")
    List<Appuntamento> appuntamenti;
	
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Appuntamento> getAppuntamenti() {
		return appuntamenti;
	}

	public void setAppuntamenti(List<Appuntamento> appuntamenti) {
		this.appuntamenti = appuntamenti;
	}
	
}
