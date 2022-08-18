package org.Ali;

public class Tuzgan_savollar {
    private String kodi;
    private String fan_nomi;
    private String haqiqiy_javob;
    private int haqiqiy_javoblar_soni;
    private String id;
    private String username;




    public Tuzgan_savollar(String kodi, String fan_nomi, String haqiqiy_javob, int haqiqiy_javoblar_soni, String id, String username) {
        this.kodi = kodi;
        this.fan_nomi = fan_nomi;
        this.haqiqiy_javob = haqiqiy_javob;
        this.haqiqiy_javoblar_soni= haqiqiy_javoblar_soni;
        this.id = id;
        this.username = username;
    }

    public Tuzgan_savollar() {
    }

    public String getKodi() {
        return kodi;
    }

    public void setKodi(String kodi) {
        this.kodi = kodi;
    }

    public String getFan_nomi() {
        return fan_nomi;
    }

    public void setFan_nomi(String fan_nomi) {
        this.fan_nomi = fan_nomi;
    }

    public String getHaqiqiy_javob() {
        return haqiqiy_javob;
    }

    public void setHaqiqiy_javob(String haqiqiy_javob) {
        this.haqiqiy_javob = haqiqiy_javob;
    }

    public int getHaqiqiy_javoblar_soni() {
        return haqiqiy_javoblar_soni;
    }

    public void setHaqiqiy_javoblar_soni(int haqiqiy_javoblar_soni) {
        this.haqiqiy_javoblar_soni = haqiqiy_javoblar_soni;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return  "❗️Kodi = " + kodi + '\n' +
                "Fan nomi = " + fan_nomi + '\n' +
                "Haqiqiy javob = " + haqiqiy_javob + '\n' +
                "Haqiqiy javoblar soni = " + haqiqiy_javoblar_soni +
                "\nUsername @" + username +
                "\nId = " + id + "❗️\n\n\n";
    }
}
