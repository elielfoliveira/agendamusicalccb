// Autor: Eliel
// Data: 24/05/2023
package br.gov.rj.faetec.estoque.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import br.gov.rj.faetec.estoque.validation.SKU;

@Entity
@Table(name = "encarregado")
public class Encarregado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Nome do encarregado é obrigatorio")
	@Size(max = 80, message = "O tamanho da descrição deve estar entre 1 e 80")
	private String nome;

	@NotBlank(message = "O telefone é obrigatório")
	@Size(max = 20, message = "O tamanho do telefone deve estar entre 1 e 20")
	private String telefone;

	@NotBlank(message = "O status é obrigatório")
	@Size(max = 20, message = "O tamanho do status deve estar entre 1 e 20")
	private String status;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Encarregado other = (Encarregado) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
		
	}

	
}