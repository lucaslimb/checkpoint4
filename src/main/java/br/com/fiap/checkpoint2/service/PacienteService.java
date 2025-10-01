package br.com.fiap.checkpoint2.service;

import br.com.fiap.checkpoint2.dto.paciente.PacienteRequestCreate;
import br.com.fiap.checkpoint2.dto.paciente.PacienteRequestUpdate;
import br.com.fiap.checkpoint2.model.Pacientes;
import br.com.fiap.checkpoint2.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;

    public Pacientes criarPaciente(PacienteRequestCreate dto){
        return pacienteRepository.save(dto.toModel());
    }

    public Optional<Pacientes> buscarPorId(Long id){
        return pacienteRepository.findById(id);
    }
    public List<Pacientes> buscarTodosPacientes(){
        return pacienteRepository.findAll();
    }


    public Optional<Pacientes> atualizarPaciente(Long id, PacienteRequestUpdate dto){
        return pacienteRepository.findById(id)
                .map(o-> pacienteRepository.save((dto.toModel(o))));
    }

    public boolean deletarPaciente(Long id){
        if(pacienteRepository.existsById(id)){
            pacienteRepository.deleteById(id);
            return true;
        }
        return false;
    }

}