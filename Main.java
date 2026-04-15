import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Mahasiswa> daftarMahasiswa = new ArrayList<>();

        System.out.print("Berapa mahasiswa yang mau diinput? ");
        int jumlahMahasiswa = readInt(scanner);

        for (int i = 0; i < jumlahMahasiswa; i++) {
            System.out.println();
            System.out.println("Input mahasiswa ke-" + (i + 1));

            while (true) {
                try {
                    System.out.print("Pilih tipe (1=Reguler, 2=Beasiswa): ");
                    int tipe = readInt(scanner);

                    System.out.print("NIM: ");
                    String nim = scanner.nextLine();

                    System.out.print("Nama: ");
                    String nama = scanner.nextLine();

                    System.out.print("IPK: ");
                    double ipk = readDouble(scanner);

                    Mahasiswa mahasiswa;
                    if (tipe == 1) {
                        mahasiswa = new MahasiswaReguler(nim, nama, ipk);
                    } else if (tipe == 2) {
                        System.out.print("Persen potongan beasiswa (0-100): ");
                        double persenPotongan = readDouble(scanner);
                        mahasiswa = new MahasiswaBeasiswa(nim, nama, ipk, persenPotongan);
                    } else {
                        throw new IllegalArgumentException("Tipe mahasiswa harus 1 atau 2.");
                    }

                    while (true) {
                        System.out.print("Masukkan mata kuliah (ketik done untuk selesai): ");
                        String matkul = scanner.nextLine();

                        if (matkul.equalsIgnoreCase("done")) {
                            break;
                        }

                        try {
                            mahasiswa.tambahMatkul(matkul);
                        } catch (IllegalArgumentException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    }

                    daftarMahasiswa.add(mahasiswa);
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                    System.out.println("Silakan input ulang mahasiswa ini.");
                }
            }
        }

        System.out.println();
        System.out.println("=== Data Semua Mahasiswa ===");
        for (Mahasiswa mahasiswa : daftarMahasiswa) {
            System.out.println();
            mahasiswa.printRingkas();
        }
    }

    private static int readInt(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine();
            try {
                return Integer.parseInt(input.trim());
            } catch (NumberFormatException e) {
                System.out.print("Input harus berupa bilangan bulat. Coba lagi: ");
            }
        }
    }

    private static double readDouble(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine();
            try {
                return Double.parseDouble(input.trim());
            } catch (NumberFormatException e) {
                System.out.print("Input harus berupa angka. Coba lagi: ");
            }
        }
    }
}