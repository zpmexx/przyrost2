package hibernate.model;

import javax.persistence.*;

@Entity
@Table(name = "firma")
public class Firma {

    @Id
    @GeneratedValue
    @Column(name = "numer_firmy")
    private int numer;


    @Column(name = "nazwa")
    private String nazwa;

    @OneToOne
    @JoinColumn(name = "id_p")
    private Pilkarz pilkarz;

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Firma() {

    }

    public int getNumer() {
        return numer;
    }

    public void setNumer(int numer) {
        this.numer = numer;
    }
}


