package be.vdab.dao.impl;

import be.vdab.be.vdab.dao.ShopDao;
import be.vdab.entiteiten.Eshop;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static be.vdab.be.database.MySqlConnection.getConnection;

public class ShopDaoImpl implements ShopDao {

    private Eshop shop =null;
    private List<Eshop> listEschops;
    private static int KOLOM_ID;
    private static String KOLOM_INFO;
    private static String KOLOM_ADDRESS;
    private static String KOLOM_PLAATS;


    @Override
    public List<Eshop> listAllShops() {
        listEschops = new ArrayList<>();
        String sql = "select * from eshop";
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                KOLOM_ID = rs.getInt("eshopId");
                KOLOM_INFO = rs.getString("info");
                KOLOM_ADDRESS = rs.getString("adress");
                KOLOM_PLAATS = rs.getString("plaats");
                shop = new Eshop(KOLOM_ID, KOLOM_INFO, KOLOM_ADDRESS, KOLOM_PLAATS);
                if (shop != null) {
                    listEschops.add(shop);
                }
                //System.out.println("shop toegevoegd");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listEschops;
    }
}
