package hibernate.model;

import javax.persistence.*;

@Entity
@Table(name = "zespol")
public class Zespol {

    @Id
    @GeneratedValue
    @Column(name = "nr")
    private int nr;

    @Column(name = "nazwa",unique = true)
    private String nazwa;

    @Column(name = "miejsowosc")
    private String miejscowosc;

    @Column(name = "rok")
    private int rok;

    public int getRok() {
        return rok;
    }

    public void setRok(int rok) {
        this.rok = rok;
    }

    public Zespol() { }

    public int getNr() {

        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getMiejscowosc() {
        return miejscowosc;
    }

    public void setMiejscowosc(String miejscowosc) {
        this.miejscowosc = miejscowosc;
    }



}
