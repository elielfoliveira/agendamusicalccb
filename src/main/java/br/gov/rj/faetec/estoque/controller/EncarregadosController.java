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

import br.gov.rj.faetec.estoque.model.Encarregado;
import br.gov.rj.faetec.estoque.repository.Encarregados;
import br.gov.rj.faetec.estoque.repository.filter.EncarregadoFilter;
import br.gov.rj.faetec.estoque.service.CadastroEncarregadoService;
@Controller
@RequestMapping("/encarregados")
public class EncarregadosController {

	@Autowired
	private CadastroEncarregadoService cadastroEncarregadoService;
	
	@Autowired
	private Encarregados encarregados;
	
	@RequestMapping("/novo")
	public ModelAndView novo(Encarregado encarregado) {
		ModelAndView mv = new ModelAndView("encarregado/CadastroEncarregado");
		return mv;
	}	
	
	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Encarregado encarregado, BindingResult result, Model model, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(encarregado);
		}
		
		cadastroEncarregadoService.salvar(encarregado);
		attributes.addFlashAttribute("mensagem", "Encarregado salvo com sucesso!");
		return new ModelAndView("redirect:/encarregados/novo");
	}
	
	@GetMapping
	public ModelAndView pesquisar(EncarregadoFilter encarregadoFilter, BindingResult result) {
		ModelAndView mv = new ModelAndView("encarregado/PesquisaEncarregados");
		mv.addObject("encarregados", encarregados.filtrar(encarregadoFilter));
		return mv;
	}
	
}
