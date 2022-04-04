package br.com.atendimentomedico.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReceitaMedicaPostRequest {
    private String medicamento;
    private String prescricao;
}
