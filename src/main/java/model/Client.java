package model;

public class Client extends Table{

    private int clientGroupId;
    private String city;
    private String country;

    public Client() {
    }

    public Client(int id, String name, int clientGroupId, String city, String country) {
        this.id = id;
        this.name = name;
        this.clientGroupId = clientGroupId;
        this.city = city;
        this.country = country;
    }

    public Client( String name, int clientGroupId, String city, String country) {
        this.name = name;
        this.clientGroupId = clientGroupId;
        this.city = city;
        this.country = country;
    }

    public int getClientGroupId() {
        return clientGroupId;
    }

    public void setClientGroupId(int clientGroupId) {
        this.clientGroupId = clientGroupId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof Client) {
            Client otherClient = (Client) obj;
            return name.equals(otherClient.name) && clientGroupId==otherClient.clientGroupId
                    && city.equals(otherClient.city) && country.equals(otherClient.country) ;
        }
        return false;
    }
}
