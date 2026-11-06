# Catatan Minggu 05: Abstraction

## Tujuan
> - Memilih antara abstract class dan interface.
> - Mengimplementasikan interface.

## Yang saya kerjakan
Di minggu ini saya mengisi `bisaDipinjam()` di `Aset.java`, lalu memastikan `Aset` memang sudah menjadi class abstrak dan `hitungDenda(int)` juga abstrak. Karena `hitungDenda` sekarang abstrak, saya memindahkan perhitungan dasar ke method `dendaDasar(int)` dan mengubah `Ruang`, `Laptop`, serta `AlatLab` supaya memanggil method tersebut. Setelah itu saya mengisi `DendaFlat` dan `DendaProgresif` sesuai kontrak `AturanDenda`. Kemudian setelah selesai, saya membuat sebuah laporan `minggu-04.md` di `/catatan` kemudian mengecek hasil menggunakan `.\scripts\uji.ps1 5`.

## Keputusan desain
Saya sengaja tidak menaruh rumus denda dasar langsung di tiap subclass. Saya buat `dendaDasar(int)` di `Aset` supaya pengecekan hari negatif dan tarif dari `Varian.aktif().dendaPerHari` tetap satu tempat. Tiap subclass tinggal mengalikan hasilnya dengan multiplier jenisnya, jadi tidak ada kode yang sama ditulis tiga kali.

Untuk denda progresif saya pakai rumus denda flat ditambah `(hari / 7) x denda satu hari`. Artinya keterlambatan 1-6 hari masih sama dengan denda flat, lalu setiap lewat 7 hari denda naik satu hari. Saya pilih rumus ini karena gampang dihitung dan gampang dijelaskan, bukan karena rumusnya paling rumit. Kemudian saya mencatatnya ada di `docs/asumsi.md` bagian A-02.

## Kendala
Bagian yang agak mengganggu adalah saat `hitungDenda` dijadikan abstrak, method di subclass yang masih memanggil `super.hitungDenda(...)` jadi error. Saya sempat bingung karena di minggu 4 cara itu masih jalan. Setelah dibaca lagi, penyebabnya jelas: method abstrak tidak punya isi, jadi tidak bisa dipanggil lewat `super`. Akhirnya isi `hitungDenda` yang lama saya pindahkan ke `dendaDasar(int)` sebagai method biasa di `Aset`, lalu `hitungDenda` baru saya jadikan abstrak. Di `Ruang`, `Laptop`, dan `AlatLab`, pemanggilannya saya ganti ke `super.dendaDasar(...)` dan hasilnya dikalikan multiplier jenisnya masing-masing: 1x, 2x, dan 4x. Jadi perhitungan dasarnya tetap satu tempat, tapi tiap subclass masih punya hitungan akhir sendiri.

## Penggunaan AI
- Alat yang dipakai: DeepSeek
- Bagian yang dibantu AI: mengisi `bisaDipinjam()`, merapikan `Aset` dan subclass setelah `hitungDenda` dijadikan abstrak, serta membuat `DendaFlat` dan `DendaProgresif`.
- Prompt utama:
    - Jelaskan kenapa `super.hitungDenda()` error setelah methodnya dijadikan abstrak?
    - Kalau `hitungDenda` abstrak, di mana sebaiknya perhitungan dasar ditaruh supaya tidak duplikat?
    - Cek apakah rumus progresif saya sudah memenuhi syarat 0 hari = 0 dan tidak pernah lebih murah dari flat.
- Yang saya ubah atau tolak dari saran AI, dan alasannya: AI sempat menyarankan rumus progresif yang langsung memakai persentase per hari. Saya tidak pakai karena angkanya jadi lebih sulit saya jelaskan sendiri. Saya ganti dengan tambahan per 7 hari yang lebih sederhana dan tetap memenuhi syarat tes.
- Satu hal yang saya pahami lebih baik sekarang: AI sempat menyarankan rumus progresif yang langsung memakai persentase per hari. Saya tidak pakai karena angkanya jadi lebih sulit saya jelaskan sendiri. Saya ganti dengan tambahan per 7 hari yang lebih sederhana dan tetap memenuhi syarat tes.

## Hasil
```
PS C:\Users\LENOVO LOQ\oop-202601-250202957> .\scripts\uji.ps1 5
Menjalankan tes minggu 1 sampai 5  (groups: week1 | week2 | week3 | week4 | week5)
[INFO] Scanning for projects...
[INFO] Loaded 24384 auto-discovered prefixes for remote repository central (prefixes-central.txt)
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
[INFO] Tests run: 5, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.177 s -- in id.ac.upb.asetpinjam.Minggu01Test
[INFO] Running id.ac.upb.asetpinjam.Minggu02AsetTest
[INFO] Tests run: 6, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.044 s -- in id.ac.upb.asetpinjam.Minggu02AsetTest
[INFO] Running id.ac.upb.asetpinjam.Minggu03HierarkiTest
[INFO] Tests run: 8, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.040 s -- in id.ac.upb.asetpinjam.Minggu03HierarkiTest
[INFO] Running id.ac.upb.asetpinjam.Minggu04PolimorfismeTest
[INFO] Tests run: 8, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.024 s -- in id.ac.upb.asetpinjam.Minggu04PolimorfismeTest
[INFO] Running id.ac.upb.asetpinjam.Minggu05AbstraksiTest
[INFO] Tests run: 5, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.018 s -- in id.ac.upb.asetpinjam.Minggu05AbstraksiTest
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 32, Failures: 0, Errors: 0, Skipped: 0
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
[INFO] Aset-Pinjam (OOP 202601) ............................................................................. SUCCESS [  0.034 s]
[INFO] Aset-Pinjam Core (minggu 1-11) ....................................................................... SUCCESS [  4.497 s]
[INFO] Aset-Pinjam API (minggu 12-15) ....................................................................... SUCCESS [  1.764 s]
[INFO] --------------------------------------------------------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] --------------------------------------------------------------------------------------------------------------------------
[INFO] Total time:  7.832 s
[INFO] Finished at: 2026-11-06T13:41:59+07:00
[INFO] --------------------------------------------------------------------------------------------------------------------------
PS C:\Users\LENOVO LOQ\oop-202601-250202957> 
```
