package br.com.atendimentomedico.repositories;

import br.com.atendimentomedico.entities.Atendimento;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAtendimentoRepository extends CrudRepository<Atendimento, Integer> {
    @Query("select a from Atendimento a order by a.dataHora desc")
    List<Atendimento> findAll();
}
