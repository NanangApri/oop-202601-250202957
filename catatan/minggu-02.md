# Catatan Minggu 2: Struktur OOP: Class, Object, Encapsulation

## Tujuan

> Membuat class dengan field private, konstruktor, getter/setter, dan validasi.

## Yang saya kerjakan
Saya mengerjakan `core/src/main/java/id/ac/upb/asetpinjam/model/Aset.java`, di file program tersebut saya menambahkan field private: `kode` dengan bersifat `final`, `nama`, `status` dengan status awal/nilai default aset **TERSEDIA**, dan `kondisi` dengan kondisi awal yang dimiliki adalah **BAIK**.Selanjutnya membuat validasi agar kode dan nama tidak boleh kosong dengan menggunakan `if`, memperbarui bagian getter dengan mengubah bagian `throw` menjadi `return`, serta memperbarui setter yang tersedia dengan menambahkan validasi agar nama baru tidak boleh kosong dan status `setStatus` serta kondisi `setKondisi` tidak boleh null. Kemudian setelah menyelesaikan semua saya menguji coba menggunakan `.\scripts\uji.ps1`, setelah berhasil dilanjutkan mengisi laporan di `catatan/minggu-02.md`.

## Keputusan desain
Keputusan desain pada minggu ini, atribut `kode`, `nama`, `status`, dan `kondisi` dibuat menggunakan private agar tidak dapat diakses secara langsung dari luar class. Atribut `kode` menggunakan private `final` karena nilainya tidak boleh berubah ubah setelah objek dibuat, kemudian diminggu ini atribut `kode` tidak diperbolehkan menggunakan setter sehingga nilai atribut tersebut hanya dapat ditetapkan satu kali oleh konstruktor dan hanya dapat dibaca melalui getter. Konstruktor digunakan untuk menginisialisasi kode dan nama saat objek aset dibuat. Kemudian, kode dan nama tidak boleh kosong atau bernilai null. Jika data tidak sesuai, program akan memberikan pesan kesalahan melalui `IllegalArgumentException` yang akan memuat sebuah pesan tentang kesalahan dari data yang tidak sesuai.

Pada atribut kode saya tidak menggunakan `trim()` karena pada instruksi pengerjaan tidak mewajibkan menggunakan `trim()` melainkan hanya disuruh untuk `kode` agar tidak boleh bernilai kosong maupun null. Kemudian saya tidak mengubah huruf kecil maupun besar pada `kode` karena huruf besar maupun kecil tetap bisa dijadikan menjadi bagian dari format kode yang digunakan dalam sistem. Kemudian `status` ditetapkan default **TERSEDIA**, sedangkan nilai default `kondisi` adalah **BAIK**. Kedua nilai tersebut digunakan sebagai nilai awal ketika objek aset dibuat. Getter digunakan sebagai membaca nilai atribut, sedangkan setter digunakan untuk mengubah nilai atribut. Sebelum melakukan perubahan, setter memeriksa data agar nama tidak kosong atau null, serta status dan kondisi tidak bernilai null.

## Kendala
Kendala yang saya alami pada minggu ini adalah pembuatan programnya yang kadang kadang salah dan menyebabkan error, seperti kurang titik koma, indentasi, serta pengetikan kode. Untuk mengatasinya saya lebih teliti lagi dalam melakukan pengetikan kode program.

## Penggunaan AI
- Alat yang dipakai: Claude
- Bagian yang dibantu AI: Penjelasan tentang hal hal yang harus dilakukan pada minggu ke 2 ini. Kemudian menjelaskan tentang validasi, class, object serta encaptulation.
- Prompt utama:
    - Jelaskan pengerjaan minggu 2 ini
    - jelaskan tentang Class, Object, Encapsulation di minggu 2 ini
    - jelaskan penggunaan final pada field kode
- Yang saya ubah atau tolak dari saran AI, dan alasannya: disini saya menolak penggunaan semua huruf besar pada atribut `kode`, karena menurutku tetap bisa dijadikan menjadi bagian dari format kode yang digunakan dalam sistem.
- Satu hal yang saya pahami lebih baik sekarang: Penggunaan validasi dan `final` harus disesuaikan dengan sistem yang akan dibangun agar penulisan kode lebih rapi, mudah dipahami dan konsisten serta mengurangi kesalahan sistem kedepannya. Validasi digunakan untuk memastikan data yang diinput sesuai dengan ketentuan kemudian `final` digunakan agar identitas aset tetap konsisten.

## Hasil
```
PS C:\Users\LENOVO LOQ\oop-202601-250202957> .\scripts\uji.ps1  
Menjalankan tes minggu 1 sampai 2  (groups: week1 | week2)
[INFO] Scanning for projects...
[INFO] Loaded 24205 auto-discovered prefixes for remote repository central (prefixes-central.txt)
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
[INFO] Tests run: 5, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.152 s -- in id.ac.upb.asetpinjam.Minggu01Test
[INFO] Running id.ac.upb.asetpinjam.Minggu02AsetTest
[INFO] Tests run: 6, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.050 s -- in id.ac.upb.asetpinjam.Minggu02AsetTest
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 11, Failures: 0, Errors: 0, Skipped: 0
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
[INFO] Aset-Pinjam (OOP 202601) ............................................................................. SUCCESS [  0.043 s]
[INFO] Aset-Pinjam Core (minggu 1-11) ....................................................................... SUCCESS [ 14.450 s]
[INFO] Aset-Pinjam API (minggu 12-15) ....................................................................... SUCCESS [  2.018 s]
[INFO] --------------------------------------------------------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] --------------------------------------------------------------------------------------------------------------------------
[INFO] Total time:  18.334 s
[INFO] Finished at: 2026-10-23T13:32:48+07:00
[INFO] --------------------------------------------------------------------------------------------------------------------------
PS C:\Users\LENOVO LOQ\oop-202601-250202957>   
```
