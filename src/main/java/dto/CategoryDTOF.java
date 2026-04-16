package dto;

import java.util.List;

public class CategoryDTOF {

    private int id;
    private String name;
    private List<dto.ModelDTOF> models;

    public CategoryDTOF(){

    }

    public CategoryDTOF(int id, String name, List<ModelDTOF> models) {
        this.id = id;
        this.name = name;
        this.models = models;
    }

    public int getId() { return id; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return name;
    }

    public List<ModelDTOF> getModels() { return models; }
}