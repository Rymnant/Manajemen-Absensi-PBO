package akun;
public class Dosen extends User {
    String nip;
    public Dosen(String nama, String email, String password, String nip) {
        super(nama, email, password);
        this.nip = nip;
    }
}
