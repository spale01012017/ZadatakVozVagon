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
public class Zadatak2DodavanjeVrednosti {
    static Dao<Voz,Integer> vozDao;
    static Dao<Vagon,Integer> vagonDao;
    public static void main(String[] args) {
        ConnectionSource connectionSource = null;
        try {

            connectionSource = new JdbcConnectionSource("jdbc:sqlite:vozVagon.db");
            vozDao = DaoManager.createDao(connectionSource, Voz.class);
            vagonDao = DaoManager.createDao(connectionSource, Vagon.class);
            Voz v1=new Voz("Voz 1","Dizel");
            vozDao.create(v1);
            Voz v2=new Voz("Voz 2","Elektricni");
            vozDao.create(v2);
            Vagon vag1=new Vagon("Vagon 1","Za porenos goriva",10);
                    vag1.setVoz(v1);
            vagonDao.create(vag1);

            Vagon vag2=new Vagon("Vagon 2","Za prenos toksicnih materija",5);
                    vag2.setVoz(v1);
            vagonDao.create(vag2);
            Vagon vag3=new Vagon("Vagon 3","Za prenos psenice",20);
                    vag3.setVoz(v1);
            vagonDao.create(vag3);
            Vagon vag4=new Vagon("Vagon 4","Za spavanje",5);
                    vag4.setVoz(v2);
            vagonDao.create(vag4);
            Vagon vag5=new Vagon("Vagon 5","Restoran",3);
            vag5.setVoz(v2);
            vagonDao.create(vag5);
            List<Vagon> vagoni=vagonDao.queryForAll();
            for(Vagon vag:vagoni)
                System.out.println("Vagon = " + vag);

            //Prikaz svih vrednosti tabela Avion
            List<Voz> vozovi=vozDao.queryForAll();
            for(Voz v:vozovi)
                System.out.println("Voz  = " + v);








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
