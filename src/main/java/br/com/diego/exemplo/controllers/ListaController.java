package br.com.diego.exemplo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.diego.exemplo.model.Pessoa;
import br.com.diego.exemplo.service.PessoaService;

@Controller
public class ListaController {
	@Autowired
	PessoaService servico;
	
	@RequestMapping("/lista")
	public String lista(Model model) {		
		Iterable<Pessoa> pessoas = servico.listaTodos();
		model.addAttribute("pessoas", pessoas);	
		return "lista";
	}
	
	@RequestMapping(value="salvar", method=RequestMethod.POST)
	public String salvar(@RequestParam("nome") String nome, @RequestParam("endereco") String endereco, @RequestParam("telefone") String telefone, Model model) {
		Pessoa nova = new Pessoa(nome, telefone, endereco);
		servico.salvar(nova);
		
		
		
		return this.lista(model);
	}
}
