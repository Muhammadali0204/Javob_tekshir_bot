package org.Ali;

public class Admins {
    private String id;

    public Admins(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "org.Max.Admins{" +
                "id='" + id + '\'' +
                '}';
    }
}
