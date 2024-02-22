package doranco.jpaSimple.dao;


import java.sql.SQLException;
import java.util.List;

import fr.doranco.jpaSimple.entity.Livre;

public interface ILivreDao extends ICrud<Livre> {
    public List<Livre> searchByTitle(String title) throws SQLException;
}
