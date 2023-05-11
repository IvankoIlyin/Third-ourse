package org.example.model;

import lombok.Data;

@Data
public class Patient {
    private  int id;
    private String name;
    private String procedures;
    private String diagnosis;
    private String medicines;
    private String operations;
    private String health_status;

    public  Patient(int _id, String _name, String _procedures, String _diagnosis, String _medicines, String _operations, String _health_status){
        this.id=_id;
        this.name=_name;
        this.procedures=_procedures;
        this.diagnosis=_diagnosis;
        this.medicines=_medicines;
        this.operations=_operations;
        this.health_status=_health_status;
    }
}
