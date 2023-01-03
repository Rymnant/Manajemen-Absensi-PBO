import akun.*;
import ams.ManajemenAbsensi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RegisSystem rs = new RegisSystem();
        ManajemenAbsensi ma = new ManajemenAbsensi();
        Dosen dosen = new Dosen("Dosen", "Dosen", "Dosen", "123");
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Pilihan: ");
            int pilihan = sc.nextInt();
            sc.nextLine();
            switch (pilihan) {
                case 1:
                    System.out.print("Nama: ");
                    String nama = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Password: ");
                    String password = sc.nextLine();
                    System.out.print("NIM: ");
                    String nim = sc.nextLine();
                    Mahasiswa mhs = new Mahasiswa(nama, email, password, nim);
                    ma.tambahMahasiswa(new Mahasiswa(nama,nim,email,password));
                    rs.register(mhs);
                    break;
                case 2:
                    int pilihanLogin;
                    do{
                        System.out.println("Login sebagai:");
                        System.out.println("1. Mahasiswa");
                        System.out.println("2. Dosen");
                        System.out.println("3. Kembali");
                        System.out.print("Pilihan: ");
                        pilihanLogin = sc.nextInt();
                        sc.nextLine();

                        switch (pilihanLogin){
                            case 1:
                                    System.out.print("Email: ");
                                    email = sc.nextLine();
                                    System.out.print("Password: ");
                                    password = sc.nextLine();

                                    if (rs.login(email, password)) {
                                        System.out.println("Login berhasil");
                                        int pilihan2;
                                        do{
                                            System.out.println("1. Absen");
                                            System.out.println("2. Lihat data");
                                            System.out.println("3. Logout");
                                            System.out.print("Pilihan: ");
                                            pilihan2 = sc.nextInt();
                                            sc.nextLine();
                                            switch (pilihan2) {
                                                case 1:
                                                    ma.setAbsenMahasiswa(email);
                                                    break;
                                                case 2:
                                                    ma.displayDetailAbsen(email);
                                                    break;
                                                case 3:
                                                    break;
                                            }
                                        } while (pilihan2 != 3);
                                    } else {
                                        System.out.println("Login gagal");
                                    }
                                break;
                            case 2:
                                    System.out.println("Email: ");
                                    email = sc.nextLine();
                                    System.out.println("Password: ");
                                    password = sc.nextLine();

                                    if(email.equals(dosen.getEmail()) && password.equals(dosen.getPassword())){
                                        System.out.println("Login berhasil");
                                        int pilihan2;
                                        do{
                                            System.out.println("1. Lihat data");
                                            System.out.println("2. Cetak laporan");
                                            System.out.println("3. Logout");
                                            System.out.print("Pilihan: ");
                                            pilihan2 = sc.nextInt();
                                            sc.nextLine();
                                            switch (pilihan2) {
                                                case 1:
                                                    ma.displayListAbsen();
                                                    break;
                                                case 2:
                                                    System.out.print("Nama file: ");
                                                    String fileName = sc.nextLine();
                                                    ma.cetakLaporan(fileName);
                                                    break;
                                                case 3:
                                                    break;
                                            }
                                        } while (pilihan2 != 3);
                                    } else {
                                        System.out.println("Login gagal");
                                    }
                                break;
                            case 3:
                                break;
                            }
                        } while (pilihanLogin != 3);
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan tidak valid");
            }
        } while (true);
    }
}