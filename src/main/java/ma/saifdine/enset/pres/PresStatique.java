package ma.saifdine.enset.pres;

import ma.saifdine.enset.dao.DaoImpl;
import ma.saifdine.enset.metier.IMetier;
import ma.saifdine.enset.metier.MetierImpl;

public class PresStatique {

    public static void main(String[] args) {

        IMetier metier = new MetierImpl(new DaoImpl());

        double result = metier.calcule();

        System.out.println(result);

    }
}
