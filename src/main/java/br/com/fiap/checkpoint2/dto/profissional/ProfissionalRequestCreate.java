package br.com.fiap.checkpoint2.dto.profissional;

import br.com.fiap.checkpoint2.model.Paciente;
import br.com.fiap.checkpoint2.model.Profissional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProfissionalRequestCreate {

    private String nome;
    private String especialidade;
    private BigDecimal valor_hora;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public Profissional toModel(){
        Profissional profissional = new Profissional();
        profissional.setNome(this.nome);
        profissional.setEspecialidade(this.especialidade);
        profissional.setValor_hora(this.valor_hora);
        profissional.setCreated_at(this.created_at);
        profissional.setUpdated_at(this.updated_at);
        return profissional;
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
