import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static void clearScreen() {
        try {
            if (System.getProperty("os.name").toLowerCase().contains("windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Gagal membersihkan layar.");
        }
    }

    private static void showLoading(String message, int duration) {
        try {
            System.out.print(message);
            for (int i = 0; i < duration; i++) {
                System.out.print(".");
                Thread.sleep(500); // Tunggu 500ms setiap titik
            }
            System.out.println();
        } catch (InterruptedException e) {
            System.out.println("Loading terganggu.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Mahasiswa> daftarMahasiswa = new ArrayList<>();

        clearScreen();
        System.out.println("======================================");
        System.out.println("=== Program Input Data Mahasiswa ===");
        System.out.println("======================================");

        System.out.print("Berapa mahasiswa yang mau diinput: ");
        int jumlahMahasiswa = readInt(scanner);
        System.out.println("======================================");

        for (int i = 0; i < jumlahMahasiswa; i++) {
            clearScreen();
            System.out.println();
            System.out.println("======================================");
            System.out.println("Input mahasiswa ke-" + (i + 1));
            System.out.println("======================================");

            while (true) {
                try {
                    System.out.println("Pilih tipe mahasiswa:");
                    System.out.print("1 = Reguler\n2 = Beasiswa\nPilihan Anda: ");
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

                    System.out.println("======================================");
                    System.out.println("Masukkan mata kuliah untuk mahasiswa ini.");
                    System.out.println("Ketik 'done' jika selesai.");
                    System.out.println("======================================");

                    while (true) {
                        System.out.print("Masukkan mata kuliah: ");
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

        clearScreen();
        showLoading("Memuat data mahasiswa", 5);
        System.out.println("======================================");
        System.out.println("          Data Semua Mahasiswa        ");
        System.out.println("======================================");

        for (Mahasiswa mahasiswa : daftarMahasiswa) {
            System.out.println();
            mahasiswa.printRingkas();
            System.out.println("======================================");
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