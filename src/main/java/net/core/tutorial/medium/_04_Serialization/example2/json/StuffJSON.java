package net.core.tutorial.medium._04_Serialization.example2.json;


public abstract class StuffJSON {
    private Long id;

    public StuffJSON() {
    }

    public StuffJSON(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
