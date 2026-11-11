# Asumsi dan Keputusan Desain

Isi bagian ini sendiri. Satu entri per keputusan. Dinilai dari kejelasan alasan dan konsistensi dengan kode dan tes Anda,
bukan dari jawaban "benar".

Format tiap entri:

```
## A-NN: judul singkat
- Pertanyaan: ...
- Keputusan: ...
- Alasan: ...
- Dampak ke kode: ... (kelas/metode)
- Tes yang membuktikan: ... (nama tes di folder mahasiswa/)
```

## Aturan ambigu dari docs/aturan-bisnis.md

Salin setiap pertanyaan ambigu (nomor 1 sampai 7) ke sini dan jawab. Contoh:

## A-01: batas waktu bentrok
- Pertanyaan: 09:00-11:00 dan 11:00-13:00 pada aset yang sama bentrok atau tidak?
- Keputusan: (isi)
- Alasan: (isi)
- Dampak ke kode: (isi)
- Tes yang membuktikan: (isi)

## Asumsi lain

Tambahkan di sini keputusan lain yang Anda ambil: rumus denda progresif, perubahan skema database, format error API, dan seterusnya.

## A-01: batas waktu bentrok
- Pertanyaan: 09:00-11:00 dan 11:00-13:00 pada aset yang sama bentrok atau tidak?
- Keputusan: Tidak bentrok(false)
- Alasan: karenaa sistem memeriksa apkah waktu mulai peminjaman baru lebih awal dari waktu selesai peminjaman lama dan sebaliknya. Karena kedua waktu hanya bertemu tepat pada batas selesai dan mulai, tidak ada waktu yang saling tumpang tindih.Karna kedua peminjaman tidak berlangsung pada waktu yang bersamaan. Jadi ini itu seperti peminjam pertama selesai meminjam laptop pukul 11.00, lalu peminjam kedua mulai meminjam pada pukul 11.00 tepat setelah peminjam pertama selesai, sehingga peminjam kedua tersebut bisa meminjam laptop tersebut tanpa bentrok. 
- Dampak ke kode: `JadwalPeminjaman.java` –> `bentrok()` dan `ajukan()`, `BatasBentrokTest.java` –> `selesaiSamaDenganMulai()`
- Tes yang membuktikan: `mahasiswa/BatasBentrokTest.java`, method `selesaiSamaDenganMulai`, `Minggu07JadwalTest.java`.

## A-02: Rumus denda progresif
- Pertanyaan: Bagaimana denda bertambah seiring lama keterlambatan?
- Keputusan: Denda = denda flat + (hari terlambat / 7) x denda satu hari. Setiap kelipatan 7 hari terlambat menambah denda sebesar satu hari.
- Alasan: Rumusnya sederhana dan mudah dijelaskan. Denda tetap sama dengan flat pada hari 1-6, lalu naik bertahap setiap minggu, sehingga tidak pernah lebih murah dan tidak pernah turun.
- Dampak ke kode: `denda/DendaProgresif.hitung(Aset, int)`.
- Tes yang membuktikan: `Minggu05AbstraksiTest.java`.

## A-03: Hitungan denda dipindah ke dendaDasar
- Pertanyaan: Bagaimana subclass tetap memakai hitungan denda dasar setelah hitungDenda di Aset dijadikan abstract?
- Keputusan: Isi `hitungDenda` yang lama saya pindahkan ke method `dendaDasar` di Aset, lalu `hitungDenda` saya jadikan `abstract`. Kemudian di Ruang, Laptop, dan AlatLab saya mengganti pemanggilan dengan menggunakan`super.dendaDasar` dan mengalikannya dengan multiplier jenisnya: 1x, 2x, dan 4x.
- Alasan: Method abstract tidak punya isi, sehingga tidak bisa dipanggil lewat `super`.
- Dampak ke kode: `Aset.dendaDasar`, `Aset.hitungDenda`, serta `hitungDenda` di Ruang, Laptop, dan AlatLab.
- Tes yang membuktikan: `Minggu05AbstraksiTest.java`