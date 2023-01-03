package ams;

import akun.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ManajemenAbsensi {
    public ArrayList<Mahasiswa> mahasiswa;
    public ManajemenAbsensi() {
        this.mahasiswa = new ArrayList<Mahasiswa>();
    }
    public void tambahMahasiswa(Mahasiswa mhs) {
        mahasiswa.add(mhs);
    }
    public void setAbsenMahasiswa(String email) {
        for (Mahasiswa mhs : mahasiswa) {
            if (mhs.getEmail().equals(email)) {
                mhs.setJumlahAbsen(mhs.getJumlahAbsen() + 1);
                break;
            }
        }
    }
    public void displayListAbsen(){
        for(Mahasiswa mhs : mahasiswa){
            mhs.display();
        }
    }
    public void displayDetailAbsen(String email){
        for(Mahasiswa mhs : mahasiswa){
            if(mhs.getEmail().equals(email)){
                mhs.display();
                break;
            }
        }
    }
    public void cetakLaporan(String fileName){
        try{
            File file = new File(fileName);
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("Nama,NIM,Jumlah Absen");
            bw.newLine();

            for(Mahasiswa mhs : mahasiswa){
                bw.write(mhs.getNama() + "," + mhs.getNim() + "," + mhs.getJumlahAbsen());
                bw.newLine();
            }

            bw.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
