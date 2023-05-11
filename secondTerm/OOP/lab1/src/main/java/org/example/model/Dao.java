package org.example.model;

import java.awt.*;
import java.util.ArrayList;

public interface Dao<T> {
    ArrayList<T> getAll();
    boolean add(T elem);
    boolean delete(T elem);

    boolean update(T elem);

}