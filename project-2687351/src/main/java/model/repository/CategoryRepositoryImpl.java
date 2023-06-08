package model.repository;

import model.beans.Category;
import model.beans.Product;
import util.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepositoryImpl implements Repository<Category> {
    private static String sql = null;
    @Override
    public List<Category> listAllObj() throws SQLException {
        sql="SELECT c.category_name FROM category c;";
        List<Category> categories =new ArrayList<>();
        try(Connection conn= ConnectionPool.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            while (rs.next()){
                Category c= createObj(rs);
                categories.add(c);
            }
        }
        return categories;
    }

    @Override
    public Category byIdObj(Integer id) throws SQLException {
        sql = "SELECT category_name FROM category  where category_id= ?;";
        Category category = null;
        try (Connection conn= ConnectionPool.getConnection();
             PreparedStatement ps= conn.prepareStatement(sql)){
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()){
                if (rs.next()){
                    category= createObj(rs);
                }
            }
        }
        return category;
    }

    @Override
    public Integer saveObj(Category category) throws SQLException {
        int rowsAffected = 0;
        if (category.getCategory_id() != null && category.getCategory_id() > 0) {
            sql = "UPDATE category set category_name = ?  where category_id = ?";
        } else {
            sql = "INSERT INTO category (category_name) VALUES (upper(?));";
        }
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, category.getCategory_name());
            if (category.getCategory_id() != null && category.getCategory_id() > 0) {
                ps.setInt(5, category.getCategory_id());
            }
            rowsAffected = ps.executeUpdate();
        }
        return rowsAffected;
    }

    @Override
    public void deleteObj(Integer id) throws SQLException {
        sql= "delete from category where category_id= ?";
        try(Connection conn = ConnectionPool.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,id);
            ps.executeUpdate();
        }
    }

    @Override
    public Category createObj(ResultSet rs) throws SQLException {
        Category category = new Category();
        category.setCategory_name(rs.getString("category_name"));

        return category;
    }
}
