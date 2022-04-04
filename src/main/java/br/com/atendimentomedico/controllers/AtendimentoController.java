package br.com.atendimentomedico.controllers;

import br.com.atendimentomedico.entities.Atendimento;
import br.com.atendimentomedico.entities.Medico;
import br.com.atendimentomedico.entities.Paciente;
import br.com.atendimentomedico.entities.ReceitaMedica;
import br.com.atendimentomedico.repositories.IAtendimentoRepository;
import br.com.atendimentomedico.repositories.IMedicoRepository;
import br.com.atendimentomedico.repositories.IPacienteRepository;
import br.com.atendimentomedico.requests.AtendimentoPostRequest;
import br.com.atendimentomedico.requests.ReceitaMedicaPostRequest;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@Transactional
public class AtendimentoController {
    @Autowired
    private IPacienteRepository pacienteRepository;

    @Autowired
    private IMedicoRepository medicoRepository;

    @Autowired
    private IAtendimentoRepository atendimentoRepository;

    @ApiOperation("Serviço para cadastro de atendimentos.")
    @RequestMapping(value = "/api/atendimentos", method = RequestMethod.POST)
    @CrossOrigin
    public ResponseEntity<String> post(@RequestBody AtendimentoPostRequest request){
        try {
            Optional<Medico> medico = medicoRepository.findById(request.getIdMedico());
            if (medico.isEmpty())
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body("Médico não encontrado.");

            Optional<Paciente> paciente = pacienteRepository.findById(request.getIdPaciente());
            if (paciente.isEmpty())
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body("Paciente não encontrado");

            Atendimento atendimento = new Atendimento();

            atendimento.setDataHora(request.getDataHora());
            atendimento.setMedico(medico.get());
            atendimento.setPaciente(paciente.get());

            List<ReceitaMedica> receitas = new ArrayList<ReceitaMedica>();
            for (ReceitaMedicaPostRequest item : request.getReceitas()){
                ReceitaMedica receitaMedica = new ReceitaMedica();

                receitaMedica.setMedicamento(item.getMedicamento());
                receitaMedica.setPrescricao(item.getPrescricao());

                receitas.add(receitaMedica);
            }

            atendimento.setReceitas(receitas);
            atendimentoRepository.save(atendimento);

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("Atendimento cadastrado com sucesso!!!");
        }
        catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }


    @ApiOperation("Serviço para consulta de atendimentos")
    @RequestMapping(value = "/api/atendimentos", method = RequestMethod.GET)

    @CrossOrigin
    public ResponseEntity<List<Atendimento>> getAll(){
        try {
            List<Atendimento> atendimentos = atendimentoRepository.findAll();

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(atendimentos);
        }
        catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }
}
