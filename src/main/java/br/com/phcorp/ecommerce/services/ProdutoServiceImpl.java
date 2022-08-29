package br.com.phcorp.ecommerce.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.phcorp.ecommerce.dao.ProdutoDAO;
import br.com.phcorp.ecommerce.model.Produto;

@Service
public class ProdutoServiceImpl implements IProdutoService {

  @Autowired
  private ProdutoDAO dao;

  @Override
  public ArrayList<Produto> recuperarTodos() {
    return (ArrayList<Produto>)dao.findAll();
  }

  @Override
  public Produto recuperarPeloCodigo(Integer codigo) {
    return dao.findById(codigo).orElse(null);
  }

  @Override
  public Produto cadastrarNovo(Produto novo) {
    return dao.save(novo);
  }

  @Override
  public Produto atualizarProduto(Produto dados) {
    if (dados.getCodigo() != null && dados.getNome() != null){
      return dao.save(dados);
    }
    return null;
  }

  @Override
  public ArrayList<Produto> ordenarPorPreco() {
    return dao.findByOrderByPreco();
  }
  
}
