package net.ahmed;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-data-config.xml");
        System.out.println(" Tables created successfully (if not existing).");
    }
}
