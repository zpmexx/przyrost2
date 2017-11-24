package hibernate.model;

import javax.persistence.*;

@Entity
@Table(name = "pilkarz")
public class Pilkarz {

    @Id
    @GeneratedValue
    @Column(name = "id_p")
    private int id_p;

    @Column(name = "imie")
    private String imie;

    @Column(name = "nazwisko")
    private String nazwisko;

    @Column(name = "wiek")
    private int wiek;

    @Column(name = "narodowosc")
    private String narodowosc;

    public String getKlub() {
        return klub;
    }

    public void setKlub(String klub) {
        this.klub = klub;
    }

    @Column(name ="klub")

    private String  klub;

    @Column(name ="firma")

    private String  firma1;

    public String getFirma1() {
        return firma1;
    }

    public void setFirma1(String firma1) {
        this.firma1 = firma1;
    }

    public Pilkarz() { }

    public int getId_p() {

        return id_p;
    }

    public void setId_p(int id_p) {
        this.id_p = id_p;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public int getWiek() {
        return wiek;
    }




    public void setWiek(int wiek) {
        this.wiek = wiek;
    }

    public String getNarodowosc() {
        return narodowosc;
    }

    public void setNarodowosc(String narodowosc) { this.narodowosc = narodowosc; }
//OneToOne: Piłkarz <=> Firma
    @OneToOne
    @JoinColumn(name = "numer_firmy")
    private Firma firma;


}

