package me.harshu;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import java.util.HashMap;
import java.util.Map;

/**
 * Authorization = Harshana Jayaweera
 */
public class App {
    public static void main(String[] args) {

        StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder();
        Map<String, String> databaseConfiguration = new HashMap<String, String>();
        databaseConfiguration.put(Environment.URL, ("jdbc:mysql://localhost:3306/hibernate_database?createDatabaseIfNotExists=true"));
        databaseConfiguration.put(Environment.USER, ("root"));
        databaseConfiguration.put(Environment.PASS, (""));
        databaseConfiguration.put(Environment.DRIVER, ("com.mysql.cj.jdbc.Driver"));
        databaseConfiguration.put(Environment.DIALECT, ("org.hibernate.dialect.MySQL56Dialect"));
        standardServiceRegistryBuilder.applySettings(databaseConfiguration);
        StandardServiceRegistry standardServiceRegistry = standardServiceRegistryBuilder.build();

        MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
        Metadata metadata = metadataSources.getMetadataBuilder().build();

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
    }
}
