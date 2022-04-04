package br.com.atendimentomedico.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Atendimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idAtendimento;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date dataHora;

    @ManyToOne
    @JoinColumn(name = "idMedico", nullable = false)
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "idPaciente", nullable = false)
    private Paciente paciente;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "atendimento_receitaMedica",
            joinColumns = @JoinColumn
                    (name = "idAtendimento", nullable = false),
            inverseJoinColumns = @JoinColumn
                    (name = "idReceitaMedica", nullable = false))
    private List<ReceitaMedica> receitas;

}
