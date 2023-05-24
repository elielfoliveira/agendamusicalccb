package br.gov.rj.faetec.estoque.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.gov.rj.faetec.estoque.service.CadastroProdutoService;

@Configuration // Trata-se de uma classe de configuração
@ComponentScan(basePackageClasses = CadastroProdutoService.class) // Onde deverá ser procurado 
public class ServiceConfig {                                      // os componentes desta classe

}
