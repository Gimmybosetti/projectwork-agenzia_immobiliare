package org.generation.italy.entityTransporter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

public class FotoTransporter {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	
	@NotNull
	@NotEmpty(message="Il titolo è obbligatorio")
	private String titolo;
	
	private MultipartFile content;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public MultipartFile getContent() {
		return content;
	}

	public void setContent(MultipartFile content) {
		this.content = content;
	}
	
}
