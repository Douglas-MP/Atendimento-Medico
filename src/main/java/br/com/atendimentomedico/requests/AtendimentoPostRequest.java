package br.com.atendimentomedico.requests;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class AtendimentoPostRequest {
    private Date dataHora;
    private Integer idMedico;
    private Integer idPaciente;
    private List<ReceitaMedicaPostRequest> receitas;
}
