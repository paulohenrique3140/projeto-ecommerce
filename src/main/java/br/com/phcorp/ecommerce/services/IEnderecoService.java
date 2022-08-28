package br.com.phcorp.ecommerce.services;

import java.util.ArrayList;

import br.com.phcorp.ecommerce.model.Endereco;

public interface IEnderecoService {
  public ArrayList<Endereco> recuperarTodos();
  public Endereco recuperarPeloCodigo(Integer num_seq);
  public Endereco cadastrarNovo(Endereco novo);
  public void excluirEndereco(Integer id);
  public Endereco atualizarEndereco(Endereco dados);
}
