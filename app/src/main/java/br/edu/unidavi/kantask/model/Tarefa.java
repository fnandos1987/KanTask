package br.edu.unidavi.kantask.model;

import android.support.annotation.NonNull;

import java.util.Date;

public class Tarefa implements Comparable<Tarefa> {

    private Integer id;
    private String descricao;
    private Date prazo;
    private Date dataInicio;
    private Date datatConlusao;
    private Integer prioridade;
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getPrazo() {
        return prazo;
    }

    public void setPrazo(Date prazo) {
        this.prazo = prazo;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDatatConlusao() {
        return datatConlusao;
    }

    public void setDatatConlusao(Date datatConlusao) {
        this.datatConlusao = datatConlusao;
    }

    public Integer getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Integer prioridade) {
        this.prioridade = prioridade;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDescricaoPrioridade(){
        return Prioridade.getById(this.prioridade).getDescricao();
    }

    @Override
    public int compareTo(@NonNull Tarefa o) {
        if (this.prioridade < o.prioridade) {
            return -1;
        }
        if (this.prioridade > o.prioridade) {
            return 1;
        }
        return 0;
    }
}
