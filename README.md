# Database Mahasiswa Kelompok 3

## Tema
Aplikasi sederhana untuk mengelola data mahasiswa, termasuk data reguler dan mahasiswa dengan beasiswa. Aplikasi ini juga mencakup fitur untuk menghitung UKT (Uang Kuliah Tunggal) dan menampilkan informasi mahasiswa.

## Tujuan Pembelajaran
Proyek ini bertujuan untuk menggabungkan semua konsep OOP yang telah dipelajari, yaitu:
- **Class & Object**
- **Encapsulation** (data private + getter/setter + validasi)
- **Inheritance** (superclass & subclass)
- **Polymorphism** (method overriding + runtime polymorphism via reference superclass)

## Struktur Folder
```
db-mahasiswa/
├── Mahasiswa.java                 # Superclass untuk data mahasiswa
├── MahasiswaReguler.java          # Subclass untuk mahasiswa reguler
├── MahasiswaBeasiswa.java         # Subclass untuk mahasiswa dengan beasiswa
└── Main.java                      # Program utama untuk demo aplikasi
```

## Spesifikasi Detail

### 1. Class `Mahasiswa` (Superclass)

- **Atribut** (private):
  - `String nim`
  - `String nama`
  - `double ipk`
  - `List<String> matkulDiambil`

- **Constructor**:
  - Menerima `nim`, `nama`, dan `ipk`

- **Method**:
  - `void tambahMatkul(String matkul)`  
    → Menambahkan mata kuliah ke daftar jika belum ada
  - `double hitungUKT()`  
    → Mengembalikan nilai UKT default (Rp 5.000.000)
  - `void printRingkas()`  
    → Menampilkan informasi ringkas mahasiswa

### 2. Subclass

| Class               | Atribut tambahan       | Override `hitungUKT()` tambahan |
|---------------------|------------------------|----------------------------------|
| `MahasiswaReguler`  | Tidak ada              | UKT tetap Rp 5.000.000          |
| `MahasiswaBeasiswa` | `double persenPotongan`| Hitung UKT dengan potongan      |

### 3. Di `Main.java` (Demo)

Buat simulasi berikut:

1. Input data mahasiswa:
   - Pilih tipe mahasiswa (Reguler atau Beasiswa)
   - Masukkan NIM, Nama, IPK, dan mata kuliah yang diambil

2. Tampilkan daftar semua mahasiswa beserta statusnya

3. Simulasi proses perhitungan UKT:
   - Mahasiswa reguler memiliki UKT tetap
   - Mahasiswa beasiswa memiliki UKT berdasarkan potongan

4. Tampilkan informasi ringkas mahasiswa menggunakan polymorphism

## Kelompok 3
Tambahkan nama anggota kelompok di sini:
- David Alif
- Dafa Agasya
- Deff Rasya Islami
- M. Farhan Fauzi Akbar
- Elsa Aulia
- Intan Khalimatu
- Raddin Pratama Rachmat
