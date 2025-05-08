package br.com.fiap.checkpoint2.dto.profissional;

import br.com.fiap.checkpoint2.dto.paciente.PacienteResponse;
import br.com.fiap.checkpoint2.model.Paciente;
import br.com.fiap.checkpoint2.model.Profissional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProfissionalResponse {

    private Long id;
    private String nome;
    private String especialidade;
    private BigDecimal valor_hora;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public ProfissionalResponse toDto(Profissional profissional){
        this.setId(profissional.getId());
        this.setNome(profissional.getNome());
        this.setEspecialidade(profissional.getEspecialidade());
        this.setValor_hora(profissional.getValor_hora());
        this.setCreated_at(profissional.getCreated_at());
        this.setUpdated_at(profissional.getUpdated_at());
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public BigDecimal getValor_hora() {
        return valor_hora;
    }

    public void setValor_hora(BigDecimal valor_hora) {
        this.valor_hora = valor_hora;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

}
