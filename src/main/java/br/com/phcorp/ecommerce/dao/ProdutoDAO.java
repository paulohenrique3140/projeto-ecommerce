package br.com.phcorp.ecommerce.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.phcorp.ecommerce.model.Produto;

public interface ProdutoDAO extends CrudRepository<Produto, Integer> {
  
}
