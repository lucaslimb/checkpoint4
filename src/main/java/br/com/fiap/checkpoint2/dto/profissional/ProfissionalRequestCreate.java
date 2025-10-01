package br.com.fiap.checkpoint2.dto.profissional;

import br.com.fiap.checkpoint2.model.Profissionais;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProfissionalRequestCreate {
    private String nome;
    private String especialidade;
    private BigDecimal valor_hora;

    public Profissionais toModel(){
        Profissionais profissional = new Profissionais();
        profissional.setNome(this.getNome());
        profissional.setEspecialidade(this.getEspecialidade());
        profissional.setValor_hora(this.valor_hora);
        profissional.setCreated_at(LocalDateTime.now());
        profissional.setUpdated_at(LocalDateTime.now());

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

}
