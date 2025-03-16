package ma.saifdine.enset.dao;

import org.springframework.stereotype.Repository;

@Repository("dao")
public class DaoImpl implements IDao{

    @Override
    public double getData() {
        double data = 78;
        return data;
    }
}
