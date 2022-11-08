package repository;

import model.Facility;

import java.util.List;

public interface IFacilityRepository {
    boolean add(Facility facility);

    List<Facility> findByName(String str);

    List<Facility> findAll();

    boolean remove(int id);

    boolean update(int id,Facility facility);
}
