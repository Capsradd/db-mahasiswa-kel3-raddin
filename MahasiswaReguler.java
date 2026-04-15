public class MahasiswaReguler extends Mahasiswa {
    private static final double UKT_NORMAL = 5_000_000;

    public MahasiswaReguler(String nim, String nama, double ipk) {
        super(nim, nama, ipk);
    }

    @Override
    public double hitungUKT() {
        return UKT_NORMAL;
    }
}