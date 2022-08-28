package br.com.phcorp.ecommerce.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.phcorp.ecommerce.model.Pedido;

public interface PedidoDAO extends CrudRepository<Pedido, Integer> {
  
}
