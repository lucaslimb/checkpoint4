package br.com.fiap.checkpoint2.controller;

import br.com.fiap.checkpoint2.dto.paciente.PacienteRequestCreate;
import br.com.fiap.checkpoint2.dto.paciente.PacienteRequestUpdate;
import br.com.fiap.checkpoint2.dto.paciente.PacienteResponse;
import br.com.fiap.checkpoint2.model.Paciente;
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
    public ResponseEntity<PacienteResponse> create(
            @RequestBody PacienteRequestCreate dto) {

        return ResponseEntity.status(201).body(
                new PacienteResponse().toDto(
                        pacienteService.createPaciente(dto)
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean result = pacienteService.deletePaciente(id);

        if (result) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<PacienteResponse>
    update(@PathVariable Long id, @RequestBody PacienteRequestUpdate dto) {

        return pacienteService.updatePaciente(id, dto)
                .map(p-> new PacienteResponse().toDto(p))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteResponse> findById(@PathVariable Long id) {
        return pacienteService.getPacienteById(id)
                .map(p-> new PacienteResponse().toDto(p))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<PacienteResponse>> findAll() {
        List<PacienteResponse> response =
                pacienteService.getAll().stream()
                        .map(p-> new PacienteResponse().toDto(p))
                        .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

}
