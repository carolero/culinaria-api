package com.br.zup.culinaria.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.zup.culinaria.models.Receita;
import com.br.zup.culinaria.repositories.ReceitaRepository;

@Service
public class ReceitaService {
	
	@Autowired
	private ReceitaRepository receitaRepository;
	
	public Long pegarQuantidadeDeReceitas() {
		return receitaRepository.count();
	}
	
	public Receita criarReceita(Receita receita) {
		return receitaRepository.save(receita);
	}
	
	public Iterable<Receita> visualizarTodasAsReceitas() {
		return receitaRepository.findAll();
	}
	
	public Receita deletarReceita(int id) {
		Receita receita = buscarReceitaPorId(id);
		if(receita != null) {
			receitaRepository.deleteById(id);
			return receita;
		}
		return receita;
	}
	
	public Receita buscarReceitaPorId(int id) {
		Receita receita;
		try {
			receita = receitaRepository.findById(id).get();
		}
		catch(Exception e) {
			receita = null;
		}
		return receita;
	}
	
	public Receita atualizarReceita(Receita receita) {
		Receita receitaEncontrada = buscarReceitaPorId(receita.getId());
		if(receitaEncontrada != null) {
			receitaRepository.save(receita);
			return receita;
		}
		return receitaEncontrada;
	}

}
