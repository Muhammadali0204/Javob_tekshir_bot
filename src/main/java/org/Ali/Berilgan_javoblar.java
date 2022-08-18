package org.Ali;

public class Berilgan_javoblar {
    private String test_kodi;
    private String ismi;
    private int toplagan_bali;
    private String username;
    private String id;
    private String xato_javoblari;

    public Berilgan_javoblar(String test_kodi, String ismi, int toplagan_bali, String username, String id, String xato_javoblari) {
        this.test_kodi = test_kodi;
        this.ismi = ismi;
        this.toplagan_bali = toplagan_bali;
        this.username = username;
        this.id = id;
        this.xato_javoblari = xato_javoblari;
    }

    public Berilgan_javoblar() {
    }

    public String getTest_kodi() {
        return test_kodi;
    }

    public void setTest_kodi(String test_kodi) {
        this.test_kodi = test_kodi;
    }

    public String getIsmi() {
        return ismi;
    }

    public void setIsmi(String ismi) {
        this.ismi = ismi;
    }

    public int getToplagan_bali() {
        return toplagan_bali;
    }

    public void setToplagan_bali(int toplagan_bali) {
        this.toplagan_bali = toplagan_bali;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getXato_javoblari() {
        return xato_javoblari;
    }

    public void setXato_javoblari(String xato_javoblari) {
        this.xato_javoblari = xato_javoblari;
    }

    @Override
    public String toString() {
        return  "❗️Test kodi= " + test_kodi + '\n' +
                "Ismi = " + ismi + '\n' +
                "Toplagan bali = " + toplagan_bali +
                "\nUsername = @" + username + '\n' +
                "Id = " + id + "❗️\n\n\n";
    }
}
