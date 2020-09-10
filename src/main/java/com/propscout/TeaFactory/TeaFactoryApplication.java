package com.propscout.TeaFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class TeaFactoryApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TeaFactoryApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Command Line Run Called");
    }
}
