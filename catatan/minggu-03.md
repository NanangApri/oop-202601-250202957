# Catatan Minggu 03: Inheritance

## Tujuan
> - Membuat hierarki class dan memakai ulang kode induk.
> - Menjelaskan satu keterbatasan inheritance.

## Yang saya kerjakan
Yang pertama Saya mengerjakan `core/src/main/java/id/ac/upb/asetpinjam/model/Ruang.java` yang bertanda TODO, yang pertama saya membuat field `kapasitas` dengan bersifat `final`, membuat pemanggilan konstruktor superclass untuk `kode` dan `nama` dari Aset, membuat fungsi `if` untuk validasi, memperbaiki getter, membuat `@Override`.

Kemudian mengerjakan `core/src/main/java/id/ac/upb/asetpinjam/model/AlatLab.java` yang bertanda TODO, membuat field `laboratorium` dan `tingkatRisiko` yang bersifat `final`, membuat pemanggilan konstruktor superclass untuk `kode` dan `nama` dari Aset, membuat fungsi `if` untuk validasi, memperbaiki getter, membuat `@Override`.

Kemudian mengerjakan `core/src/main/java/id/ac/upb/asetpinjam/model/Laptop.java` yang bertanda TODO, membuat field `spesifikasi` dan `nomorInventaris`yang bersifat `final`, membuat pemanggilan konstruktor superclass untuk `kode` dan `nama` dari Aset, membuat fungsi `if` untuk validasi, memperbaiki getter, membuat `@Override`. Kemudian setelah selesai membuat sebuah laporan di `catatan/minggu-03.md` kemudian mengubah `minggu-aktif.txt` agar bisa mengecek hasil menggunakan `.\scripts\uji.ps1`.

## Keputusan desain
Di minggu ini saya meletakkan field `kode` dan `nama` di induk `Aset` karena dimiliki oleh semua jenis aset. Kemudian untuk field `kapasitas` di subclass `Ruang`, `laboratorium` dan `tingkatRisiko` pada subclass `AlatLab`. Kemudian `spesifikasi` dan `nomorInventaris` pada subclass `Laptop` karena field tersebut    memiliki field dan aturan validasi yang berbeda jenis asetnya . Kemudian setiap `subclass` saya menambahkan validasi setiap kebutuhan masing masing. 

Kemudian pada pembuatan fungsi validasi di `AlatLab.java` dan `Laptop.java` disini saya membuat agar nilai tidak akan bernilai null atupun kosong. Kemudian untuk `Ruang.java` disini saya membuat agar kapasitas harus lebih dari 0, dan disini saya menggunakan `<1` untuk memberikan validasi yang diharapkan karena nantinya jika input 0 maka akan memunculkan bahwa hasilnya ditolak, nmaun ketika input 1 maka akan berhasil karena 1 bukan lebih kecil dari 1.Kemudian disini saya memilih `<1` karena terlihat simple dan mudah untuk dipahami, 

## Kendala
Disini saya mengalami kendala dibagian pengujian karena error, setelah saya periksa lagi ada salah pengetikan dibagian kodenya, saya mengatasinya dengan lebih teliti lagi. Kemudian pada saat melakukan pengetesan minggu-03, karena yang minggu 03 tidak ada di hasil percobaan menggunakan powershell, cara mengatasinya dengan mengubah `minggu-aktif.txt` dengan nomor pengerjaan minggu yang dikerjakan.

## Penggunaan AI
- Alat yang dipakai: Claude
- Bagian yang dibantu AI: Pengecekkan kode program yang salah, Penjelasan tentang pengerjaan minggu ke 3, penjelasan perbedaan komposisi dan inheritance.
- Prompt utama: 
    - Jelaskan tentang pengerjaan minggu ke 3 ini
    - Jelaskan Perbedaan komposisi dan Inheritance
    - Kenapa gagal? (copy yang bagian gagal/error)
- Yang saya ubah atau tolak dari saran AI, dan alasannya: Penggunaan `this.` pada getter, mungkin memang bisa jika menambahkan `this.`, namun pada minggu sebelumnya saya tidak menggunakan `this.`, jadi disini saya lebih memilih tidak menggunakan karena untuk menjaga kekonsistenan kode.
- Satu hal yang saya pahami lebih baik sekarang: Perbedaan Inheritance dan komposisi. Inheritance dipakai jika sebuah kelas memang jenis dari kelas lain. Sedangkan komposisi dipakai jika sebuah kelas hanya memakai kelas lain sebagai bagian dari datanya.

## Catatan
Inheritance kurang tepat dibanding  komposisi ketika dua kelas sebenarnya tidak berhubungan sebagai jenis dan induknya, melainkan yang satu hanya memakai lain sebagai bagian. Contohnya `peminjaman` yang dibuat dengan `extends Aset`. Peminjaman bukan jenis set, namun hanya memakai aset sebagai bagian dari datanya. Jika `peminjaman` dibuat sebagai turunan dari `Aset`, peminjaman ikut mendapat kode, nama, status, dan kondisi yang tidak relevan, sehingga modelnya nantinya akan membingungkan. Komposisi lebih tepat karena `peminjaman` cukup menyimpan sebuah `Aset` sebagai field.

## Hasil
```
PS C:\Users\LENOVO LOQ\oop-202601-250202957> .\scripts\uji.ps1 
Menjalankan tes minggu 1 sampai 3  (groups: week1 | week2 | week3)
[INFO] Scanning for projects...
[INFO] Loaded 24219 auto-discovered prefixes for remote repository central (prefixes-central.txt)
[INFO] -------------------------------------------------------------------------------------------------------------
[INFO] Reactor Build Order:
[INFO] 
[INFO] Aset-Pinjam (OOP 202601)                                                                                [pom]
[INFO] Aset-Pinjam Core (minggu 1-11)                                                                          [jar]
[INFO] Aset-Pinjam API (minggu 12-15)                                                                          [jar]
[INFO] 
[INFO] ---------------------------------------< id.ac.upb:asetpinjam-parent >---------------------------------------
[INFO] Building Aset-Pinjam (OOP 202601) 0.1.0                                                                 [1/3]
[INFO]   from pom.xml
[INFO] ---------------------------------------------------[ pom ]---------------------------------------------------
[INFO] 
[INFO] ----------------------------------------< id.ac.upb:asetpinjam-core >----------------------------------------
[INFO] Building Aset-Pinjam Core (minggu 1-11) 0.1.0                                                           [2/3]
[INFO]   from core\pom.xml
[INFO] ---------------------------------------------------[ jar ]---------------------------------------------------
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
[INFO] Tests run: 5, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.212 s -- in id.ac.upb.asetpinjam.Minggu01Test
[INFO] Running id.ac.upb.asetpinjam.Minggu02AsetTest
[INFO] Tests run: 6, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.053 s -- in id.ac.upb.asetpinjam.Minggu02AsetTest
[INFO] Running id.ac.upb.asetpinjam.Minggu03HierarkiTest
[INFO] Tests run: 8, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.049 s -- in id.ac.upb.asetpinjam.Minggu03HierarkiTest
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 19, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] 
[INFO] ----------------------------------------< id.ac.upb:asetpinjam-api >-----------------------------------------
[INFO] Building Aset-Pinjam API (minggu 12-15) 0.1.0                                                           [3/3]
[INFO]   from api\pom.xml
[INFO] ---------------------------------------------------[ jar ]---------------------------------------------------
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
[INFO] -------------------------------------------------------------------------------------------------------------
[INFO] Reactor Summary for Aset-Pinjam (OOP 202601) 0.1.0:
[INFO] 
[INFO] Aset-Pinjam (OOP 202601) ................................................................ SUCCESS [  0.034 s]
[INFO] Aset-Pinjam Core (minggu 1-11) .......................................................... SUCCESS [  6.119 s]
[INFO] Aset-Pinjam API (minggu 12-15) .......................................................... SUCCESS [  2.686 s]
[INFO] -------------------------------------------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] -------------------------------------------------------------------------------------------------------------
[INFO] Total time:  11.007 s
[INFO] Finished at: 2026-10-24T22:21:31+07:00
[INFO] -------------------------------------------------------------------------------------------------------------
PS C:\Users\LENOVO LOQ\oop-202601-250202957> 
```
