package Latihan;

import com.sun.org.apache.xerces.internal.impl.dv.xs.IntegerDV;

public class bola {

    private String id;
    private String nama;
    private String diameter;
    double luas, keliling, volume;

    public bola() {
        this.id = id;
        this.nama = nama;
        this.diameter = diameter;
    }

    public double luas() {
        this.luas = 4 * ((Integer.parseInt(this.diameter) / 2) * (Integer.parseInt(this.diameter) / 2) * 3.14);
        return this.luas;
    }

    public double volume() {
        this.volume = 4 / 3 * ((Integer.parseInt(this.diameter) / 2) * (Integer.parseInt(this.diameter) / 2) * (Integer.parseInt(this.diameter) / 2) * 3.14);
        return this.volume;
    }

    public double keliling() {
        this.keliling = 4 / 3 * ((Integer.parseInt(this.diameter) / 2) * (Integer.parseInt(this.diameter) / 2) * 3.14);
        return this.keliling;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDiameter() {
        return diameter;
    }

    public void setDiameter(String diameter) {
        this.diameter = diameter;
    }

    public double getLuas() {
        return luas;
    }

    public void setLuas(double luas) {
        this.luas = luas;
    }

    public double getKeliling() {
        return keliling;
    }

    public void setKeliling(double keliling) {
        this.keliling = keliling;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

}
