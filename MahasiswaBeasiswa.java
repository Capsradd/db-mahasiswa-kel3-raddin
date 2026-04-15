public class MahasiswaBeasiswa extends Mahasiswa {
    private static final double UKT_NORMAL = 5_000_000;

    private double persenPotongan;

    public MahasiswaBeasiswa(String nim, String nama, double ipk, double persenPotongan) {
        super(nim, nama, ipk);
        setPersenPotongan(persenPotongan);
    }

    public double getPersenPotongan() {
        return persenPotongan;
    }

    public void setPersenPotongan(double persenPotongan) {
        if (persenPotongan < 0.0 || persenPotongan > 100.0) {
            throw new IllegalArgumentException("Persen potongan harus berada pada rentang 0 sampai 100.");
        }
        this.persenPotongan = persenPotongan;
    }

    @Override
    public double hitungUKT() {
        return UKT_NORMAL * (1 - persenPotongan / 100.0);
    }
}