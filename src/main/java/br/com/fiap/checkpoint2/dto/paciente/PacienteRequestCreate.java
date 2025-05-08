package br.com.fiap.checkpoint2.dto.paciente;

import br.com.fiap.checkpoint2.model.Paciente;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PacienteRequestCreate {

    private String nome;
    private String endereco;
    private String bairro;
    private String email;
    private String telefone_completo;
    private LocalDate data_nascimento;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public Paciente toModel(){
        Paciente paciente = new Paciente();
        paciente.setNome(this.nome);
        paciente.setEndereco(this.endereco);
        paciente.setBairro(this.bairro);
        paciente.setEmail(this.email);
        paciente.setTelefone_completo(this.telefone_completo);
        paciente.setData_nascimento(this.data_nascimento);
        paciente.setCreated_at(this.created_at);
        paciente.setUpdated_at(this.updated_at);
        return paciente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone_completo() {
        return telefone_completo;
    }

    public void setTelefone_completo(String telefone_completo) {
        this.telefone_completo = telefone_completo;
    }

    public LocalDate getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(LocalDate data_nascimento) {
        this.data_nascimento = data_nascimento;
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
