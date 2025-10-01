package br.com.fiap.checkpoint2.repository;

import br.com.fiap.checkpoint2.model.Pacientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Pacientes, Long> {

}