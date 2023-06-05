package br.gov.rj.faetec.estoque.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.gov.rj.faetec.estoque.model.Instrumento;
import br.gov.rj.faetec.estoque.repository.Instrumentos;
import br.gov.rj.faetec.estoque.repository.filter.InstrumentoFilter;
import br.gov.rj.faetec.estoque.service.CadastroInstrumentoService;

@Controller
@RequestMapping("/instrumentos")
public class InstrumentosController {

	@Autowired
	private CadastroInstrumentoService cadastroInstrumentoService;
	
	@Autowired
	private Instrumentos instrumentos;
	
	@RequestMapping("/novo")
	public ModelAndView novo(Instrumento instrumento) {
		ModelAndView mv = new ModelAndView("instrumento/CadastroInstrumento");
		return mv;
	}	
	
	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Instrumento  instrumento, BindingResult result, Model model, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(instrumento);
		}
		
		cadastroInstrumentoService.salvar(instrumento);
		attributes.addFlashAttribute("mensagem", "Instrumento salvo com sucesso!");
		return new ModelAndView("redirect:/instrumentos/novo");
	}
	
	@GetMapping
	public ModelAndView pesquisar(InstrumentoFilter instrumentoFilter, BindingResult result) {
		ModelAndView mv = new ModelAndView("instrumento/PesquisaInstrumentos");
		
		mv.addObject("instrumentos", instrumentos.filtrar(instrumentoFilter));
		return mv;
	}
	
}
