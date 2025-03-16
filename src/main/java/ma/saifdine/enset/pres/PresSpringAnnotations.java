package ma.saifdine.enset.pres;

import ma.saifdine.enset.metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PresSpringAnnotations {

    public static void main(String[] args) {

        // Initialiser le contexte Spring base sur les annotations
        ApplicationContext conetxt = new AnnotationConfigApplicationContext("ma.saifdine.enset");

        // Recuperer le bean metier
        IMetier metier = (IMetier) conetxt.getBean(IMetier.class);

        // Utiliser le bean
        System.out.println("Resultat : " + metier.calcule());

    }
}
