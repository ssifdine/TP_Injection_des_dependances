package ma.saifdine.enset.metier;

import ma.saifdine.enset.dao.IDao;

public class MetierImpl implements IMetier{

    private IDao dao;

    // Injection de dependence via le constructeur
    public MetierImpl(IDao dao) {
        this.dao = dao;
    }

    @Override
    public double calcule() {
        double data = dao.getData();
        double res = data * 12 * Math.PI / Math.cos(data);
        return res;
    }
}
