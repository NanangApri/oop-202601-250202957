# Catatan Minggu 06: UML dan SOLID

---
## Tujuan

> - Memodelkan sistem dengan Class Diagram dan Sequence Diagram.
> - Menunjukkan minimal dua prinsip SOLID di kode.

---
## Yang saya kerjakan

Di minggu ini saya membuat dua diagram di `docs/uml`, yaitu `class.mmd` dan `sequence.mmd`. Class diagram saya susun dari kode yang sudah ada: saya baca ulang kelas di paket `model`, `katalog`, `jadwal`, `denda`, `factory`, `dao`, dan `exception`, lalu mencatat atribut, method, tipe, visibility, relasi, serta multiplicity-nya. Sequence diagram saya buat untuk alur `JadwalPeminjaman.ajukan(baru)` dengan fragmen `alt` untuk kondisi bentrok dan tidak bentrok. Setelah itu saya menulis `docs/uml/solid.md` yang membahas OCP, LSP, dan DIP. Saya juga mengubah `minggu-aktif.txt` ke 6 agar tes minggu 6 bisa ikut dijalankan, lalu menjalankan `.\scripts\uji.ps1`. Kemudian setelah selesai, saya membuat sebuah laporan `minggu-06.md` di `/catatan/minggu-06.md`.

---
## Keputusan desain

Saya memilih Mermaid karena sumbernya berupa teks dan bisa dirender ulang kalau ada perubahan. Saya menyimpan sumber `.mmd` supaya diagram tetap bisa diperiksa tanpa harus membuka editor khusus.

Untuk class diagram, saya membatasi cakupannya ke paket core. Paket API belum saya masukkan karena tugas minggu 6 berfokus pada model dan kontrak core, sedangkan API baru masuk minggu 12-15. Saya memakai aggregation (`o--`) untuk `KatalogAset`-`Aset` dan `JadwalPeminjaman`-`Peminjaman` karena kedua kelas itu hanya menyimpan referensi di dalam daftar. Objek `Aset` dan `Peminjaman` tetap bisa hidup di luar daftar tersebut, jadi bukan composition.

Untuk sequence diagram, saya hanya memakai method yang memang sudah ada di kode: `ajukan`, `bentrok`, `tambah`, dan getter milik `Peminjaman`. Saya tidak menambah method baru. Saat ini `bentrok()` dan `ajukan()` masih TODO minggu 7 dan 9, jadi diagram itu menggambarkan kontrak method tersebut, bukan kode yang sudah selesai. Saya tulis catatan ini di sini supaya diagram tidak terkesan mengarang alur.

Untuk SOLID, saya memilih OCP, LSP, dan DIP karena ketiganya paling jelas terlihat. Saya tidak melakukan refactor karena strukturnya sudah menunjukkan prinsip tersebut, dan menambah kelas baru justru berisiko membuat diagram berbeda dari kode.

---
## Kendala

Bagian yang paling sulit adalah menjaga diagram tetap sama dengan kode. Saya sempat ingin menambahkan method persetujuan dan pembatalan supaya alur pengajuan terlihat lengkap, tetapi method itu belum ada di kode minggu 6. Akhirnya saya hanya memakai field dan method yang ada, lalu menulis catatan bahwa beberapa method masih TODO.

Menentukan aggregation dan composition juga sempat membingungkan. Saya cek lagi siapa yang membuat objek dan siapa yang menyimpan referensinya. Karena `Peminjaman` dibuat di luar `JadwalPeminjaman`, relasinya saya tandai sebagai aggregation, bukan composition.

Di Mermaid, diagram class pertama saya terlalu lebar sehingga teksnya kecil saat menjadi gambar. Saya render ulang dengan ukuran lebih besar. Pada sequence diagram, blok `loop` sempat menumpuk dengan fragmen `alt`, jadi saya ganti dengan satu `Note` yang menjelaskan perulangan pemeriksaan.

## Penggunaan AI

- Alat yang dipakai: DeepSeek
- Bagian yang dibantu AI: membaca ulang daftar atribut dan method untuk class diagram, membantu menyusun sintaks Mermaid.
- Prompt utama:
    - Jelaskan Pengerjaan minggu 06
    - Buatkan kerangka class diagram Mermaid dari kelas-kelas di paket core yang sesuai dengan minggu 06.
    - Buat sequence diagram pengajuan peminjaman dengan fragmen alt untuk skenario bentrok dan sukses.
- Yang saya ubah atau tolak dari saran AI, dan alasannya: AI sempat menyarankan menambahkan method persetujuan dan mengimplementasikan `ajukan` supaya sequence diagram terasa lengkap. Saya tolak karena itu masuk minggu 7 dan 9, bukan tugas minggu 6. AI juga sempat memberi relasi composition untuk `JadwalPeminjaman`-`Peminjaman`; saya ganti menjadi aggregation karena `Peminjaman` dibuat di luar jadwal dan tidak dimiliki secara eksklusif. 
- Satu hal yang saya pahami lebih baik sekarang: Perbedaan antara Aggregation dan Composition. Keduanya sama-sama menggambarkan hubungan antarobjek, tetapi memiliki perbedaan dalam hal ketergantungan dan kepemilikan siklus hidup objek. Pada Aggregation, objek tetap bisa berdiri sendiri, sedangkan pada Composition, objek bagian lebih bergantung pada objek utamanya.

## Kuis
---
### Soal
---
1. Apa perbedaan aggregation dan composition?
2. Mengapa OCP memudahkan pengembangan?
3. Mengapa DIP meningkatkan testability?

---
### Jawaban
---

1. Aggregation dan Composition sama-sama menggambarkan hubungan antara dua class, tetapi berbeda dalam ketergantungan objeknya. Aggregation memiliki hubungan yang lebih longgar, artinya objek yang dimiliki tetap bisa berdiri sendiri meskipun objek pemiliknya dihapus. Contohnya pada proyek ini adalah `KatalogAset` yang menyimpan kumpulan objek `Aset` melalui `List<Aset>`. Aset tetap bisa dibuat dan digunakan meskipun katalog tidak ada. Sedangkan Composition memiliki hubungan yang lebih kuat, yaitu objek bagian bergantung pada objek utama dan siklus hidupnya dikelola oleh objek tersebut. Perbedaan lainnya, pada Aggregation objek bisa dimiliki atau digunakan oleh beberapa objek lain, sedangkan pada Composition bagian umumnya menjadi milik satu objek utama dan tidak berdiri sendiri dari sisi siklus hidupnya. Jadi, perbedaan utamanya terletak pada tingkat ketergantungan dan kepemilikan objek.

2. OCP (Open/Closed Principle) memudahkan pengembangan karena pengguna bisa menambahkan fitur atau perilaku baru tanpa harus mengubah kode yang sudah ada. Contohnya pada class `Aset` yang dibuat abstrak dan memiliki turunan seperti `Ruang`, `Laptop`, dan `AlatLab`. Jika ingin menambahkan jenis aset baru, kita cukup membuat subclass baru yang mengikuti aturan dari `Aset`, tanpa harus mengubah cara kerja `KatalogAset` yang sudah menggunakan `List<Aset>`. Dengan begitu, pengembangan fitur baru menjadi lebih mudah dan risiko merusak fitur yang sudah berjalan bisa dikurangi.

3. DIP (Dependency Inversion Principle) meningkatkan testability karena sebuah class tidak bergantung langsung pada class tertentu, melainkan pada interface atau abstraksi. Contohnya pada `AsetService` yang menggunakan `AsetRepository`, bukan langsung menggunakan `InMemoryAsetRepository`. Dengan begitu, saat melakukan pengujian, pengguna bisa mengganti implementasi repository dengan objek palsu (mock) tanpa harus menggunakan database asli. Sehingga membuat pengujian lebih mudah, cepat, dan tidak bergantung pada kondisi database yang sebenarnya.

---
## Hasil


```
PS C:\Users\LENOVO LOQ\oop-202601-250202957> .\scripts\uji.ps1
Menjalankan tes minggu 1 sampai 6  (groups: week1 | week2 | week3 | week4 | week5 | week6)
[INFO] Scanning for projects...
[INFO] Loaded 24401 auto-discovered prefixes for remote repository central (prefixes-central.txt)
[INFO] --------------------------------------------------------------------------------------------------------------------------
[INFO] Reactor Build Order:
[INFO] 
[INFO] Aset-Pinjam (OOP 202601)                                                                                             [pom]
[INFO] Aset-Pinjam Core (minggu 1-11)                                                                                       [jar]
[INFO] Aset-Pinjam API (minggu 12-15)                                                                                       [jar]
[INFO] 
[INFO] ---------------------------------------------< id.ac.upb:asetpinjam-parent >----------------------------------------------
[INFO] Building Aset-Pinjam (OOP 202601) 0.1.0                                                                              [1/3]
[INFO]   from pom.xml
[INFO] ---------------------------------------------------------[ pom ]----------------------------------------------------------
[INFO] 
[INFO] ----------------------------------------------< id.ac.upb:asetpinjam-core >-----------------------------------------------
[INFO] Building Aset-Pinjam Core (minggu 1-11) 0.1.0                                                                        [2/3]
[INFO]   from core\pom.xml
[INFO] ---------------------------------------------------------[ jar ]----------------------------------------------------------
[INFO] Loaded 64 auto-discovered prefixes for remote repository apache.snapshots (prefixes-apache.snapshots.txt)
[INFO] 
[INFO] --- resources:3.3.1:resources (default-resources) @ asetpinjam-core ---
[INFO] Copying 0 resource from src\main\resources to target\classes
[INFO] Copying 1 resource from src\main\resources to target\classes
[INFO] 
[INFO] --- compiler:3.14.1:compile (default-compile) @ asetpinjam-core ---
[INFO] Nothing to compile - all classes are up to date.
[INFO] 
[INFO] --- resources:3.3.1:testResources (default-testResources) @ asetpinjam-core ---
[INFO] skip non existing resourceDirectory C:\Users\LENOVO LOQ\oop-202601-250202957\core\src\test\resources
[INFO] 
[INFO] --- compiler:3.14.1:testCompile (default-testCompile) @ asetpinjam-core ---
[INFO] Nothing to compile - all classes are up to date.
[INFO] 
[INFO] --- surefire:3.5.6:test (default-test) @ asetpinjam-core ---
[INFO] Using auto detected provider org.apache.maven.surefire.junitplatform.JUnitPlatformProvider
[INFO] 
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running id.ac.upb.asetpinjam.Minggu01Test
[INFO] Tests run: 5, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.225 s -- in id.ac.upb.asetpinjam.Minggu01Test
[INFO] Running id.ac.upb.asetpinjam.Minggu02AsetTest
[INFO] Tests run: 6, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.060 s -- in id.ac.upb.asetpinjam.Minggu02AsetTest
[INFO] Running id.ac.upb.asetpinjam.Minggu03HierarkiTest
[INFO] Tests run: 8, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.059 s -- in id.ac.upb.asetpinjam.Minggu03HierarkiTest
[INFO] Running id.ac.upb.asetpinjam.Minggu04PolimorfismeTest
[INFO] Tests run: 8, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.032 s -- in id.ac.upb.asetpinjam.Minggu04PolimorfismeTest
[INFO] Running id.ac.upb.asetpinjam.Minggu05AbstraksiTest
[INFO] Tests run: 5, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.025 s -- in id.ac.upb.asetpinjam.Minggu05AbstraksiTest
[INFO] Running id.ac.upb.asetpinjam.Minggu06DokumenTest
[INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.041 s -- in id.ac.upb.asetpinjam.Minggu06DokumenTest
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 35, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] 
[INFO] -----------------------------------------------< id.ac.upb:asetpinjam-api >-----------------------------------------------
[INFO] Building Aset-Pinjam API (minggu 12-15) 0.1.0                                                                        [3/3]
[INFO]   from api\pom.xml
[INFO] ---------------------------------------------------------[ jar ]----------------------------------------------------------
[WARNING] 1 problem was encountered while building the effective model for 'org.springdoc:springdoc-openapi-starter-webmvc-ui:jar:2.8.9' during dependency collection step for project (use -X to see details)
[WARNING] 1 problem was encountered while building the effective model for 'org.springdoc:springdoc-openapi-starter-webmvc-api:jar:2.8.9' during dependency collection step for project (use -X to see details)
[WARNING] 1 problem was encountered while building the effective model for 'org.springdoc:springdoc-openapi-starter-common:jar:2.8.9' during dependency collection step for project (use -X to see details)
[INFO] 
[INFO] --- resources:3.3.1:resources (default-resources) @ asetpinjam-api ---
[INFO] Copying 1 resource from src\main\resources to target\classes
[INFO] Copying 0 resource from src\main\resources to target\classes
[INFO] 
[INFO] --- compiler:3.14.1:compile (default-compile) @ asetpinjam-api ---
[INFO] Nothing to compile - all classes are up to date.
[INFO] 
[INFO] --- resources:3.3.1:testResources (default-testResources) @ asetpinjam-api ---
[INFO] skip non existing resourceDirectory C:\Users\LENOVO LOQ\oop-202601-250202957\api\src\test\resources
[INFO] 
[INFO] --- compiler:3.14.1:testCompile (default-testCompile) @ asetpinjam-api ---
[INFO] Nothing to compile - all classes are up to date.
[INFO] 
[INFO] --- surefire:3.5.6:test (default-test) @ asetpinjam-api ---
[INFO] Using auto detected provider org.apache.maven.surefire.junitplatform.JUnitPlatformProvider
[INFO] 
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 0, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] --------------------------------------------------------------------------------------------------------------------------
[INFO] Reactor Summary for Aset-Pinjam (OOP 202601) 0.1.0:
[INFO] 
[INFO] Aset-Pinjam (OOP 202601) ............................................................................. SUCCESS [  0.052 s]
[INFO] Aset-Pinjam Core (minggu 1-11) ....................................................................... SUCCESS [  6.051 s]
[INFO] Aset-Pinjam API (minggu 12-15) ....................................................................... SUCCESS [  2.954 s]
[INFO] --------------------------------------------------------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] --------------------------------------------------------------------------------------------------------------------------
[INFO] Total time:  11.025 s
[INFO] Finished at: 2026-11-07T17:39:27+07:00
[INFO] --------------------------------------------------------------------------------------------------------------------------
PS C:\Users\LENOVO LOQ\oop-202601-250202957> 
```
