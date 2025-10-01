package br.com.fiap.checkpoint2.controller;

import br.com.fiap.checkpoint2.dto.profissional.ProfissionalRequestCreate;
import br.com.fiap.checkpoint2.dto.profissional.ProfissionalRequestUpdate;
import br.com.fiap.checkpoint2.dto.profissional.ProfissionalResponse;
import br.com.fiap.checkpoint2.dto.profissional.ProfissionalResponseCreate;
import br.com.fiap.checkpoint2.service.ProfissionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("profissionais")
public class ControllerProfissional {
    @Autowired
    private ProfissionalService profissionalService;

    @PostMapping
    public ResponseEntity<ProfissionalResponseCreate> create(@RequestBody ProfissionalRequestCreate dto){
        return ResponseEntity.status(201).body(new ProfissionalResponseCreate()
                .toDto(profissionalService.criarProfissional(dto)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfissionalResponse> findById(@PathVariable Long id){
        return profissionalService.buscarPorId(id)
                .map(p-> new ProfissionalResponse().toDto(p))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping
    public ResponseEntity<List<ProfissionalResponse>> findAll(){
        return ResponseEntity.ok(profissionalService.buscarTodos()
                .stream().map(p-> new ProfissionalResponse().toDto(p))
                .collect(Collectors.toList()));
    }
//

    @PutMapping("/{id}")
    public ResponseEntity<ProfissionalResponse> update(@PathVariable Long id, @RequestBody ProfissionalRequestUpdate dto){
        return profissionalService.atualizarProfissional(id, dto)
                .map(p-> new ProfissionalResponse().toDto(p))
                .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        if(profissionalService.deletarPaciente(id)){
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}