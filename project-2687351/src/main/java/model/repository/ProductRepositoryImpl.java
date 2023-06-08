package model.repository;
import model.beans.Product;
import util.ConnectionPool;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements Repository<Product> {
    private String sql = null;


    @Override
    public List<Product> listAllObj() throws SQLException {
        sql="SELECT p.Product_id, p.Product_name, p.Product_value, p.FK_category_id FROM products p;";
        List<Product> products =new ArrayList<>();
        try(Connection conn= ConnectionPool.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            while (rs.next()){
                Product u= createObj(rs);
                products.add(u);
            }
        }
        return products;
    }

    @Override
    public Product byIdObj(Integer id) throws SQLException {
        sql = "SELECT p.Product_id, p.Product_name, p.Product_value, p.FK_category_id FROM products p where p.Product_id = ?;";
        Product products = null;
        try (Connection conn= ConnectionPool.getConnection();
             PreparedStatement ps= conn.prepareStatement(sql)){
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()){
                if (rs.next()){
                    products= createObj(rs);
                }
            }
        }
        return products;
    }

    @Override
    public Integer saveObj(Product product) throws SQLException {
        int rowsAffected = 0;
        if (Product.getProduct_id() != null && Product.getProduct_id() > 0) {
            sql = "UPDATE products set Product_name = ? , Product_value= ?, FK_category_id=? where Product_id = ?;";
        }
        else {
            sql = "INSERT INTO products (Product_name,Product_value,FK_category_id) VALUES (upper(?),?,?);";
        }
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, product.getProduct_name());
            ps.setInt(2, product.getProduct_value());
            ps.setInt(3, product.getFk_category_id());
            if (product.getProduct_id() != null && product.getProduct_id() > 0) {
                ps.setInt(5, product.getProduct_id());
            }
            rowsAffected = ps.executeUpdate();
        }
        return rowsAffected;
    }
    @Override
    public void deleteObj(Integer id) throws SQLException {
        sql= "delete from products where Product_id= ?";
        try(Connection conn = ConnectionPool.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,id);
            ps.executeUpdate();
        }
    }

    @Override
    public Product createObj(ResultSet rs) throws SQLException {
        Product products = new Product();
        products.setProduct_id(rs.getInt("Product_id"));
        products.setProduct_name(rs.getString("Product_name"));
        products.setProduct_value(rs.getInt("Product_value"));
        products.setFk_category_id(rs.getInt("FK_category_id"));
        return products;
    }
}
