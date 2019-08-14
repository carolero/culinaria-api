package com.br.zup.culinaria.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.zup.culinaria.models.Receita;

@Repository
public interface ReceitaRepository extends CrudRepository<Receita, Integer>{

}
