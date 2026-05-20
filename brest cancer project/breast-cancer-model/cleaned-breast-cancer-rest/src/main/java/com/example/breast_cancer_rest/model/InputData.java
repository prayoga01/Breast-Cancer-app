
// InputData.java
package com.example.breast_cancer_rest.model;

public class InputData {
    private String faktorRisiko;           // "Faktor Risiko"
    private String benjolanDiPayudara;     // "Benjolan di Payudara"
    private String kecepatanTumbuh;        // "Kecepatan Tumbuh dengan/ tanpa Rasa Sakit"
    private String nippleDischarge;        // "Nipple Discharge"
    private String retraksiPutingSusu;     // "Retraksi putting susu"
    private String krusta;                 // Krusta
    private String dimpling;               // Dimpling
    private String peauDOrange;            // "peau d'orange"
    private String ulserasi;               // ulserasi
    private String venektasi;              // Venektasi
    private String benjolanKetiak;         // "Benjolan Ketiak"
    private String edemaLengan;            // "Edema Lengan"
    private String nyeriTulang;            // "Nyeri tulang"
    private String sesak;                  // Sesak

    // Constructors
    public InputData() {}

    // Getters and Setters
    public String getFaktorRisiko() { return faktorRisiko; }
    public void setFaktorRisiko(String faktorRisiko) { this.faktorRisiko = faktorRisiko; }

    public String getBenjolanDiPayudara() { return benjolanDiPayudara; }
    public void setBenjolanDiPayudara(String benjolanDiPayudara) { this.benjolanDiPayudara = benjolanDiPayudara; }

    public String getKecepatanTumbuh() { return kecepatanTumbuh; }
    public void setKecepatanTumbuh(String kecepatanTumbuh) { this.kecepatanTumbuh = kecepatanTumbuh; }

    public String getNippleDischarge() { return nippleDischarge; }
    public void setNippleDischarge(String nippleDischarge) { this.nippleDischarge = nippleDischarge; }

    public String getRetraksiPutingSusu() { return retraksiPutingSusu; }
    public void setRetraksiPutingSusu(String retraksiPutingSusu) { this.retraksiPutingSusu = retraksiPutingSusu; }

    public String getKrusta() { return krusta; }
    public void setKrusta(String krusta) { this.krusta = krusta; }

    public String getDimpling() { return dimpling; }
    public void setDimpling(String dimpling) { this.dimpling = dimpling; }

    public String getPeauDOrange() { return peauDOrange; }
    public void setPeauDOrange(String peauDOrange) { this.peauDOrange = peauDOrange; }

    public String getUlserasi() { return ulserasi; }
    public void setUlserasi(String ulserasi) { this.ulserasi = ulserasi; }

    public String getVenektasi() { return venektasi; }
    public void setVenektasi(String venektasi) { this.venektasi = venektasi; }

    public String getBenjolanKetiak() { return benjolanKetiak; }
    public void setBenjolanKetiak(String benjolanKetiak) { this.benjolanKetiak = benjolanKetiak; }

    public String getEdemaLengan() { return edemaLengan; }
    public void setEdemaLengan(String edemaLengan) { this.edemaLengan = edemaLengan; }

    public String getNyeriTulang() { return nyeriTulang; }
    public void setNyeriTulang(String nyeriTulang) { this.nyeriTulang = nyeriTulang; }

    public String getSesak() { return sesak; }
    public void setSesak(String sesak) { this.sesak = sesak; }
}