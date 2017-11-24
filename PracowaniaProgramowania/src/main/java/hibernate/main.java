package hibernate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import hibernate.model.Firma;
import hibernate.model.Pilkarz;
import hibernate.model.Zespol;
import zapytania.zapytania;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.File;

class main {

    public static void main(String[] args) {

        System.out.println("ZACZYNAMY");


        EntityManager entityManager = null;

        EntityManagerFactory entityManagerFactory = null;
        zapytania zapytania = null;

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");

            entityManager = entityManagerFactory.createEntityManager();


            entityManager.getTransaction().begin();

            zapytania zap = new zapytania(entityManager);

            Pilkarz x = new Pilkarz();
            x.setImie("Cristiano");
            x.setNazwisko("Ronaldo");
            x.setNarodowosc("Portugalia");
            x.setWiek(30);
            x.setKlub("Chelsea");

            Pilkarz x2 = new Pilkarz();
            x2.setImie("Lionel");
            x2.setNazwisko("Messi");
            x2.setNarodowosc("Argentyna");
            x2.setWiek(29);
            x2.setKlub("Chelsea");

            Zespol z = new Zespol();
           z.setNazwa("Chelsea");
           z.setMiejscowosc("London");
           z.setRok(1905);
            Firma f = new Firma();
            f.setNazwa("Adidas");

            x.setFirma1("Adidas");



            entityManager.persist(x);
            entityManager.persist(x2);
            entityManager.persist(z);
            entityManager.persist(f);


//wartosci generowane

            Pilkarz nowy = entityManager.find(Pilkarz.class, x.getId_p());
            Pilkarz nowy2 = entityManager.find(Pilkarz.class, x2.getId_p());
            Zespol zespol1 = entityManager.find(Zespol.class, z.getNr());
            Firma firma = entityManager.find(Firma.class, f.getNumer());



            ObjectMapper map = new ObjectMapper();

//T JSON
            map.writeValue(new File("Pilkarz.json"), x);
            map.writeValue(new File("Pilkarz.json"), x2);
            map.writeValue(new File("Zespól.json"), z);
            map.writeValue(new File("Firma.json"), f);
//XML
            XmlMapper mapper = new XmlMapper();
            mapper.writeValue(new File("Piłkarz.xml"),x);
            mapper.writeValue(new File("Piłkarz.xml"),x2);
            mapper.writeValue(new File("Zespół.xml"),z);
            mapper.writeValue(new File("Firma.xml"),f);




            entityManager.getTransaction().commit();

            System.out.println("Zakonczono dzialanie programu");

            entityManager.close();

        } catch (Throwable ex) {
            System.err.println("Cos poszlo nie tak." + ex);
        } finally {
            entityManagerFactory.close();
        }

    }

    }
