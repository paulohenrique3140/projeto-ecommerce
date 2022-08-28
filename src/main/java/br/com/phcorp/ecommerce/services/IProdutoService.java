package br.com.phcorp.ecommerce.services;

import java.util.ArrayList;

import br.com.phcorp.ecommerce.model.Produto;

public interface IProdutoService {
  
  public ArrayList<Produto> recuperarTodos();
  public Produto recuperarPeloCodigo(Integer codigo);
  public Produto cadastrarNovo(Produto novo);
  public void excluirProduto(Integer id);
}
