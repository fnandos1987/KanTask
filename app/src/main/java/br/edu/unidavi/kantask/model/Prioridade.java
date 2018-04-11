package br.edu.unidavi.kantask.model;

public enum Prioridade {

    ALTA(1, "Alta"),
    MEDIA(2, "Média"),
    NORMAL(3, "Normal");

    private final Integer id;
    private final String descricao;

    Prioridade(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public static Prioridade getById(Integer id) {
        for (Prioridade e : values()) {
            if (e.id.equals(id)) {
                return e;
            }
        }
        return NORMAL;
    }

    public Integer getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }
}
