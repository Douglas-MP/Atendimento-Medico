package br.com.atendimentomedico.repositories;

import br.com.atendimentomedico.entities.ReceitaMedica;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReceitaMedicaRepository extends CrudRepository<ReceitaMedica, Integer> {
}
