# Prinsip SOLID yang terlihat

Saya memilih tiga prinsip yang paling jelas terlihat di kode saat ini: OCP, LSP, dan DIP. Saya tidak memaksakan kelima prinsip kalau buktinya tidak ada. Untuk setiap prinsip, saya sebutkan kelas yang menjadi contoh dan alasan kenapa menurut saya kode itu memenuhi prinsip tersebut.

## 1. Open/Closed Principle: `Aset` dan turunannya

`Aset` adalah class abstrak yang menyimpan data dasar aset. Method `getJenis()` dan `hitungDenda()` dibuat abstrak, jadi kelas lain bisa memakai `Aset` tanpa perlu tahu jenis aset yang sedang dipakai. `KatalogAset` menyimpan `List<Aset>` dan `Peminjaman` menyimpan field `Aset`. Saat `Ruang`, `Laptop`, dan `AlatLab` ditambahkan, kelas-kelas pemakai itu tidak diubah. Kalau nanti ada jenis aset baru, saya cukup membuat subclass baru dan menambahkan satu nilai di `JenisAset`; logika pencarian dan penjadwalan tetap sama. Dengan begitu, logika klien tertutup untuk modifikasi, tetapi perilaku baru tetap bisa masuk lewat subclass.

Titik ekstensi lain ada di `kontrak/AturanDenda`. `DendaFlat` dan `DendaProgresif` mengimplementasikan interface yang sama, jadi aturan denda baru bisa dibuat sebagai kelas baru tanpa mengubah dua kelas denda yang sudah ada. Saya perlu jujur bahwa `LayananDenda` yang akan memakai aturan ini masih TODO minggu 10, jadi yang sudah terlihat di kode minggu 6 adalah kontrak dan implementasinya, belum alur lengkapnya.

## 2. Liskov Substitution Principle: `Ruang`, `Laptop`, dan `AlatLab`

Ketiga kelas itu bisa dipakai di tempat `Aset` tanpa mengubah pemanggil. `KatalogAset.tambah(Aset)` dan field `Peminjaman.aset` bertipe `Aset`, sedangkan `Minggu05AbstraksiTest` membuat `List<Aset>` berisi ketiga jenis lalu memanggil `bisaDipinjam()`. Hasil `hitungDenda()` memang berbeda karena multiplier-nya 1x, 2x, dan 4x, tetapi kontraknya tetap sama: hari negatif ditolak di `dendaDasar()`, hasilnya tidak negatif, dan tidak ada exception tak terduga untuk input yang sah. Beda hasil bukan pelanggaran LSP selama janji method tetap dipenuhi.

## 3. Dependency Inversion Principle: `JdbcPeminjamanDAO`, `AsetDAO`, dan `AsetService`

`JdbcPeminjamanDAO` tidak membuat koneksi sendiri dan tidak membuat `JdbcAsetDAO` di dalam konstruktornya. Konstruktornya menerima `Supplier<Connection>` dan `AsetDAO`, jadi kelas ini bergantung pada abstraksi. Kalau tes membutuhkan database palsu, cukup berikan supplier dan DAO lain; kelas ini tidak perlu diubah. Contoh yang sama terlihat di `AsetService`: field-nya bertipe `AsetRepository`, bukan `InMemoryAsetRepository`, dan implementasinya diberikan lewat konstruktor. Itu sebabnya DIP membantu testability: tes bisa mengganti database dengan objek palsu tanpa menyentuh logika service.

## Tdak ada refactor

Saya belum melakukan refactor karena pada tahap pengerjaan minggu ini belum ada kebutuhan untuk mengubah atau menambahkan bagian kode. Tiga prinsip SOLID yang dipilih juga sudah terlihat dari struktur kode yang ada. Selain itu, pengerjaan minggu ini lebih berfokus pada pembuatan diagram UML dan dokumentasi penerapan SOLID, sehingga perubahan kode belum diperlukan dan bisa dilakukan pada tahap pengembangan berikutnya jika memang dibutuhkan.
