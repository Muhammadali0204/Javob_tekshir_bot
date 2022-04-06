public class Berilgan_javoblar {
    private int test_kodi;
    private String ismi;
    private int toplagan_bali;
    private String username;
    private String id;

    public Berilgan_javoblar(int test_kodi, String ismi, int toplagan_bali, String username, String id) {
        this.test_kodi = test_kodi;
        this.ismi = ismi;
        this.toplagan_bali = toplagan_bali;
        this.username = username;
        this.id = id;
    }

    public Berilgan_javoblar() {
    }

    public int getTest_kodi() {
        return test_kodi;
    }

    public void setTest_kodi(int test_kodi) {
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

    @Override
    public String toString() {
        return "Berilgan_javoblar{" +
                "test_kodi=" + test_kodi +
                ", ismi='" + ismi + '\'' +
                ", toplagan_bali=" + toplagan_bali +
                ", username='" + username + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
