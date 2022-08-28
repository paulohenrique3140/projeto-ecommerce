package br.com.phcorp.ecommerce.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.phcorp.ecommerce.dao.EnderecoDAO;
import br.com.phcorp.ecommerce.model.Endereco;

@Service
public class EnderecoServiceImpl implements IEnderecoService {

  @Autowired
  private EnderecoDAO dao;

  @Override
  public ArrayList<Endereco> recuperarTodos() {
    return (ArrayList<Endereco>)dao.findAll();
  }

  @Override
  public Endereco recuperarPeloCodigo(Integer num_seq) {
    return dao.findById(num_seq).orElse(null);
  }

  @Override
  public Endereco cadastrarNovo(Endereco novo) {
    if (novo.getLogradouro() != null){
      return dao.save(novo);
    }
    return null;
  }

  @Override
  public void excluirEndereco(Integer id) {
    dao.deleteById(id);    
  }
  
}
