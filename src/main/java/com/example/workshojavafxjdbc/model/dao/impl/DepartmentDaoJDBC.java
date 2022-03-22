package com.example.workshojavafxjdbc.model.dao.impl;

import com.example.workshojavafxjdbc.db.DB;
import com.example.workshojavafxjdbc.db.DbException;
import com.example.workshojavafxjdbc.model.dao.DepartmentDao;
import com.example.workshojavafxjdbc.model.entities.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoJDBC implements DepartmentDao {

    private Connection conn;

    public DepartmentDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Department obj) {

        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "INSERT INTO department "
                            + ("( Name ) VALUES ")
                            + "( ? ) ",
                    PreparedStatement.RETURN_GENERATED_KEYS);

            st.setString(1, obj.getName());

            int rows = st.executeUpdate();

            if (rows > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    obj.setId(id);
                }
                DB.closeResultSet(rs);
            } else {
                throw new DbException("Nenhuma linha foi inserida. Algo de errado aconteceu!");
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }

    }

    @Override
    public void update(Department obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "UPDATE department "
                            + "SET name = ? "
            + "WHERE Id = ? ");

            st.setString(1, obj.getName());
            st.setInt(2,obj.getId());
            st.executeUpdate();
        }
        catch(SQLException e){
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "DELETE FROM department "
                            + "WHERE Id = ? ");
            st.setInt(1, id);
            st.executeUpdate();

        }catch(SQLException e){
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(st);
        }

    }

    @Override
    public Department findById(Integer id) {

        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                    "SELECT * FROM department"
                            + " WHERE Id = ? ");
            st.setInt(1, id);
            rs = st.executeQuery();

            while (rs.next()) {
                return instantiateDepartment(rs);
            }
            return null;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public List<Department> findAll() {

        PreparedStatement st = null;
        ResultSet rest = null;
        List<Department> list = new ArrayList<>();

        try{
            st = conn.prepareStatement("SELECT * FROM department ORDER BY Name" );
            rest = st.executeQuery();

            while(rest.next()){
                Department dp = instantiateDepartment(rest);
                list.add(dp);
            }
            return list;

        }catch (SQLException e){
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(st);
            DB.closeResultSet(rest);
        }
    }

    private Department instantiateDepartment(ResultSet rs) throws SQLException {
        Department dp = new Department();
        dp.setId(rs.getInt("Id"));
        dp.setName(rs.getString("Name"));
        return dp;
    }
}
