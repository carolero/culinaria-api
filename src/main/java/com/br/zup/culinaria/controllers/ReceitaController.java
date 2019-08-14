package com.br.zup.culinaria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.br.zup.culinaria.models.Receita;
import com.br.zup.culinaria.services.ReceitaService;

@Controller
@RequestMapping("/api/culinaria")
public class ReceitaController {
	
	@Autowired
	private ReceitaService receitaService;
	
	@PostMapping
	public ResponseEntity<?> criarReceita(@RequestBody Receita receita) {
		receitaService.criarReceita(receita);
		return ResponseEntity.status(HttpStatus.CREATED).body(receita);
	}
	
	@GetMapping
	public ResponseEntity<?> visualizarReceitas() {
		if(receitaService.pegarQuantidadeDeReceitas() > 0) {
			return ResponseEntity.ok(receitaService.visualizarTodasAsReceitas());
		}
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarReceita(@PathVariable int id) {
		Receita receita = receitaService.buscarReceitaPorId(id);
		if(receita != null) {
			receitaService.deletarReceita(id);
			return ResponseEntity.ok().body(receita);
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscarReceitaPorId(@PathVariable int id) {
		Receita receita = receitaService.buscarReceitaPorId(id);
		if(receita != null) {
			return ResponseEntity.ok().body(receita);
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping
	public ResponseEntity<?> atualizarReceita(@RequestBody Receita receita) {
		Receita receitaEncontrada = receitaService.atualizarReceita(receita);
		if(receitaEncontrada != null) {
			return ResponseEntity.ok().body(receita);
		}
		return ResponseEntity.notFound().build();
	}
	 

}
