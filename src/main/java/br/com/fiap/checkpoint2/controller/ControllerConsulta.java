package br.com.fiap.checkpoint2.controller;

import br.com.fiap.checkpoint2.dto.consulta.ConsultaRequestCreate;
import br.com.fiap.checkpoint2.dto.consulta.ConsultaRequestUpdate;
import br.com.fiap.checkpoint2.dto.consulta.ConsultaResponse;
import br.com.fiap.checkpoint2.model.ConsultaStatus;
import br.com.fiap.checkpoint2.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("consulta")
public class ControllerConsulta {

    @Autowired
    private ConsultaService consultaService;

    @PostMapping
    public ResponseEntity<ConsultaResponse> create(@RequestBody ConsultaRequestCreate dto){
        return ResponseEntity.ok().body(new ConsultaResponse().toDto(consultaService.criarConsulta(dto)));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ConsultaResponse> findById(@PathVariable Long id){
        return consultaService.buscarPorId(id).map(new ConsultaResponse()::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping
    public ResponseEntity<List<ConsultaResponse>> findAll(){
        return ResponseEntity.ok().body(consultaService.buscarTodos().stream().map(
                c -> new ConsultaResponse().toDto(c)
        ).collect(Collectors.toList()));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        if(consultaService.deletarConsulta(id)){
            return ResponseEntity.status(204).build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<ConsultaResponse> update(@PathVariable Long id, @RequestBody ConsultaRequestUpdate dto, @RequestBody ConsultaStatus consultaStatus){
        return consultaService.atualizarConsulta(id, dto, consultaStatus)
                .map(p->new ConsultaResponse().toDto(p))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/query")
    public ResponseEntity<List<ConsultaResponse>> findByStatus(ConsultaStatus consultaStatus){
        return ResponseEntity.ok().body(consultaService.buscarConsultaPorStatus(consultaStatus)
                .stream().map(p->new ConsultaResponse().toDto(p)).collect(Collectors.toList()));
    }

    @GetMapping("/paciente/{id}/")
    public ResponseEntity<List<ConsultaResponse>> findPacienteByIdAndStatus(@PathVariable Long id,  ConsultaStatus consultaStatus){
        return ResponseEntity.ok(consultaService.buscarPorIdPacienteeConsultaStatus(id, consultaStatus)
                .stream().map(p -> new ConsultaResponse().toDto(p)).collect(Collectors.toList()));
    }
    @GetMapping("/profissional/{id}/")
    public ResponseEntity<List<ConsultaResponse>> findProfissionalByIdAndStatus(@PathVariable Long id,  ConsultaStatus consultaStatus){
        return ResponseEntity.ok().body(consultaService.buscarPorProfissionalEStatus(id, consultaStatus)
                .stream().map(new ConsultaResponse()::toDto).collect(Collectors.toList()));
    }
}