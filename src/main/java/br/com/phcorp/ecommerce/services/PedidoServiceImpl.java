package br.com.phcorp.ecommerce.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.phcorp.ecommerce.dao.PedidoDAO;
import br.com.phcorp.ecommerce.dao.ProdutoDAO;
import br.com.phcorp.ecommerce.model.ItemPedido;
import br.com.phcorp.ecommerce.model.Pedido;
import br.com.phcorp.ecommerce.model.Produto;



@Service
public class PedidoServiceImpl implements IPedidoService {

  @Autowired
  private PedidoDAO dao;
  
  @Autowired
  private ProdutoDAO daoProd;

  @Override
  public Pedido inserirNovoPedido(Pedido novo) {
    //Antes de fazer o save, preciso informar os filhos (itens) à qual pedido eles pertencem
    Integer quantidade = 0;
    Double valorBruto = 0.0;
    Double desconto = 0.0;
    Double somaBruta = 0.0;
    Double somaDesconto = 0.0;
    for (ItemPedido item: novo.getItens()){
      Produto produto = daoProd.encontrarPorId(item.getProduto().getCodigo());
      valorBruto = item.getQuantidade() * produto.getPreco();
      if (item.getQuantidade() > 5){
          desconto = 0.2 * valorBruto;
          somaDesconto += desconto;
       }
      quantidade += item.getQuantidade();
      somaBruta += valorBruto;
      try {
        if (item.getQuantidade() > 0 && item.getQuantidade() <= produto.getEstoque()){
          item.setPedido(novo);
          produto.setEstoque(produto.getEstoque() - item.getQuantidade());
         }
      } catch (Exception e){
        return null;
      }
    }
    novo.setDesconto(somaDesconto);
    novo.setValorBruto(somaBruta);
    novo.setValorFinal(novo.getValorBruto()-novo.getDesconto());

    if (quantidade > 0){
      return dao.save(novo);
    } else {
      return null;
    }
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
