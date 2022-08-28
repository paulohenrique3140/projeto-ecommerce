package br.com.phcorp.ecommerce.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.phcorp.ecommerce.model.Cliente;

public interface ClienteDAO extends CrudRepository<Cliente, Integer> {
  
}
