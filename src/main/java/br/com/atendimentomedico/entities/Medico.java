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
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idMedico;

    @Column(nullable = false, length = 150)
    private String nome;

    @Column(nullable = false, length = 25, unique = true)
    private String crm;

    @Column(nullable = false, length = 15)
    private String telefone;

    @Column(nullable = false, length = 100)
    private String tipo;
}
