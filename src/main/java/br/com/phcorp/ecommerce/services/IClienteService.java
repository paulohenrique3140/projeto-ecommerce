package br.com.phcorp.ecommerce.services;

import java.util.ArrayList;

import br.com.phcorp.ecommerce.model.Cliente;

public interface IClienteService {
  public ArrayList<Cliente> buscarTodos();
  public Cliente buscarPorId(Integer id);
  public Cliente criarNovo(Cliente novo);
  public Cliente atualizarDados(Cliente dados);
  public void excluirCadastro(Integer id);
  public ArrayList<Cliente> buscarPorNome(String palavraChave);
}
