package model.repository;

import model.beans.User;
import java.sql.SQLException;

public class TestUserRepositoryImpl {
    public static void main(String[] args) throws SQLException {
        Repository<User> repository =  new UseRepositoryImpl();
        System.out.println("=========== SaveObj insert ============");//Insert
        User userInsert = new User();
        userInsert.setUser_firstname("Carlos");
        userInsert.setUser_lastname("Sarmiento");
        userInsert.setUser_email("Carasarmiento11111@gmail.com");
        userInsert.setUser_password("45iahsu45");

        repository.saveObj(userInsert);
        userInsert.setUser_firstname("Andres");
        userInsert.setUser_lastname("Sarmiento");
        userInsert.setUser_email("Sarmientokrlos@gmail.com");
        userInsert.setUser_password("45iahsu405");
        repository.saveObj(userInsert);

        System.out.println("=========== listAllObj ============");//Insert
        repository.listAllObj().forEach(System.out::println);
        System.out.println();

        System.out.println("======= byIdObj =======");
        System.out.println(repository.byIdObj(1));
        System.out.println();


        System.out.println("=========== saveObj ============");//Update
        User userUpdate = new User();
        userUpdate.setUser_id(2);
        userUpdate.setUser_firstname("Carlosan");
        userUpdate.setUser_lastname("Sarmientos");
        userUpdate.setUser_email("Carasarmiento11111@soy.sena.com");
        userUpdate.setUser_password("45iahsu85045");
        repository.saveObj(userInsert);
        repository.listAllObj().forEach(System.out::println);
        System.out.println();

        System.out.println("============= deleteObj ==============");
        repository.deleteObj(2);
        repository.listAllObj().forEach(System.out::println);

    }
}
