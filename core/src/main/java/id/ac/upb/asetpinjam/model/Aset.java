package id.ac.upb.asetpinjam.model;

import id.ac.upb.asetpinjam.config.Varian;
import id.ac.upb.asetpinjam.kontrak.DapatDipinjam;

/**
 * Aset yang dapat dipinjam.
 *
 * <p>Minggu 2: lengkapi field, konstruktor, getter/setter, dan validasi (encapsulation).
 * Minggu 3: tambahkan getJenis() di tiap subclass.
 * Minggu 4: hitungDenda() dioverride di tiap subclass.
 * Minggu 5: isi bisaDipinjam() dan ubah menjadi class abstrak
 * (TestSupport.aset(...) di folder test menyesuaikan sendiri, lihat docs/minggu-05.md).
 */
public abstract class Aset implements DapatDipinjam {

    // TODO minggu 2: field private: kode, nama, status (default TERSEDIA), kondisi (default BAIK).
    private final String kode;
    private String nama;
    private StatusAset status = StatusAset.TERSEDIA;
    private Kondisi kondisi = Kondisi.BAIK;

    /** TODO minggu 2: kode dan nama tidak boleh null atau kosong (IllegalArgumentException). */
    public Aset(String kode, String nama) {
        if (kode == null || kode.isBlank()) {
            throw new IllegalArgumentException("kode WAJIB memiliki isi dan tidak boleh null ataupun kosong.");
        }

        if (nama == null || nama.isBlank()) {
            throw new IllegalArgumentException("nama WAJIB memiliki isi dan tidak boleh null ataupun kosong.");
        }

        this.kode = kode;
        this.nama = nama;
    }

    public String getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }

    public StatusAset getStatus() {
        return status;
    }

    public Kondisi getKondisi() {
        return kondisi;
    }

    /** TODO minggu 2: nama baru tidak boleh kosong. */
    public void setNama(String nama) {
        if (nama == null || nama.isBlank()) {
            throw new IllegalArgumentException("nama WAJIB memiliki isi dan tidak boleh null ataupun kosong.");
        }
        this.nama = nama;
    }

    /** TODO minggu 2: status tidak boleh null. */
    public void setStatus(StatusAset status) {
        if (status == null){
            throw new IllegalArgumentException("status (setStatus) tidak boleh bernilai null.");
        }
        this.status = status;
    }

    /** TODO minggu 2: kondisi tidak boleh null. */
    public void setKondisi(Kondisi kondisi) {
        if (kondisi == null){
            throw new IllegalArgumentException("kondisi (setKondisi) tidak boleh bernilai null.");
        }
        this.kondisi = kondisi;
    }

    /** TODO minggu 5: true hanya jika status TERSEDIA dan kondisi bukan RUSAK_BERAT. */
    @Override
    public boolean bisaDipinjam() {
        throw new UnsupportedOperationException("TODO minggu 5");
    }

    /** TODO minggu 3: dioverride tiap subclass agar mengembalikan jenis yang benar. */
    public abstract JenisAset getJenis();

    /** TODO minggu 4: denda keterlambatan. Dioverride tiap subclass (aturan di docs/aturan-bisnis.md). */
    public long hitungDenda(int hariTerlambat) {
        if (hariTerlambat < 0) {
            throw new IllegalArgumentException("Hari terlambat tidak boleh bernilai negatif.");
        }
        return (long) hariTerlambat * Varian.aktif().dendaPerHari;
    }
}
