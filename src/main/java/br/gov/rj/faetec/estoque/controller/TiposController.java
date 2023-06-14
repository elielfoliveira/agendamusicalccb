package br.gov.rj.faetec.estoque.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.gov.rj.faetec.estoque.model.Tipo;
import br.gov.rj.faetec.estoque.service.CadastroTipoService;
import br.gov.rj.faetec.estoque.service.exception.DescricaoTipoJaCadastradoException;


@Controller
public class TiposController {

	@Autowired
	private CadastroTipoService cadastroTipoService;
	
	@RequestMapping("/tipos/novo")
	public ModelAndView novo(Tipo tipo) {
		return new ModelAndView("tipo/CadastroTipo");
	}
	
	@RequestMapping(value = "/tipos/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Tipo tipo, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(tipo);
		}
		
		try {
			cadastroTipoService.salvar(tipo);
		} catch (DescricaoTipoJaCadastradoException e) {
			result.rejectValue("descricao", e.getMessage(), e.getMessage());
			return novo(tipo);
		}
		
		attributes.addFlashAttribute("mensagem", "Tipo de participante salvo com sucesso");
		return new ModelAndView("redirect:/tipos/novo");
	}
	
	@RequestMapping(value = "/tipos", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody ResponseEntity<?> salvar(@RequestBody @Valid Tipo tipo, BindingResult result) {
		if (result.hasErrors()) {
			return ResponseEntity.badRequest().body(result.getFieldError("descricao").getDefaultMessage());
		}
		
		try {
			tipo = cadastroTipoService.salvar(tipo);
		} catch (DescricaoTipoJaCadastradoException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
		return ResponseEntity.ok(tipo);
	}
		
}
