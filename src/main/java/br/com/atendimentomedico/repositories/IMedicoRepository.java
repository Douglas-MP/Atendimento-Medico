package br.com.atendimentomedico.repositories;

import br.com.atendimentomedico.entities.Medico;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMedicoRepository extends CrudRepository<Medico, Integer> {
    @Query("select m from Medico m order by m.nome")
    List<Medico> findAll();
}
