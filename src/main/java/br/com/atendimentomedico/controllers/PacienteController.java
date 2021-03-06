package br.com.atendimentomedico.controllers;

import br.com.atendimentomedico.entities.Paciente;
import br.com.atendimentomedico.repositories.IPacienteRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.transaction.Transactional;
import java.util.List;

@Controller
@Transactional
public class PacienteController {
    @Autowired
    private IPacienteRepository pacienteRepository;

    @ApiOperation("Serviço para consulta de pacientes.")
    @RequestMapping(value = "/api/pacientes", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public ResponseEntity<List<Paciente>> getAll(){
        try {
            List<Paciente> pacientes = pacienteRepository.findAll();

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(pacientes);
        }
        catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }
}
