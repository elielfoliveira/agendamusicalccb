package br.gov.rj.faetec.estoque.model;

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
@Table(name = "congregacao")
public class Congregacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Nome da rua é obrigatório")
	@Size(max = 80, message = "O tamanho da rua deve estar entre 1 e 80")
	private String endereco;
	
	@NotBlank(message = "Numero da rua é obrigatório")
	@Size(max = 6, message = "O tamanho do numero rua deve estar entre 1 e 6")
	private String numero;
	
	@NotBlank(message = "Nome do bairro é obrigatório")
	@Size(max = 50, message = "O tamanho do bairro deve estar entre 1 e 50")
	private String bairro;
	
	@NotBlank(message = "Nome da cidade é obrigatório")
	@Size(max = 50, message = "O tamanho da rua deve estar entre 1 e 50")
	private String cidade;
		
	@NotBlank(message = "A Uf do estado é obrigatório")
	@Size(max = 2, message = "O tamanho da Uf estado deve estar entre 1 e 2")
	private String uf;
	
	@NotBlank(message = "O cep da rua é obrigatório")
	@Size(max = 9, message = "O tamanho do cep da rua deve estar entre 1 e 9")
	private String cep;
		
	
		public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
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
		Congregacao other = (Congregacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
