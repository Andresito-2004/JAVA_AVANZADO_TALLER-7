package model.repository;

import model.beans.Category;
import model.beans.User;

import java.sql.SQLException;

public class TestCategoryRepositoryImpl {
        public static void main(String[] args) throws SQLException {
            Repository<Category> category =  new CategoryRepositoryImpl();
            System.out.println("=========== SaveObj insert ============");//Insert
            Category categoryInsert = new Category();
            categoryInsert.setCategory_name("Supercargador");
            category.saveObj(categoryInsert);

        }
    }

