package com.example.workshojavafxjdbc.model.dao;

import com.example.workshojavafxjdbc.db.DB;
import com.example.workshojavafxjdbc.model.dao.impl.DepartmentDaoJDBC;
import com.example.workshojavafxjdbc.model.dao.impl.SellerDaoJDBC;

public class DaoFactory {

    public static SellerDao createSellerDao(){
        return new SellerDaoJDBC(DB.getConnection());
    }

    public static DepartmentDao createDepartmentDao(){
        return new DepartmentDaoJDBC(DB.getConnection());
    }
}
