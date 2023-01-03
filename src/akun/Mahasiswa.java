package akun;
public class Mahasiswa extends User {
    String nim;
    int jumlahAbsen;
    public Mahasiswa(String nama, String email, String password, String nim) {
        super(nama, email, password);
        this.nim = nim;
        this.jumlahAbsen = 0;
    }
    public void display() {
        System.out.println("Nama: " + getNama());
        System.out.println("NIM: " + getNim());
        System.out.println("Jumlah Absen: " + getJumlahAbsen());
    }
    public String getNim() {
        return nim;
    }
    public int getJumlahAbsen() {
        return jumlahAbsen;
    }
    public void setJumlahAbsen(int jumlahAbsen) {
        this.jumlahAbsen = jumlahAbsen;
    }
}
