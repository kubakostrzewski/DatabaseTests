package model;

import java.util.List;

public class Table {

    protected int id;
    protected String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public static int getObjectId(List<? extends Table> table, Table tableObject){
        return table.get(table.indexOf(tableObject)).getId();
    }
}
