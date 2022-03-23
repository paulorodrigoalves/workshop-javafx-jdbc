package com.example.workshojavafxjdbc.services;

import com.example.workshojavafxjdbc.model.dao.DaoFactory;
import com.example.workshojavafxjdbc.model.dao.DepartmentDao;
import com.example.workshojavafxjdbc.model.entities.Department;

import java.util.List;

public class DepartmentService {

    private DepartmentDao dao = DaoFactory.createDepartmentDao();

    public List<Department> findAll(){

        return dao.findAll();
    }

    public void saveOrUpdate(Department obj){
        if(obj.getId() == null){
            dao.insert(obj);
        }else{
            dao.update(obj);
        }
    }
}
