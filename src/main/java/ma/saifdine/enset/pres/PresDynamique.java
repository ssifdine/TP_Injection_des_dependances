package ma.saifdine.enset.pres;

import ma.saifdine.enset.dao.IDao;
import ma.saifdine.enset.metier.IMetier;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class PresDynamique {

    public static void main(String[] args) {

        try {
            // Lire le fichier de configuration
            Scanner sc = new Scanner(new File("config.txt"));

            //Variables pour stocker les noms de classes
            String daoClassName = null;
            String metierClassName = null;

            // Lire chaque ligne du fichier
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if(line.startsWith("dao=")){
                    daoClassName = line.substring(4);
                }else if(line.startsWith("metier=")){
                    metierClassName = line.substring(7);
                }
            }

            sc.close();

            // Charger la classe DAO et creer une instance
            Class<?> daoClass = Class.forName(daoClassName);
            IDao dao = (IDao) daoClass.getDeclaredConstructor().newInstance();

            // Charger la classe Metier
            Class<?> metierClass = Class.forName(metierClassName);

            // Rechercher le constructeur qui prend un IDao en parametre
            Constructor<?> constructor = metierClass.getConstructor(IDao.class);

            // Instancier la classe Metier en injectant le DAO
            IMetier metier = (IMetier) constructor.newInstance(dao);

            // Utiliser l'object metier
            System.out.println("Resultat du clacul : "+ metier.calcule());

        } catch (FileNotFoundException e) {
            System.err.println("Fichier de configuration introuvable : " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Classe non trouvée : " + e.getMessage());
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            System.err.println("Erreur lors de l'instanciation : " + e.getMessage());
        }

    }
}
