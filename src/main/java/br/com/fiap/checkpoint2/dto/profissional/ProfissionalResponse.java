package br.com.fiap.checkpoint2.dto.profissional;

import br.com.fiap.checkpoint2.dto.consulta.ConsultaResponse;
import br.com.fiap.checkpoint2.model.Profissionais;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ProfissionalResponse {
    private Long id;
    private String nome;
    private String especialidade;
    private BigDecimal valor_hora;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern =  "dd-MM-yyyy HH:mm")
    private LocalDateTime created_at;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern =  "dd-MM-yyyy HH:mm")
    private LocalDateTime updated_at;
    private List<ConsultaResponse> consultas;


    public ProfissionalResponse toDto(Profissionais profissionais){
        this.setId(profissionais.getId());
        this.setNome(profissionais.getNome());
        this.setEspecialidade(profissionais.getEspecialidade());
        this.setValor_hora(profissionais.getValor_hora());
        this.setCreated_at(profissionais.getCreated_at());
        this.setUpdated_at(profissionais.getUpdated_at());
        List<ConsultaResponse> consultasResponses = profissionais.getConsultas()
                .stream().map(consulta -> new ConsultaResponse().toDto(consulta)).
                collect(Collectors.toList());
        this.setConsultas(consultasResponses);
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

    public List<ConsultaResponse> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<ConsultaResponse> consultasResponses) {
        this.consultas = consultasResponses;
    }
}