package id.ac.upb.asetpinjam.mahasiswa;

import static id.ac.upb.asetpinjam.TestSupport.pinjam;
import static org.assertj.core.api.Assertions.assertThat;

import id.ac.upb.asetpinjam.TestSupport;
import id.ac.upb.asetpinjam.jadwal.JadwalPeminjaman;
import id.ac.upb.asetpinjam.model.Peminjaman;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * FOLDER INI MILIK ANDA. Tulis tes Anda sendiri di sini (minggu 7 dan seterusnya).
 *
 * <p>Tes dosen sengaja tidak menentukan: apakah peminjaman 09:00-11:00 dan 11:00-13:00 pada aset yang sama
 * bentrok? Putuskan, catat alasannya di docs/asumsi.md, lalu tuliskan tesnya di sini.
 * Hapus @Disabled setelah Anda mengisinya.
 *
 * <p>Syarat minggu 10: folder ini memuat minimal 8 tes (tidak termasuk contoh bawaan ini).
 */
@Tag("week7")
class BatasBentrokTest {

    @Test
    void selesaiSamaDenganMulai() {
        // TODO: buat dua peminjaman pada aset yang sama, satu selesai tepat saat yang lain mulai,
        // lalu nyatakan hasil yang Anda putuskan dengan assertThat(...).
        JadwalPeminjaman jadwal = new JadwalPeminjaman(2);
        jadwal.tambah(pinjam("1", TestSupport.peminjam("P1"), TestSupport.ruang("R-1"), 9, 11));

        Peminjaman mulaiSaatLamaSelesai = pinjam("2", TestSupport.peminjam("P2"), TestSupport.ruang("R-1"), 11, 13);
        assertThat(jadwal.bentrok(mulaiSaatLamaSelesai)).isFalse();

        Peminjaman selesaiSaatLamaMulai = pinjam("3", TestSupport.peminjam("P3"), TestSupport.ruang("R-1"), 7, 9);
        assertThat(jadwal.bentrok(selesaiSaatLamaMulai)).isFalse();
    }
}
