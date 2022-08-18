package org.Ali;

public class Ism_familiya {
    private String ism_familiya;
    private String id;

    public Ism_familiya(String ism_familiya, String id) {
        this.ism_familiya = ism_familiya;
        this.id = id;
    }

    public String getIsm_familiya() {
        return ism_familiya;
    }

    public void setIsm_familiya(String ism_familiya) {
        this.ism_familiya = ism_familiya;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "org.Max.Ism_familiya{" +
                "ism_familiya='" + ism_familiya + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
