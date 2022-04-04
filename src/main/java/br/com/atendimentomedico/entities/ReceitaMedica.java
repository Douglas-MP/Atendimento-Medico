package br.com.atendimentomedico.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class ReceitaMedica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idReceitaMedica;

    @Column(nullable = false, length = 250)
    private String medicamento;

    @Column(nullable = false, length = 500)
    private String prescricao;
}
