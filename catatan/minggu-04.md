# Catatan Minggu 04: Polymorphism

## Tujuan

> - Memakai overriding dan dynamic binding.
> - Membedakan overloading dan overriding.

## Yang saya kerjakan
Di minggu ini saya mengerjakan `core/src/main/java/id/ac/upb/asetpinjam/model/Aset.java` dengan mengisi `hitungDenda(int)` untuk menolak hari negatif dan menghitung denda dasar 1x dari `Varian.aktif().dendaPerHari`. Setelah itu saya mengerjakan override `hitungDenda(int)` di `Ruang.java` (1x), `Laptop.java` (2x), dan `AlatLab.java` (4x). Terakhir saya mengerjakan dua overload `cari(...)` di `core/src/main/java/id/ac/upb/asetpinjam/katalog/KatalogAset.java`, yaitu pencarian berdasarkan kata saja dan pencarian berdasarkan kata sekaligus jenis aset. Kemudian setelah selesai, saya membuat sebuah laporan `minggu-04.md` di `/catatan` kemudian mengubah `minggu-aktif.txt` agar bisa mengecek hasil menggunakan `.\scripts\uji.ps1`.

## Keputusan desain
Saya meletakkan pengecekan hari negatif di `Aset.hitungDenda(int)` supaya tidak ditulis berulang di setiap subclass. Tiap subclass lalu memanggil `super.hitungDenda(hariTerlambat)` dan mengalikannya dengan multiplier jenisnya masing-masing. Dengan cara ini aturan dasarnya tetap satu, tetapi setiap jenis aset tetap punya perilaku sendiri lewat overriding.

Untuk pencarian, saya memakai `toLowerCase()` pada nama aset dan kata yang dicari supaya huruf besar dan kecil tidak berpengaruh. Untuk `cari(kata, jenis)`, saya memakai hasil dari `cari(kata)` lalu menyaringnya berdasarkan `getJenis()`. Jadi logika pencarian kata tidak perlu ditulis dua kali, dan perbedaan dua method ini sekaligus menunjukkan overloading.

## Kendala
Bagian yang sempat membuat saya berpikir adalah membedakan overloading dan overriding. Dua method `cari(...)` namanya sama tetapi parameternya berbeda, sedangkan `hitungDenda(int)` di subclass memiliki nama dan parameter yang sama dengan milik `Aset`. Saya mengatasinya dengan melihat lagi contoh di modul dan mencoba menjalankan tes minggu 4 sampai hasilnya jadi.

## Penggunaan AI
- Alat yang dipakai: DeepSeek
- Bagian yang dibantu AI: membantu dalam Implementasi `hitungDenda(int)` pada `Aset` dan ketiga subclass, serta dua method `cari(...)` pada `KatalogAset`.
- Prompt utama:
    - Jelaskan tentang pengerjaan minggu ke 4 ini
    - Kenapa pada saat saya mengubah yang berada di aset, beberapa ada yng error?? 
    - Jelaskan tentang overloading pada minggu 4.
- Yang saya ubah atau tolak dari saran AI, dan alasannya: Saya tidak memakai cara yang menaruh semua perhitungan denda di satu method `Aset` berdasarkan jenis. Saya lebih memilih tiap subclass meng-override `hitungDenda(int)` sendiri karena itu yang sedang dipelajari di minggu ini, yaitu overriding dan dynamic binding.
- Satu hal yang saya pahami lebih baik sekarang: Overriding terjadi saat subclass mengganti method induk dengan nama dan parameter yang sama, sedangkan overloading terjadi saat beberapa method punya nama sama tetapi parameter berbeda. Saat variabel bertipe `Aset` menunjuk objek `Laptop`, method `hitungDenda` yang dipanggil tetap milik `Laptop`.

## Hasil
```
PS C:\Users\LENOVO LOQ\oop-202601-250202957> .\scripts\uji.ps1
Menjalankan tes minggu 1 sampai 4  (groups: week1 | week2 | week3 | week4)
[INFO] Scanning for projects...
[INFO] Loaded 24289 auto-discovered prefixes for remote repository central (prefixes-central.txt)
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
[INFO] Loaded 74 auto-discovered prefixes for remote repository apache.snapshots (prefixes-apache.snapshots.txt)
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
[INFO] Tests run: 5, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.162 s -- in id.ac.upb.asetpinjam.Minggu01Test
[INFO] Running id.ac.upb.asetpinjam.Minggu02AsetTest
[INFO] Tests run: 6, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.038 s -- in id.ac.upb.asetpinjam.Minggu02AsetTest
[INFO] Running id.ac.upb.asetpinjam.Minggu03HierarkiTest
[INFO] Tests run: 8, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.041 s -- in id.ac.upb.asetpinjam.Minggu03HierarkiTest
[INFO] Running id.ac.upb.asetpinjam.Minggu04PolimorfismeTest
[INFO] Tests run: 8, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.050 s -- in id.ac.upb.asetpinjam.Minggu04PolimorfismeTest
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 27, Failures: 0, Errors: 0, Skipped: 0
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
[INFO] Aset-Pinjam (OOP 202601) ............................................................................. SUCCESS [  0.058 s]
[INFO] Aset-Pinjam Core (minggu 1-11) ....................................................................... SUCCESS [  4.805 s]
[INFO] Aset-Pinjam API (minggu 12-15) ....................................................................... SUCCESS [  2.243 s]
[INFO] --------------------------------------------------------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] --------------------------------------------------------------------------------------------------------------------------
[INFO] Total time:  9.036 s
[INFO] Finished at: 2026-10-29T21:45:04+07:00
[INFO] --------------------------------------------------------------------------------------------------------------------------
PS C:\Users\LENOVO LOQ\oop-202601-250202957>
```
