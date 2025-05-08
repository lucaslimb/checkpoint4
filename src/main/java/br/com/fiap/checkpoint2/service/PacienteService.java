package br.com.fiap.checkpoint2.service;

import br.com.fiap.checkpoint2.dto.paciente.PacienteRequestCreate;
import br.com.fiap.checkpoint2.dto.paciente.PacienteRequestUpdate;
import br.com.fiap.checkpoint2.model.Paciente;
import br.com.fiap.checkpoint2.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public Paciente createPaciente(PacienteRequestCreate dto) {
        return pacienteRepository.save(dto.toModel());
    }

    public Optional<Paciente> updatePaciente(
            Long id, PacienteRequestUpdate dto) {

        return pacienteRepository.findById(id)
                .map(p -> pacienteRepository.save(dto.toModel(p)));
    }

    public Optional<Paciente> getPacienteById(Long id) {
        return pacienteRepository.findById(id);
    }

    public List<Paciente> getAll() {
        return pacienteRepository.findAll();
    }

    public boolean deletePaciente(Long id) {
        if (pacienteRepository.existsById(id)) {
            pacienteRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}
