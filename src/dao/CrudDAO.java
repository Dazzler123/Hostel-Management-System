package dao;

import entity.Room;

import java.util.List;

public interface CrudDAO<T, ID> extends SuperDAO { //T as entity classes and ID as data type
    public List<T> getAll();

    public T get(ID id);

    public List<T> search(ID id);

    public boolean save(T entity);

    public boolean update(T entity);

    public boolean delete(ID id);
}
