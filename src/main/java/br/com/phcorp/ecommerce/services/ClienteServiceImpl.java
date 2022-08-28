package br.com.phcorp.ecommerce.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
  
import br.com.phcorp.ecommerce.dao.ClienteDAO;
import br.com.phcorp.ecommerce.model.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService{

  @Autowired
  private ClienteDAO dao;

  @Override
  public ArrayList<Cliente> buscarTodos() {
    return (ArrayList<Cliente>)dao.findAll();
  }

  @Override
  public Cliente buscarPorId(Integer id) {
    return dao.findById(id).orElse(null);
  }

  @Override
  public Cliente criarNovo(Cliente novo) {
    if (novo.getNome() != null){
      return dao.save(novo);
    }
    return null;
  }

  @Override
  public Cliente atualizarDados(Cliente dados) {
    if (dados.getId() != null && dados.getNome() != null){
    return dao.save(dados);
    }
    return null;
  }

  @Override
  public void excluirCadastro(Integer id) {
    dao.deleteById(id);
  }
  
}
