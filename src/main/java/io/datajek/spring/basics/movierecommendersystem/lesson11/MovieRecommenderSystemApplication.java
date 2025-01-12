// Package declaration
package io.datajek.spring.basics.movierecommendersystem.lesson11;

// Spring Boot ke liye required imports
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

// @SpringBootApplication - ye annotation 3 annotations ko combine karta hai:
// 
// 1. @Configuration: Ye annotation batata hai ki is class mein @Bean definition methods hain
//    Example: @Bean public DataSource dataSource() { ... }
// 
//    Isse Spring ko pata chalta hai ki is class mein configuration related code hai
//    aur ye Spring ko batata hai ki ye class mein defined beans ko use karo
// 
// 2. @ComponentScan: Ye annotation Spring ko batata hai ki wo other components, configurations,
//    and services ko scan karo aur unhe Spring ke container mein register karo
// 
//    Example: @ComponentScan("io.datajek.spring.basics")
// 
//    Isse Spring ko pata chalta hai ki wo specified package mein mojud classes ko scan karo
//    aur unhe Spring ke container mein register karo
// 
// 3. @EnableAutoConfiguration: Ye annotation Spring ko batata hai ki wo automatically application ko configure karo
//    based on dependencies jo project mein hai
// 
//    Example: @EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
// 
//    Isse Spring ko pata chalta hai ki wo automatically application ko configure karo
//    but specified configuration ko exclude karo
@SpringBootApplication
public class MovieRecommenderSystemApplication {

    // Main method - application ka entry point
    // Args mein command line arguments aa sakte hai
    public static void main(String[] args) {
        // SpringApplication.run() method Spring application ko start karta hai
        // Ye ApplicationContext return karta hai jo Spring ka container hai
        ApplicationContext appContext = SpringApplication.run(MovieRecommenderSystemApplication.class, args);

        // ApplicationContext se RecommenderImplementation ka bean get karte hai
        // getBean() method specified type ka Spring bean return karta hai
        RecommenderImplementation recommender = appContext.getBean(RecommenderImplementation.class);    
        
        // Bean ka toString() method call karke uski information print karte hai
        System.out.println(recommender);
    }
}
