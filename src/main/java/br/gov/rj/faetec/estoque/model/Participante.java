package br.gov.rj.faetec.estoque.model;

import java.math.BigDecimal;
import java.time.LocalDate;

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
@Table(name = "participante")
public class Participante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "O nome é obrigatório")
	@Size(max = 80, message = "O tamanho do nome deve estar entre 1 e 80")
	private String nome;

	@NotBlank(message = "A data de nascimento é obrigatória")
	@Size(max = 10, message = "O tamanho da data de nascimento deve estar entre 1 e 10")
	private LocalDate dtnascimento;
	
	@NotBlank(message = "O email é obrigatório")
	@Size(max = 50, message = "O email deve estar entre 1 e 50")
	private String email;

	@NotBlank(message = "O numero do celular é obrigatório")
	@Size(max = 20, message = "O tamanho do numero do celular deve estar entre 1 e 20")
	private String celular;
	
	@NotBlank(message = "A data de cadastro é obrigatória")
	@Size(max = 10, message = "O tamanho da data de cadastro deve estar entre 1 e 10")
	private LocalDate dtcadastro;

	@NotNull(message = "O tipo de participante é obrigatório")
	@ManyToOne
	@JoinColumn(name = "idtipo")
	private Tipo tipo;
	
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
	
	public LocalDate getDtnascimento() {
        return dtnascimento;
    }

    public void setDtnascimento(LocalDate dtnascimento) {
        this.dtnascimento = dtnascimento;
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public LocalDate getDtcadastro() {
        return dtcadastro;
    }

    public void setDtcadastro(LocalDate dtcadastro) {
        this.dtcadastro = dtcadastro;
    }
	
	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
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
		Participante other = (Participante) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
