package dao;

import model.EmplProj;

import java.util.List;

public interface EmplProjDAO {
    
    //create
    void add(EmplProj emplProj);
    //read all
    List<EmplProj> getAll();
    EmplProj getById(Long id);
    //update
    void update(EmplProj emplProj);
    //delete
    void delete(EmplProj emplProj);
    
}
