package br.gov.rj.faetec.estoque.controller.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import br.gov.rj.faetec.estoque.model.Tipo;

public class TipoConverter implements Converter<String, Tipo> {

	@Override
	public Tipo convert(String id) {
		if (!StringUtils.isEmpty(id)) {
			Tipo tipo = new Tipo();
			tipo.setId(Long.valueOf(id));
			return tipo;
		}
		
		return null;
	}

}

