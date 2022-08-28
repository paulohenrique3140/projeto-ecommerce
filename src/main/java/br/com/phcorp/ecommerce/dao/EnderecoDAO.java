package br.com.phcorp.ecommerce.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.phcorp.ecommerce.model.Endereco;

public interface EnderecoDAO extends CrudRepository<Endereco, Integer>{
  
}
