package id.ac.upb.asetpinjam.model;

/** Minggu 3: aset berupa ruang. Kapasitas harus lebih dari 0 (IllegalArgumentException). */
public class Ruang extends Aset {

    // TODO minggu 3: field kapasitas.
    private final int kapasitas;

    public Ruang(String kode, String nama, int kapasitas) {
        super(kode, nama);

        if (kapasitas < 1) {
            throw new IllegalArgumentException("Kapasitas ruang harus lebih dari 0 agar daya tampungnya valid dan tidak bernilai nol atau negatif.");
        }

        this.kapasitas = kapasitas;
    }

    public int getKapasitas() {
        return kapasitas;
    }

    @Override 
    public JenisAset getJenis(){
        return JenisAset.RUANG;
    }

    // TODO minggu 3: override getJenis(). Minggu 4: override hitungDenda(int).
}
