package org.example.model;

import lombok.SneakyThrows;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;



public class UserDao implements Dao<User>{
    private final Connection conn;

    public UserDao() throws SQLException {
         conn = (Connection) DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/OOPLab1",
                "postgres",
                "Slavaupa1488"
        );

    }

    @SneakyThrows
    public Optional<User> get(String mail){
        PreparedStatement statement = conn.prepareStatement("select * from users where mail = ?");
        statement.setString(1, mail);
        ResultSet res = statement.executeQuery();
        String _mail;
        String password;
        String role;
        User user = null;
        if (res.next()) {
            _mail = res.getString("mail");
            password = res.getString("password");
            role = res.getString("role");
            user = new User(_mail,password,role);
        }
        return Optional.ofNullable(user);
    }

    @SneakyThrows
    @Override
    public ArrayList<User> getAll() {
        PreparedStatement statement = conn.prepareStatement("select * from users");
        ResultSet res = statement.executeQuery();
        ArrayList<User> userList = new ArrayList<>();
        User curr = null;
        while (res.next()) {
            String mail = res.getString("mail");
            String password = res.getString("password");
            String role = res.getString("role");
            curr = new User(mail, password, role);
            userList.add(curr);
        }
        return userList;
    }

    @SneakyThrows
    @Override
    public boolean add(User elem) {
        PreparedStatement statement = conn.prepareStatement("insert into users (mail,password,role) values (?,?,?)");
        statement.setString(1, elem.getMail());
        statement.setString(2, elem.getPassword());
        statement.setString(3, elem.getRole().toString());
        return statement.execute();
    }

    @SneakyThrows
    @Override
    public boolean delete(User elem) {
        PreparedStatement statement = conn.prepareStatement("delete from users where mail = ?");
        statement.setString(1, elem.getMail());
        return statement.execute();
    }

    @SneakyThrows
    @Override
    public boolean update(User elem) {
        PreparedStatement statement = conn.prepareStatement("update users set mail = ?, password = ?, role = ? where mail = ?");
        statement.setString(4,elem.getMail());
        statement.setString(1,elem.getMail());
        statement.setString(2,elem.getPassword());
        statement.setString(3,elem.getRole());
        return statement.execute();
    }
}
