# Catatan Minggu 01: Paradigma Pemrograman dan Setup

## Yang saya kerjakan
Pada Minggu ini saya melakukan persiapan sebelum mengerjakan Tugas Mata Kuliah Object Oriented Programming yaitu melakukan fork repository serta mengganti nama repository menjadi oop-202601-250202957, yang kemudian melakukan git clone di Visual Studio Code, selanjutnya melakukan penambahan remote upstream `git remote add upstream` dan mengambil pembaruan menggunakan `git fetch upstream` dan `git merge upstream/main`, selanjutnya adalah melakukan penginstalan Java versi 21.0.12.1 dan maven 4.0.0 dengan hasilnya.
```
PS C:\Users\LENOVO LOQ\oop-202601-250202957> git remote -v
origin  https://github.com/NanangApri/oop-202601-250202957.git (fetch)
origin  https://github.com/NanangApri/oop-202601-250202957.git (push)
upstream        https://github.com/mhbahara/oop-202601.git (fetch)
upstream        https://github.com/mhbahara/oop-202601.git (push)
PS C:\Users\LENOVO LOQ\oop-202601-250202957> mvn -v   
Apache Maven 4.0.0-rc-7 (6d8f301b38af7399b36b862969d520974944f0b9)
Maven home: C:\Program Files\apache-maven-4.0.0-rc-7
Java version: 21.0.12.1, vendor: Eclipse Adoptium, runtime: C:\Program Files\Eclipse Adoptium\jdk-21.0.12.101-hotspot
Default locale: en_ID, platform encoding: UTF-8, time zone: Asia/Jakarta
OS name: "windows 11", version: "10.0", arch: "amd64", family: "winnt"
``` 

Pada Minggu ini saya juga melakukan penambahan `nim=250202957` dan `nama=Nanang Apriyanto` di `core/src/main/resources/mahasiswa.properties` yang digunakan untuk menyimpan data nim dan nama, kemudian melakukan perubahan/penambahan di `core/src/main/java/id/ac/upb/asetpinjam/minggu01/HelloProsedural.java`, `HelloOOP.java`, dan `HelloFungsional.java`. 

Pada `core/src/main/java/id/ac/upb/asetpinjam/minggu01/HelloProsedural.java` saya melakukan penambahan `return nama -> "Halo Aset-Pinjam, nama saya " + nama + " dengan NIM: " + nim;`, di bagian `core/src/main/java/id/ac/upb/asetpinjam/minggu01/HelloFungsional.java` saya melakukan penambahan `return "Halo Aset-Pinjam, nama saya " + nama + " dengan NIM: " +nim;`, selanjutnya di `core/src/main/java/id/ac/upb/asetpinjam/minggu01/HelloOOP.java` melakukan penambahan:
```
private String nama;
private String nim;
```
```
this.nama = nama;
this.nim = nim;
```
```
return "Halo Aset-Pinjam, nama saya " + nama + " dengan NIM: " + nim;

```

kemudian setelah semuanya selesai saya menjalankan `.\scripts\uji.ps1`, dilanjutkan dengan mencatat hasil Minggu 01 di 
/Users/LENOVO LOQ/oop-202601-250202957/catatan/minggu-01.md.

---
## Keputusan desain

Saya memakai sapaan yang mencantumkan nama, NIM, dan teks Aset-Pinjam. Saya memilih bentuk hasil kalimat sapaan ini supaya mudah dipahami:

`Halo Aset-Pinjam, nama saya Nanang Apriyanto dengan NIM: 250202957`

Pada paradigma prosedural, saya memakai fungsi statis untuk membuat sapaan. Pada paradigma OOP, saya menggunakan field private untuk menyimpan nama dan NIM. Saya juga membuat method sapa() untuk menghasilkan sapaan. Pada paradigma functional, saya memakai lambda untuk membuat fungsi sapaan. Kemudian di minggu ini saya menggunakan sapaan yang sama pada setiap paradigma.

---
## Kendala
Saya mengalami kesulitan dalam memahami langkah langkah dalam mengerjakan tugas setiap minggu untuk setiap tugas yang ada, kemudian menggunakan lambda di Java. Saya bingung dengan cara kerja masing-masing pendekatan dan bagaimana lambda berperan di dalamnya. Untuk mengatasi hal ini, saya belajar, mulai dari membaca contoh kode nyata, lalu memahami fungsi tiap bagian satu per satu. Untuk belajarnya saya biasanya melihat youtube kemudian ada bantuan dari AI agar saya bisa lebih memahami lambda dan codingan yang belum saya ketahui kemudian saya juga bertanya kepada teman.

---
## Penggunaan AI
- Alat yang dipakai: ChatGPT
- Bagian yang dibantu AI: Pemasangan tools yang diperlukan, kemudian membantu saya dalam melakukan langkah langkah dalam mengerjakan tugas, lalu membantu saya dalam memperbaiki pengetikan kode yang salah.
- Prompt utama: Berikan Penjelasan tentang pengerjaan apa saja yang harus saya lakukan minggu 01, sertakan langkah langkah yang harus dilakukan, beserta penjelasannya.
- Yang saya ubah atau tolak dari saran AI, dan alasannya: yang saya ubah adalah hasil kalimat sapaan, karena saran dari AI menghasilkan kalimat sapaan yang tidak sesuai dengan yang ada di tugas.
- Satu hal yang saya pahami lebih baik sekarang: cara menggunakan tiga paradigma pemrograman dalam Java, yaitu prosedural menggunakan fungsi statis, OOP menggunakan class dan objek, serta functional menggunakan lambda.


---
## Kelebihan dan Kekurangan
- Prosedural: Kelebihannya mudah dipahami karena program berjalan lewat langkah-langkah yang jelas. Kekurangannya, jika fitur peminjaman aset bertambah, hubungan antar fungsi bisa makin sulit untuk diatur.

- OOP memiliki kelebihan yaitu Data aset dan peminjam bisa dikelompokkan sesuai kegunaannya. Ini membuat data lebih mudah dikelola. Kekurangannya, orang harus paham class dan objek dulu sebelum bisa membuat program.

- Fungsional punya kelebihan karena bisa membuat fungsi tanpa membuat objek sendiri. Cara ini cocok untuk operasi sederhana. Kekurangannya, kalau fungsi yang dipakai makin banyak, alur program bisa jadi lebih sulit dipahami dan ditelusuri pengguna.