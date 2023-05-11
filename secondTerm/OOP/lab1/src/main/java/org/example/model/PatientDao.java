package org.example.model;
import lombok.SneakyThrows;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public class PatientDao implements Dao<Patient> {
    private final Connection conn;

    public PatientDao() throws SQLException {
        conn = (Connection) DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/OOPLab1",
                "postgres",
                "Slavaupa1488"
        );

    }

    @SneakyThrows
    public Optional<Patient> get(String name){
        PreparedStatement statement = conn.prepareStatement("select * from patient where name = ?");
        statement.setString(1,name);
        ResultSet res = statement.executeQuery();
        String _name;
        String procedures;
        String diagnosis;
        String medicines;
        String operations;
        String health_status;
        int id;
        Patient patient = null;
        if (res.next()) {
            id= res.getInt("patient_id");
            _name=res.getString("name");
            procedures=res.getString("procedures");
            diagnosis=res.getString("diagnosis");
            medicines=res.getString("medicines");
            operations=res.getString("operations");
            health_status=res.getString("health_status");
            patient = new Patient(id,_name,procedures,diagnosis,medicines,operations,health_status);
        }
        return Optional.ofNullable(patient);
    }

    @SneakyThrows
    @Override
    public ArrayList<Patient> getAll() {
        PreparedStatement statement = conn.prepareStatement("select * from patient");
        ResultSet res = statement.executeQuery();
        ArrayList<Patient> patientList = new ArrayList<>();
        Patient curr = null;
        while (res.next()) {
            int id = res.getInt("patient_id");
            String name = res.getString("name");
            String procedures = res.getString("procedures");
            String diagnosis = res.getString("diagnosis");
            String medicines = res.getString("medicines");
            String operations = res.getString("operations");
            String health_status = res.getString("health_status");
            curr = new Patient(id,name,procedures,diagnosis,medicines,operations,health_status);
            patientList.add(curr);
        }
        return patientList;
    }

    @SneakyThrows
    @Override
    public boolean add(Patient elem) {
        PreparedStatement statement = conn.prepareStatement("insert into patient (name,procedures,diagnosis,medicines,operations,health_status) values (?,?,?,?,?,?)");
        statement.setString(1, elem.getName());
        statement.setString(2, elem.getProcedures());
        statement.setString(3, elem.getDiagnosis());
        statement.setString(4, elem.getMedicines());
        statement.setString(5, elem.getOperations());
        statement.setString(6, elem.getHealth_status());
        return statement.execute();
    }

    @SneakyThrows
    @Override
    public boolean delete(Patient elem) {
        PreparedStatement statement = conn.prepareStatement("delete from patient where name = ?");
        statement.setString(1, elem.getName());
        return statement.execute();
    }

    @SneakyThrows
    @Override
    public boolean update(Patient elem) {
        PreparedStatement statement = conn.prepareStatement("update patient set name = ?, procedures = ?, diagnosis = ?, medicines = ?, operations = ?, health_status =? where name = ?");
        statement.setString(1,elem.getName());
        statement.setString(2,elem.getProcedures());
        statement.setString(3,elem.getDiagnosis());
        statement.setString(4,elem.getMedicines());
        statement.setString(5,elem.getOperations());
        statement.setString(6,elem.getHealth_status());
        statement.setString(7,elem.getName());
        return  statement.execute();
    }
}
