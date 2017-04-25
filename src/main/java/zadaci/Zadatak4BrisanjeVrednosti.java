package zadaci;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

import java.io.IOException;

/**
 * Created by androiddevelopment on 25.4.17..
 */
public class Zadatak4BrisanjeVrednosti {
    public static void main(String[] args) {
        ConnectionSource connectionSource = null;
        try {

            connectionSource = new JdbcConnectionSource("jdbc:sqlite:vozVagon.db");



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
