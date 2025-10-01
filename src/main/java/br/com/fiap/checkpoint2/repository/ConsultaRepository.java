package br.com.fiap.checkpoint2.repository;

import br.com.fiap.checkpoint2.model.ConsultaStatus;
import br.com.fiap.checkpoint2.model.Consultas;
import br.com.fiap.checkpoint2.model.Pacientes;
import br.com.fiap.checkpoint2.model.Profissionais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository

public interface ConsultaRepository extends JpaRepository<Consultas, Long> {
    public List<Consultas> findByStatus(ConsultaStatus consultaStatus);
    public List<Consultas> findByProfissionalAndStatus(Profissionais profissionais, ConsultaStatus consultaStatus);
    public List<Consultas> findByPacienteAndStatus(Pacientes pacientes, ConsultaStatus consultaStatus);
}