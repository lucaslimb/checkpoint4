package br.com.fiap.checkpoint2.service;

import br.com.fiap.checkpoint2.dto.profissional.ProfissionalRequestCreate;
import br.com.fiap.checkpoint2.dto.profissional.ProfissionalRequestUpdate;
import br.com.fiap.checkpoint2.model.Profissionais;
import br.com.fiap.checkpoint2.repository.ConsultaRepository;
import br.com.fiap.checkpoint2.repository.PacienteRepository;
import br.com.fiap.checkpoint2.repository.ProfissionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfissionalService {

    @Autowired
    private ProfissionalRepository profissionalRepository;
    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private PacienteRepository pacienteRepository;

    public Profissionais criarProfissional(ProfissionalRequestCreate dto){
        return profissionalRepository.save(dto.toModel());
    }

    public Optional<Profissionais> buscarPorId(Long id){
        return profissionalRepository.findById(id);
    }

    public List<Profissionais> buscarTodos(){
        return profissionalRepository.findAll();
    }

    public Optional<Profissionais> atualizarProfissional(Long id, ProfissionalRequestUpdate dto){
        return profissionalRepository.findById(id)
                .map(p-> profissionalRepository.save(dto.toModel(p)));
    }
    public boolean deletarPaciente(Long id){
        if(profissionalRepository.existsById(id)){
            profissionalRepository.deleteById(id);
            return true;
        }
        return false;
    }
}