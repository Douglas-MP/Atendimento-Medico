package br.com.atendimentomedico.repositories;

import br.com.atendimentomedico.entities.Paciente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPacienteRepository extends CrudRepository<Paciente, Integer> {
    @Query("select p from Paciente p order by p.nome")
    List<Paciente> findAll();
}
