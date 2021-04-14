package by.catalog.storage;

import by.catalog.domain.Advert;
import by.catalog.domain.Message;
import by.catalog.domain.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdvertStorage {


    private final static String URL_TABLES = "jdbc:postgresql://localhost:5432/postgres";
    private final static String LOGIN_TABLES = "postgres";
    private final static String PASS_TABLES = "aili61329";
    Connection connection = null;

    {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addAdvert(Advert advert) {
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement("insert into advert (id, mark, model, color, yearcar, price, id_user, dateadvert, specificationadvert) values (default , ?, ? , ? , ? , ?, ?, ?, ?)");
            preparedStatement.setString(1, advert.getMarkCar());
            preparedStatement.setString(2, advert.getModelCar());
            preparedStatement.setString(3, advert.getColorCar());
            preparedStatement.setInt(4, advert.getYearCar());
            preparedStatement.setDouble(5, advert.getPriceCar());
            preparedStatement.setLong(6, advert.getIdUser());
            preparedStatement.setString(7, advert.getDateAdvert());
            preparedStatement.setString(8, advert.getSpecificationAdvert());
            preparedStatement.executeQuery();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public Advert returnAdvertById(long idAdvert) {
        MessageStorage messageStorage = new MessageStorage();
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement("select * from advert s where s.id = ?");
            preparedStatement.setLong(1, idAdvert);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            long id = resultSet.getLong(1);
            String mark = resultSet.getString(2);
            String model = resultSet.getString(3);
            String color = resultSet.getString(4);
            int yearCar = resultSet.getInt(5);
            double price = resultSet.getDouble(6);
            long idUser = resultSet.getLong(7);
            String date = resultSet.getString(8);
            String specification = resultSet.getString(9);
            List<Message> messages = messageStorage.returnMessageByIdAdvert(idAdvert);
            connection.close();
            return new Advert(id, mark, model, color, yearCar, price, idUser, date, specification, messages);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Advert returnAdvertByIdAdvertAndIdUser(long idAdvert, long idUser) {
        MessageStorage messageStorage = new MessageStorage();
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement("select * from advert s where s.id = ? and s.id_user = ?");
            preparedStatement.setLong(1, idAdvert);
            preparedStatement.setLong(2, idUser);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            String mark = resultSet.getString(2);
            String model = resultSet.getString(3);
            String color = resultSet.getString(4);
            int yearCar = resultSet.getInt(5);
            double price = resultSet.getDouble(6);
            String date = resultSet.getString(8);
            String specification = resultSet.getString(9);
            List<Message> messages = messageStorage.returnMessageByIdAdvert(idAdvert);
            connection.close();
            return new Advert(idAdvert, mark, model, color, yearCar, price, idUser, date, specification, messages);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Advert> getAllAdvertByIdUser(long idUser) {
        MessageStorage messageStorage = new MessageStorage();
        List<Advert> adverts = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement("select * from advert s where s.id_user = ?");
            preparedStatement.setLong(1, idUser);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getLong(1);
                String mark = resultSet.getString(2);
                String model = resultSet.getString(3);
                String color = resultSet.getString(4);
                int yearCar = resultSet.getInt(5);
                double price = resultSet.getDouble(6);
                String date = resultSet.getString(8);
                String specification = resultSet.getString(9);
                List<Message> messages = messageStorage.returnMessageByIdAdvert(id);
                connection.close();
                adverts.add(new Advert(id, mark, model, color, yearCar, price, idUser, date, specification, messages));
            }
            return adverts;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addIdUserIdAdvert(long idUser, long idAdvert) {
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement("insert into useradvertlist (iduser, idadvert) values (?, ?)");
            preparedStatement.setLong(1, idUser);
            preparedStatement.setLong(2, idAdvert);
            preparedStatement.executeQuery();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List getAllIdAdvertByIdUser(long idUser) {
        ArrayList<Long> list = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement("select * from useradvertlist s where s.iduser = ?");
            preparedStatement.setLong(1, idUser);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long idAdvert = resultSet.getLong(2);
                list.add(idAdvert);
            }
            connection.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Advert> getAllAdverts() {
        List<Advert> list = new ArrayList<>();
        try {
            long id = 0;
            String mark = "";
            String model = "";
            String color = "";
            int year = 0;
            double price = 0;
            long idUser = 0;
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement("select * from advert");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getLong(1);
                mark = resultSet.getString(2);
                model = resultSet.getString(3);
                color = resultSet.getString(4);
                year = resultSet.getInt(5);
                price = resultSet.getDouble(6);
                idUser = resultSet.getLong(7);
                Advert advert = new Advert(id, mark, model, color, year, price, idUser);
                list.add(advert);
            }
            connection.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public List<String> getModelByMark(String mark) {
        ArrayList<String> list = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement("select * from car s where s.mark = ?");
            preparedStatement.setString(1, mark);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String model = resultSet.getString(2);
                list.add(model);
            }
            connection.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String> getMarkByModel(String model) {
        ArrayList<String> list = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement("select * from car s where s.model = ?");
            preparedStatement.setString(1, model);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String mark = resultSet.getString(3);
                list.add(mark);
            }
            connection.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String> getAllMark() {
        ArrayList<String> listMark = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement("select * from car");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String mark = resultSet.getString(1);
                listMark.add(mark);
            }
            connection.close();
            return listMark;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String> getAllModel() {
        ArrayList<String> listModel = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement("select * from car");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String model = resultSet.getString(2);
                listModel.add(model);
            }
            connection.close();
            return listModel;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public List<String> getAllAdvertMark() {
        ArrayList<String> listAdvertMark = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement("select * from advert");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String mark = resultSet.getString(2);
                listAdvertMark.add(mark);
            }
            connection.close();
            return listAdvertMark;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public void removeIdAdvertIdUser(long idAdvert, long idUser) {
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement("delete from useradvertlist where iduser = ? and idadvert = ?");
            preparedStatement.setLong(1, idUser);
            preparedStatement.setLong(2, idAdvert);
            preparedStatement.executeQuery();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeAfterDestroyUserAdvertList(long idAdvert) {
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement("delete from useradvertlist where idadvert = ?");
            preparedStatement.setLong(1, idAdvert);
            preparedStatement.executeQuery();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean checkIdUserIdAdvert(long idUser, long idAdvert) {
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement("select * from useradvertlist s where s.iduser = ? and s.idadvert = ?");
            preparedStatement.setLong(1, idUser);
            preparedStatement.setLong(2, idAdvert);
            ResultSet resultSet = preparedStatement.executeQuery();
            boolean next = resultSet.next();
            connection.close();
            return next;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void removeAdvertByIdAdvert(long idAdvert, long idUser) {
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement("delete from advert where id = ? and id_user = ? ");
            preparedStatement.setLong(1, idAdvert);
            preparedStatement.setLong(2, idUser);
            preparedStatement.executeQuery();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateMarkAndModelById(long idAdvert, long idUser, String mark, String model) {
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement("update advert set mark= ?, model = ?  where id = ? and id_user = ?");
            preparedStatement.setString(1, mark);
            preparedStatement.setString(2, model);
            preparedStatement.setLong(3, idAdvert);
            preparedStatement.setLong(4, idUser);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateColorById(long idAdvert, long idUser, String color) {
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement("update advert set color= ? where id = ? and id_user = ?");
            preparedStatement.setString(1, color);
            preparedStatement.setLong(2, idAdvert);
            preparedStatement.setLong(3, idUser);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateYearById(long id, long idUser,int year) {
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement("update advert set yearcar= ? where id = ? and id_user = ?");
            preparedStatement.setInt(1, year);
            preparedStatement.setLong(2, id);
            preparedStatement.setLong(3, idUser);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePriceById(long id, long idUser, double price){
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement("update advert set price= ? where id = ? and id_user = ?");
            preparedStatement.setDouble(1, price);
            preparedStatement.setLong(2, id);
            preparedStatement.setLong(3, idUser);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateSpecificationById(long id, long idUser, String specification){
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement("update advert set specificationadvert = ? where id = ? and id_user = ?");
            preparedStatement.setString(1, specification);
            preparedStatement.setLong(2, id);
            preparedStatement.setLong(3, idUser);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
