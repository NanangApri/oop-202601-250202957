# Catatan Minggu 07: Koleksi

## Tujuan

> - Memilih List, Map, atau Set untuk masalah nyata.
> - Mengurutkan dengan Comparator.

## Yang saya kerjakan

Saya mengerjakan bagian empat method yang bertanda **TODO minggu 7** di `core/src/main/java/id/ac/upb/asetpinjam/jadwal/JadwalPeminjaman.java`, yaitu `bentrok`, `semuaUrutMulai`, `perAset`, dan `hapus`. Pada method `bentrok`, sayaa mengggunakan `List` untuk memeriksa data peminjaman yang sudah ada, kemudian mencocokkan kode aset dan rentang waktunya. Pada method `semuaUrutMulai`, saya menggunakan `ArrayList` untuk menyalin data dan fitur pengurutan `Comparator` untuk mengurutkannnya berdsarkan wktu mulai. Pada method `perAset`, saya menggunakan `LinkedHashMap` untuk mengelompokkan data peminjaman berdasarkan kode aset, sedangkan pada method `hapus`, saya menggunakan `removeIf()` untuk menghapus data berdasarkan ID dan menghasilkan `true` jika data berhasil dihapus atau `false` jika tidak ditemukan. Ssaya juga menambahkan tes batas waktu di `mahasiswa/BatasBentrokTest.java` dan mengisi bagian A-01 di `docs/asumsi.md`. Setelah semua selesai saya jalankan `.\scripts\uji.ps1` kemudian saya mencaatat semua ynag saya lakukan di minggu ini di `catatan/minggu-07`.

## Keputusan desain

Pada `BatasBentrokTest.java`, saya membuat pengujian untuk memastikan aturan batas waktu peminjaman berjalan sesuai keputusan yang sudah ditentukan. Pengujian dilakukan dengan dua kondisi, yaitu peminjaman pertama berlangsung pukul 09.00–11.00 dan peminjaman berikutnya pukul 11.00–13.00, kmudian kondisi sebaliknya dengan peminjaman pukul 07.00–09.00. Kedua peminjaman menggunakan aset ynag sama, yaitu R-1,yang dibuat melalui method `TestSupport.ruang()`.Data peminjaman dibuat menggunakan method `pinjam()` dengan ID dan peminjam yang berbeda. Hasil pengujian diperiksa menggunakan `assertThat()` dengan `isFalse()` karna kedua jadwal hanya bertemu tepat pada batas waktu dan tidak saling tumpang tindih maka hasilnya adalah `false`. Jadi Ketika peminjam pertama selesai di waktu 11.00 kemudian peminjam kedua ingin meminjam pada jam 11.00, maka peminjam kedua bisa meminjam karena peminjam pertama selesai di waktu 11.00, sehingga tidak bentrok . Nilai false tersebut berasal dari hasil method `bentrok()` pada kelas JadwalPeminjaman, sedangkan jika waktu peminjaman benar-benar tumpang tindih,  hasil yang diharapkan adalah `true`. Kemudian saya mencatat tentang keputusan saya serta penjelasannya di `docs/asumsi.md` bagian A-01.

Untuk struktur data internal, saya mengggunakan `List` saja berupa `ArrayList` sebagai tempat penyimpanan utama data peminjaman karena struktur tersebut memang sudah tersedia pada `core/src/main/java/id/ac/upb/asetpinjam/jadwal/JadwalPeminjaman.java` dan masih sesuai dengan kebutuhan program.`List` juga memudahkan proses menambah, memeriksa, mengurutkan, dan menghapus data. Saya belum menggunakan `Map` atau `Set` untukk pengecekan bentrok karena perulangan biasa sudah cukup untuk memeriksa kode aset dan waktu peminjaman. Jika `Map` atau `Set` ditambahkan maka diperlukan field tambahan untuk menyimpan data tersebut, serta penyesuaian pada beberapa method seperti `tambah()`, `hapus()`, dan `bentrok()` agar isi struktur data tetap sesuai dengan data di dalam `List`. Hal ini dapat membuat pengelolaan kode lebih rumit karena data harus diperbarui di beberapa tempat. Namun, pada method `perAset`, saya menggunakan `LinkedHashMap` untuk mengelompokkan data peminjaman berdasarkan kode aset. Cara ini dipilih karena lebih sederhana dan sesuai dengan kebutuhan program pada minggu ini.

## Kendala

Bagian yang sempat bikin bingung adalah nentuin batas waktuny. Awalnya saya kira jika dua jadwal yang bersambung itu tetap bentrok, karena waktunya berdekatan. Tpi setelah lebih dipahami ulang, rentang 09:00-11:00 dan 11:00-13:00 itu tidak punya irisan, jadi lebih masuk akal kalau tidak bentrok. Kemudian saya menggunakan isBefore() untuk membandingkan waktu mulai dan selesai pada kedua arah, supaya batas yang pas bersentuhan tidak ikut terhitung.


## Penggunaan AI

- Alat yang dipakai: ChatGPT
- Bagian yang dibantu AI: membantu dalam pengejaan di `JadwalPeminjaman.java`, pemahaman tentang List, Set, Map dan membantu langkah pengisian di `BatasBentrokTest`
- Prompt utama:
    - Penjelasan tentang pengerjan mingggu 7 ini
    - buat contoh tes batas waktu di BatasBentrokTest,
    - penjelsan tentang List, Set, Map secara rinci dan jelas
- Yang saya ubah atau tolak dari saran AI, dan alasannya: AI sempat menyarankan memakai Map atau Set untuk mengecek bentrok agar lebih cepat. Saya tolak dulu karena data di memori masih sedikit dan List lebih gampang saya jelaskan. AI juga sempat menyarankan membandingkan waktu yang sama di perbandingan waktu, saya ganti menggunakan `isBefore() ` padaa perbandingan waktu kedua arah karena keputusan saya batas yang pas bersentuhan bukan bentrok.
- Satu hal yang saya pahami lebih baik sekarang: setiapp sistem membuthkan struktur data ynag disesuaikan dengan kebutuhannya. Misalnya, List digunakan ketika urutan data perlu dipertahankan, Set untuk menyimpan data unik, Map untuk mencari data berdasarkan kunci.Jadi, pemilihan struktur data perlu mempertimbangkan fungsi, kebutuhan, serta cara data tersebut akan dikelola.

## Kuis
---
### Soal
---
1. Kapan memilih Set daripada List?
2. Mengapa daftar internal dikembalikan sebagai salinan?
3. Apa beda Comparable dan Comparator?

---
### Jawaban
---
1. `Set `dipilih daripada `List` ketika data yang disimpan harus unik atau tidak boleh ada duplikat. Misalnya, menyimpan kumpulan kode aset yang sedang dipinjam agar satu kode aset tidak tercatat dua kali.Berbeda dengan `List`, `Set` tidak menyimpan elemen duplikat, tetapi tidak selalu mempertahankan urutan data.

2. Daftar internal dikembalikan sebagai salinan untuk melindungi data asli agar tidak dapat diubah secara langsung oleh pihak luar. Dengan begitu, ketika pengguna menambahkan, menghapus, atau mengubah elemen pada daftar yang diterima, perubahan tersebut tidak memengaruhi daftar internal yang disimpan oleh objek.

3. Ya beda, Comparable digunakan untuk menentukan urutan alami suatu objek dengan mengimplementasikan metode `compareTo()` langsung di dalam kelas objek tersebut. Artinya, kelas menentukan sendiri bagaimana objeknya dibandingkan, misalnya mengurutkan data peminjaman berdasarkan tanggal atau ID.         
Sedangkan Comparator digunakan untuk menentukan aturan pengurutan dari luar kelas objek dngan menggunakan metode `compare()`. artinya satu jenis objek dapat memiliki beberapa aturan pengurutan berbeda, misalnya berdasarkan tanggal peminjaman, nama peminjam, atau status peminjaman tanpa harus mengubah kelas aslinya.        
Jadi Perbedaannya terletak pada tempat menentukan aturan pengurutan. Comparable menentukkan aturan pengurutann langsung di dalam kelas objek, sedangkan Comparator menentukan aturan dari luar kelas, sehingga satu kelas bisa memiliki beberapa aturan pengurutan berbeda tanpa mengubah kelas aslinya.

## Hasil

```
PS C:\Users\LENOVO LOQ\oop-202601-250202957> .\scripts\uji.ps1
Menjalankan tes minggu 1 sampai 7  (groups: week1 | week2 | week3 | week4 | week5 | week6 | week7)
[INFO] Scanning for projects...
[INFO] Loaded 24446 auto-discovered prefixes for remote repository central (prefixes-central.txt)
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
[INFO] Running id.ac.upb.asetpinjam.mahasiswa.BatasBentrokTest
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.135 s -- in id.ac.upb.asetpinjam.mahasiswa.BatasBentrokTest
[INFO] Running id.ac.upb.asetpinjam.Minggu01Test
[INFO] Tests run: 5, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.048 s -- in id.ac.upb.asetpinjam.Minggu01Test
[INFO] Running id.ac.upb.asetpinjam.Minggu02AsetTest
[INFO] Tests run: 6, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.058 s -- in id.ac.upb.asetpinjam.Minggu02AsetTest
[INFO] Running id.ac.upb.asetpinjam.Minggu03HierarkiTest
[INFO] Tests run: 8, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.042 s -- in id.ac.upb.asetpinjam.Minggu03HierarkiTest
[INFO] Running id.ac.upb.asetpinjam.Minggu04PolimorfismeTest
[INFO] Tests run: 8, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.021 s -- in id.ac.upb.asetpinjam.Minggu04PolimorfismeTest
[INFO] Running id.ac.upb.asetpinjam.Minggu05AbstraksiTest
[INFO] Tests run: 5, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.020 s -- in id.ac.upb.asetpinjam.Minggu05AbstraksiTest
[INFO] Running id.ac.upb.asetpinjam.Minggu06DokumenTest
[INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.029 s -- in id.ac.upb.asetpinjam.Minggu06DokumenTest
[INFO] Running id.ac.upb.asetpinjam.Minggu07JadwalTest
[INFO] Tests run: 8, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.027 s -- in id.ac.upb.asetpinjam.Minggu07JadwalTest
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 44, Failures: 0, Errors: 0, Skipped: 0
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
[INFO] Aset-Pinjam (OOP 202601) ............................................................................. SUCCESS [  0.053 s]
[INFO] Aset-Pinjam Core (minggu 1-11) ....................................................................... SUCCESS [  4.900 s]
[INFO] Aset-Pinjam API (minggu 12-15) ....................................................................... SUCCESS [  3.586 s]
[INFO] --------------------------------------------------------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] --------------------------------------------------------------------------------------------------------------------------
[INFO] Total time:  11.606 s
[INFO] Finished at: 2026-11-11T13:07:59+07:00
[INFO] --------------------------------------------------------------------------------------------------------------------------
PS C:\Users\LENOVO LOQ\oop-202601-250202957>  
```
