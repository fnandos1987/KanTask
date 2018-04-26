package br.edu.unidavi.kantask.model;

public enum Status {

    FAZER(1, "Fazer"),
    FAZENDO(2, "Fazendo"),
    FEITO(3, "Feito");

    private final Integer id;
    private final String descricao;

    Status(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public static Status getById(Integer id) {
        for (Status s : values()) {
            if (s.id.equals(id)) {
                return s;
            }
        }
        return FAZER;
    }

    public Integer getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }
}
