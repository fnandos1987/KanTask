package br.edu.unidavi.kantask.model;

import android.support.annotation.NonNull;

import java.util.Date;

public class Tarefa implements Comparable<Tarefa> {

    private Integer id;
    private String descricao;
    private String prazo;
    private String dataInicio;
    private String dataConlusao;
    private Integer prioridade;
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return "Tarefa: " + descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPrazo() {
        return "Prazo Conclusão: " + prazo;
    }

    public void setPrazo(String prazo) {
        this.prazo = prazo;
    }

    public String getDataInicio() {
        return "Data Início: " + dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataConlusao() {
        return "Data Conclusão: " + dataConlusao;
    }

    public void setDataConlusao(String dataConlusao) {
        this.dataConlusao = dataConlusao;
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
        return "Prioridade: " + Prioridade.getById(this.prioridade).getDescricao();
    }

    public String getDescricaoStatus(){
        return Status.getById(this.status).getDescricao();
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
