package br.com.fiap.checkpoint2.dto.consulta;

import br.com.fiap.checkpoint2.model.ConsultaStatus;
import br.com.fiap.checkpoint2.model.Consultas;
import br.com.fiap.checkpoint2.model.Pacientes;
import br.com.fiap.checkpoint2.model.Profissionais;
import br.com.fiap.checkpoint2.repository.PacienteRepository;
import br.com.fiap.checkpoint2.repository.ProfissionalRepository;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

public class ConsultaRequestCreate {
    private Long profissional_id;
    private Long paciente_id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime data_consulta;
    private BigInteger quantidade_horas;
    private BigDecimal valor_consulta;

    public Consultas toModel(ProfissionalRepository profissionalRepository, PacienteRepository pacienteRepository){
        Consultas consulta = new Consultas();
        Profissionais profissionais = profissionalRepository.findById(this.getProfissional_id())
                .orElseThrow(() ->
                        new RuntimeException("Profissional inexistente: " + this.getProfissional_id()));
        consulta.setProfissional(profissionais);
        Pacientes pacientes = pacienteRepository.findById(this.getPaciente_id()).orElseThrow(() ->
                new RuntimeException("Paciente inexistente: " + this.getPaciente_id()));
        consulta.setPaciente(pacientes);
        consulta.setData_consulta(this.getData_consulta());
        consulta.setStatus(ConsultaStatus.AGENDADA);
        consulta.setValor_consulta(this.getValor_consulta());
        consulta.setQuantidade_horas(this.getQuantidade_horas());
        consulta.setCreated_at(LocalDateTime.now());
        consulta.setUpdated_at(LocalDateTime.now());
        return consulta;
    }
    public Long getProfissional_id() {
        return profissional_id;
    }

    public void setProfissional_id(Long profissional_id) {
        this.profissional_id = profissional_id;
    }

    public Long getPaciente_id() {
        return paciente_id;
    }

    public void setPaciente_id(Long paciente_id) {
        this.paciente_id = paciente_id;
    }

    public LocalDateTime getData_consulta() {
        return data_consulta;
    }

    public void setData_consulta(LocalDateTime data_consulta) {
        this.data_consulta = data_consulta;
    }

    public BigInteger getQuantidade_horas() {
        return quantidade_horas;
    }

    public void setQuantidade_horas(BigInteger quantidade_horas) {
        this.quantidade_horas = quantidade_horas;
    }

    public BigDecimal getValor_consulta() {
        return valor_consulta;
    }

    public void setValor_consulta(BigDecimal valor_consulta) {
        this.valor_consulta = valor_consulta;
    }
}