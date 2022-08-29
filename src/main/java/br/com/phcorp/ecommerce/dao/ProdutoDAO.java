package br.com.phcorp.ecommerce.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.phcorp.ecommerce.model.Produto;

public interface ProdutoDAO extends CrudRepository<Produto, Integer> {
  //QUERYS CUSTOMIZADAS SAO FEITAS NO DAO
  public ArrayList<Produto> findByOrderByPreco();
  @Query("SELECT p FROM Produto p WHERE p.codigo = ?1")
	public Produto encontrarPorId(Integer id);
}
