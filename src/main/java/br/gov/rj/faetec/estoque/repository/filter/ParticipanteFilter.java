package br.gov.rj.faetec.estoque.repository.filter;

import java.sql.Date;
import br.gov.rj.faetec.estoque.model.Tipo;
//import br.gov.rj.faetec.estoque.model.Origem;
//import br.gov.rj.faetec.estoque.model.Sabor;

public class ParticipanteFilter {
	
	private String nome;
	private Date dtnascimento;
	private String email;
	private String celular;
	private Date dtcadastro;
	private Tipo tipo;
	
	public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDtnascimento() {
        return dtnascimento;
    }

    public void setDtnascimento(Date dtnascimento) {
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

    public Date getDtcadastro() {
        return dtcadastro;
    }

    public void setDtcadastro(Date dtcadastro) {
        this.dtcadastro = dtcadastro;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

}
