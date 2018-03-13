package br.com.diego.exemplo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.diego.exemplo.model.Pessoa;
import br.com.diego.exemplo.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	PessoaRepository pessoaRepository;
	
	public Iterable<Pessoa> listaTodos(){		
		return pessoaRepository.findAll();
	}
	
	public void salvar(Pessoa pessoa) {
		pessoaRepository.save(pessoa);
	}
	
}
