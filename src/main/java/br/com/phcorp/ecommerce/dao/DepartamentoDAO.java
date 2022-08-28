package br.com.phcorp.ecommerce.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.phcorp.ecommerce.model.Departamento;

public interface DepartamentoDAO extends CrudRepository<Departamento, Integer>{
  
}
