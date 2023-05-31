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

import br.gov.rj.faetec.estoque.model.Regional;
import br.gov.rj.faetec.estoque.repository.Regionais;
import br.gov.rj.faetec.estoque.repository.filter.RegionalFilter;
import br.gov.rj.faetec.estoque.service.CadastroRegionalService;
@Controller
@RequestMapping("/regionais")
public class RegionaisController {

	@Autowired
	private CadastroRegionalService cadastroRegionalService;
	
	@Autowired
	private Regionais regionais;
	
	@RequestMapping("/novo")
	public ModelAndView novo(Regional regional) {
		ModelAndView mv = new ModelAndView("regional/CadastroRegional");
		return mv;
	}	
	
	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Regional regional, BindingResult result, Model model, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(regional);
		}
		
		cadastroRegionalService.salvar(regional);
		attributes.addFlashAttribute("mensagem", "Encarregado regional salvo com sucesso!");
		return new ModelAndView("redirect:/regionais/novo");
	}
	
	@GetMapping
	public ModelAndView pesquisar(RegionalFilter regionalFilter, BindingResult result) {
		ModelAndView mv = new ModelAndView("regional/PesquisaRegionais");
		mv.addObject("regionais", regionais.filtrar(regionalFilter));
		return mv;
	}
	
}
