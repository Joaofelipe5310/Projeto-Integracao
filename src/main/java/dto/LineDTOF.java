package dto;

import java.util.List;

public class LineDTOF {

    private int id;
    private String name;
    private List<CategoryDTOF> cat;

    public LineDTOF(){

    }

    public LineDTOF(int  id, String name, List<CategoryDTOF> cat) {
        this.id = id;
        this.name = name;
        this.cat = cat;

    }

    public int getId(){return id; }

    public String getName() { return name; }

    @Override
    public String toString() {
        return name;
    }

    public List<CategoryDTOF> getCat() { return cat;}

}