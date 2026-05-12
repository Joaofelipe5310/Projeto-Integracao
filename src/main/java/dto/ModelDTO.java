package dto;

public class ModelDTO {

    private int id;
    private String name;

    public ModelDTO(){}

    public ModelDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }

    public String getName() { return name; }

    @Override
    public String toString() {
        return name;
    }
}