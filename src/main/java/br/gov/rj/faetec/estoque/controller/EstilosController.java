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

import br.gov.rj.faetec.estoque.model.Estilo;
import br.gov.rj.faetec.estoque.service.CadastroEstiloService;
import br.gov.rj.faetec.estoque.service.exception.NomeEstiloJaCadastradoException;


@Controller
public class EstilosController {

	@Autowired
	private CadastroEstiloService cadastroEstiloService;
	
	@RequestMapping("/estilos/novo")
	public ModelAndView novo(Estilo estilo) {
		return new ModelAndView("estilo/CadastroEstilo");
	}
	
	@RequestMapping(value = "/estilos/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Estilo estilo, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(estilo);
		}
		
		try {
			cadastroEstiloService.salvar(estilo);
		} catch (NomeEstiloJaCadastradoException e) {
			result.rejectValue("nome", e.getMessage(), e.getMessage());
			return novo(estilo);
		}
		
		attributes.addFlashAttribute("mensagem", "Estilo salvo com sucesso");
		return new ModelAndView("redirect:/estilos/novo");
	}
	
	@RequestMapping(value = "/estilos", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody ResponseEntity<?> salvar(@RequestBody @Valid Estilo estilo, BindingResult result) {
		if (result.hasErrors()) {
			return ResponseEntity.badRequest().body(result.getFieldError("nome").getDefaultMessage());
		}
		
		try {
			estilo = cadastroEstiloService.salvar(estilo);
		} catch (NomeEstiloJaCadastradoException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
		return ResponseEntity.ok(estilo);
	}
		
}
