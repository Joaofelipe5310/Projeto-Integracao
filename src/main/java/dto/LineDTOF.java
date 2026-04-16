package dto;

import java.util.List;

public class LineDTOF {

    private int id;
    private String name;
    private List<CategoryDTOF> categories;

    public LineDTOF(){

    }

    public LineDTOF(int  id, String name, List<CategoryDTOF> categories) {
        this.id = id;
        this.name = name;
        this.categories = categories;

    }

    public int getId(){return id; }

    public String getName() { return name; }

    @Override
    public String toString() {
        return name;
    }

    public List<CategoryDTOF> getCategories() { return categories;}

}