package zadaci;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import model.Vagon;
import model.Voz;

import java.io.IOException;
import java.util.List;

/**
 * Created by androiddevelopment on 25.4.17..
 */
public class Zadatak4BrisanjeVrednosti {
    static Dao<Voz,Integer> vozDao;
    static Dao<Vagon,Integer> vagonDao;
    public static void main(String[] args) {
        ConnectionSource connectionSource = null;
        try {

            connectionSource = new JdbcConnectionSource("jdbc:sqlite:vozVagon.db");
            vozDao = DaoManager.createDao(connectionSource, Voz.class);
            vagonDao = DaoManager.createDao(connectionSource, Vagon.class);

            //Prikaz vrednosti tabele Roba
            List<Vagon> vagoni=vagonDao.queryForAll();
            for(Vagon v:vagoni)
                System.out.println("Vagon = " + v);


            List<Vagon> pronadjen=vagonDao.queryForEq(Vagon.POLJE_NOSIVOST,10);
            Vagon nosivostZaBrisanje=pronadjen.get(0);

            vagonDao.delete(nosivostZaBrisanje);
            vagoni=vagonDao.queryForAll();
            for(Vagon v:vagoni)
                System.out.println("Vagon = " + v);



        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (connectionSource != null) {
                try {
                    //Zatvaranje konekcije sa bazom
                    connectionSource.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
