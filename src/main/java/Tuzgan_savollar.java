public class Tuzgan_savollar {
    private int kodi;
    private String fan_nomi;
    private String haqiqiy_javob;
    private int haqiqiy_javoblar_soni;
    private String id;




    public Tuzgan_savollar(int kodi, String fan_nomi, String haqiqiy_javob, int haqiqiy_javoblar_soni, String id) {
        this.kodi = kodi;
        this.fan_nomi = fan_nomi;
        this.haqiqiy_javob = haqiqiy_javob;
        this.haqiqiy_javoblar_soni= haqiqiy_javoblar_soni;
        this.id = id;
    }

    public Tuzgan_savollar() {
    }

    public int getKodi() {
        return kodi;
    }

    public void setKodi(int kodi) {
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


}
