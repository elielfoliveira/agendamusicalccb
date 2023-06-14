package br.gov.rj.faetec.estoque.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.rj.faetec.estoque.model.Tipo;
import br.gov.rj.faetec.estoque.repository.Tipos;
import br.gov.rj.faetec.estoque.service.exception.DescricaoTipoJaCadastradoException;

@Service
public class CadastroTipoService {

	@Autowired
	private Tipos tipos;
	
	@Transactional
	public Tipo salvar(Tipo tipo) {
		Optional<Tipo> tipoOptional = tipos.findByDescricaoIgnoreCase(tipo.getDescricao());
		if (tipoOptional.isPresent()) {
			throw new DescricaoTipoJaCadastradoException("Tipo de participante já cadastrado");
		}
		
		return tipos.saveAndFlush(tipo);
		}
	
}
