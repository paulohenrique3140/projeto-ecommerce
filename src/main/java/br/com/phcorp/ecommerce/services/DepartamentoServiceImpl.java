package br.com.phcorp.ecommerce.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.phcorp.ecommerce.dao.DepartamentoDAO;
import br.com.phcorp.ecommerce.model.Departamento;

@Service //Todo objeto de servico precisa desta anotacao para que lá no controller possamos fazer sua injeção
public class DepartamentoServiceImpl implements IDepartamentoService {

  /* AUTOWIRED > ferramente do Spring que faz a devida injeção de dependencias
   "ei JVM, preciso de algum objeto que implementa esta interface"
   Ele não vai encontrar e vai procurar no Crud Repository
   Vai encontrar a implementação que gera os SQLs em tempo real!!!
   evita de eu precisar de um objeto que implemente os metodos da interface DepartamentoDAO */  
  @Autowired
  private DepartamentoDAO dao;

  @Override
  public Departamento criarNovo(Departamento novo) {
    if (novo.getNome() != null) { //validando se o atributo nome da classe Departamento nao esta vazia
      return dao.save(novo); //salva um novo registro em departamento
    }
    return null;
  }

  @Override
  public Departamento atualizarDados(Departamento dados) {
    if (dados.getCodigo() != null && dados.getNome() != null) {
      return dao.save(dados); //A diferenca do save do PUT para o GET eh que no PUT existe a presenca da 
                        // primary key, inserida para localizar qual elemento sera alterado
                        // se existe primary key, o update eh feito
                        // se nao existe primary key, o insert eh feito
    } 
    return null;
  }

  @Override
  public ArrayList<Departamento> buscarTodos() {
    
    return (ArrayList<Departamento>)dao.findAll();//Aqui estou fazendo uma conversao forçada para que o dao.findAll busque tudo o que estiver no ArrayList
    // atraves do metodo findAll() do CRUD Repository, eu estou inserindo todos os objetos da classe departamento no ArrayList de Departamento "lista"
    
  }

  @Override
  public Departamento buscarPeloId(Integer id) {
    //busca pela primary key, caso nao encontre (orElse), retorna null
    return dao.findById(id).orElse(null);
  }

  @Override
  public void excluirDepartamento(Integer id) {
    //busca pela primary key e faz a exclusao, caso nao encontre (orElse), retorna null
    dao.deleteById(id);
  }
  
}
