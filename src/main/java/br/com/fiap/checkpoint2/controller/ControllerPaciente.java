package br.com.fiap.checkpoint2.controller;

import br.com.fiap.checkpoint2.dto.paciente.PacienteRequestCreate;
import br.com.fiap.checkpoint2.dto.paciente.PacienteRequestUpdate;
import br.com.fiap.checkpoint2.dto.paciente.PacienteResponse;
import br.com.fiap.checkpoint2.dto.paciente.PacienteResponseCreate;
import br.com.fiap.checkpoint2.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("pacientes")
public class ControllerPaciente {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<PacienteResponseCreate> create(@RequestBody PacienteRequestCreate dto){
        return ResponseEntity.status(201)
                .body(new PacienteResponseCreate()
                        .toDto(pacienteService.criarPaciente(dto)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteResponse> findById(@PathVariable Long id){
        return pacienteService.buscarPorId(id)
                .map(p->new PacienteResponse().toDto(p))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping
    public ResponseEntity<List<PacienteResponse>> findAll(){
        return ResponseEntity.ok(pacienteService.buscarTodosPacientes()
                .stream()
                .map(p->new PacienteResponse().toDto(p))
                .collect(Collectors.toList()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PacienteResponse> update(@PathVariable Long id, @RequestBody PacienteRequestUpdate dto){
        return pacienteService.atualizarPaciente(id, dto)
                .map(p->new PacienteResponse().toDto(p))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        if(pacienteService.deletarPaciente(id)){
            return ResponseEntity.status(204).build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}