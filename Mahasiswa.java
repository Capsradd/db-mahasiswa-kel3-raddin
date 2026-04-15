import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mahasiswa {
    private static final double UKT_NORMAL = 5_000_000;

    private String nim;
    private String nama;
    private double ipk;
    private final List<String> matkulDiambil;

    public Mahasiswa(String nim, String nama, double ipk) {
        this.matkulDiambil = new ArrayList<>();
        setNim(nim);
        setNama(nama);
        setIpk(ipk);
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        if (nim == null || nim.trim().isEmpty()) {
            throw new IllegalArgumentException("NIM tidak boleh kosong.");
        }
        this.nim = nim.trim();
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        if (nama == null || nama.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama tidak boleh kosong.");
        }
        this.nama = nama.trim();
    }

    public double getIpk() {
        return ipk;
    }

    public void setIpk(double ipk) {
        if (ipk < 0.0 || ipk > 4.0) {
            throw new IllegalArgumentException("IPK harus berada pada rentang 0.0 sampai 4.0.");
        }
        this.ipk = ipk;
    }

    public List<String> getMatkulDiambil() {
        return Collections.unmodifiableList(matkulDiambil);
    }

    public void tambahMatkul(String matkul) {
        if (matkul == null || matkul.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama mata kuliah tidak boleh kosong.");
        }

        String matkulBersih = matkul.trim();
        if (matkulDiambil.contains(matkulBersih)) {
            throw new IllegalArgumentException("Mata kuliah tidak boleh duplikat.");
        }

        matkulDiambil.add(matkulBersih);
    }

    public double hitungUKT() {
        return UKT_NORMAL;
    }

    public void printRingkas() {
        System.out.println("NIM: " + nim);
        System.out.println("Nama: " + nama);
        System.out.println("IPK: " + ipk);
        System.out.println("Matkul Diambil: " + (matkulDiambil.isEmpty() ? "-" : String.join(", ", matkulDiambil)));
        System.out.println("UKT: Rp" + String.format("%,.0f", hitungUKT()).replace(',', '.'));
    }
}