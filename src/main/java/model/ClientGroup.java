package model;

public class ClientGroup extends Table{
    public ClientGroup() {
    }
    public ClientGroup(String name) {
        this.name = name;
    }
    public ClientGroup(int id, String name) {
        this.id = id;
        this.name = name;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof ClientGroup) {
            ClientGroup clientGroup = (ClientGroup) obj;
            return name.equals(clientGroup.name);
        }
        return false;
    }
}
