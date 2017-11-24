package zapytania;

import hibernate.model.Pilkarz;
import hibernate.model.Zespol;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class zapytania {

    EntityManager entityManager;

    public zapytania(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Pilkarz> zapytanie1() {
        TypedQuery<Pilkarz> query = entityManager.createQuery("SELECT a FROM Pilkarz a", Pilkarz.class);
        return query.getResultList();
    }
    public List<Zespol> zapytanie2() {
        TypedQuery<Zespol> query = entityManager.createQuery("SELECT b FROM Zespol b", Zespol.class);
        return query.getResultList();
    }
    public List<Zespol> zapytanie3() {
        TypedQuery<Zespol> query = entityManager.createQuery("SELECT c FROM Zespol c where nazwa in (select klub from Pilkarz )", Zespol.class);
        return query.getResultList();
    }
    public List<Pilkarz> zapytanie4() {
        TypedQuery<Pilkarz> query = entityManager.createQuery("SELECT d FROM Pilkarz d where narodowosc = 'Portugalia' ", Pilkarz.class);
        return query.getResultList();
    }
    public List<Pilkarz> zapytanie5() {
        TypedQuery<Pilkarz> query = entityManager.createQuery("SELECT d FROM Pilkarz d where wiek > 29 ", Pilkarz.class);
        return query.getResultList();
    }

}
