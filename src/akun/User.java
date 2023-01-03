package akun;
public abstract class User {
    String nama;
    String email;
    String password;
    public User(String nama, String email, String password) {
        this.nama = nama;
        this.email = email;
        this.password = password;
    }
    public String getNama() {
        return nama;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
}
