package br.com.phcorp.ecommerce.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.phcorp.ecommerce.dao.PedidoDAO;
import br.com.phcorp.ecommerce.model.ItemPedido;
import br.com.phcorp.ecommerce.model.Pedido;

@Service
public class PedidoServiceImpl implements IPedidoService {

  @Autowired
  private PedidoDAO dao;

  @Override
  public Pedido inserirNovoPedido(Pedido novo) {
    //Antes de fazer o save, preciso informar os filhos (itens) à qual pedido eles pertencem
    for (ItemPedido item: novo.getItens()){
      item.setPedido(novo);
    }
    return dao.save(novo);
  }

  @Override
  public Pedido recuperarPeloNumero(Integer numero) {
    return dao.findById(numero).orElse(null);
  }

  @Override
  public void excluirPedido(Integer numero) {
    dao.deleteById(numero);    
  }

  @Override
  public ArrayList<Pedido> buscarTodos() {
    return (ArrayList<Pedido>)dao.findAll();
  }
  
}
