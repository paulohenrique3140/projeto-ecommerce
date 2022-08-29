package br.com.phcorp.ecommerce.dao;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import br.com.phcorp.ecommerce.model.Cliente;

public interface ClienteDAO extends CrudRepository<Cliente, Integer> {
  public ArrayList<Cliente> findByNomeContaining(String palavraChave);
}
