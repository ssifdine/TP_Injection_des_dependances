package ma.saifdine.enset.pres;

import ma.saifdine.enset.metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PresSpringXML {

    public static void main(String[] args) {

        // Charger le contexte Spring a partir du fichier XML
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        // Recuperer le bean metier
        IMetier metier = (IMetier) context.getBean("metier");

        // Utiliser le bean
        System.out.println("Resultat : " + metier.calcule());

    }
}
