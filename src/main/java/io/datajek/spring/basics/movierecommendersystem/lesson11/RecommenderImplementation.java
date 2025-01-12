/*
 * RecommenderImplementation class main business logic ko handle karti hai
 * (RecommenderImplementation class handles the main business logic)
 * 
 * Ye class movie recommendations ko manage karti hai aur Filter interface ka use karti hai
 * (This class manages movie recommendations and uses the Filter interface)
 * 
 * Spring ke through dependency injection ka use karke ye different filters ko use kar sakti hai
 * (Using Spring's dependency injection, it can use different filters)
 */
package io.datajek.spring.basics.movierecommendersystem.lesson11;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// @Component annotation se ye class Spring ka bean ban jata hai
// Ye main class hai jo movie recommendations provide karti hai
@Component
public class RecommenderImplementation {

    // Logger object create kiya hai debugging ke liye
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    /*
     * @Autowired aur @Qualifier ka use karke hum specify karte hain ki konsa Filter use karna hai
     * (Using @Autowired and @Qualifier we specify which Filter to use)
     * 
     * Yahan CBF matlab ContentBasedFilter use hoga
     * (Here CBF means ContentBasedFilter will be used)
     */
    @Autowired
    @Qualifier("CBF")
    private Filter filter;

    /*
     * Constructor - jab bhi is class ka naya object banega, ye method call hoga
     * (Constructor - this method will be called whenever a new object of this class is created)
     */
    public RecommenderImplementation() {
        logger.info("In RecommenderImplementation constructor method");
    }

    /*
     * Setter method - Spring ise use karke filter object ko inject karta hai
     * (Setter method - Spring uses this to inject the filter object)
     */
    @Autowired
    public void setFilter(Filter filter) {
        logger.info("In RecommenderImplementation setter method..dependency injection");
        this.filter = filter;
    }

    /*
     * @PostConstruct - ye method object banne ke turant baad call hoga
     * (This method will be called immediately after object creation)
     */
    @PostConstruct
    public void postConstruct() {
        logger.info("In RecommenderImplementation postConstruct method");
    }

    /*
     * @PreDestroy - ye method object destroy hone se pehle call hoga
     * (This method will be called just before object destruction)
     */
    @PreDestroy
    public void preDestroy() {
        logger.info("In RecommenderImplementation preDestroy method");
    }

    /*
     * Main method jo movies recommend karne ke liye use hota hai
     * (Main method used for recommending movies)
     * 
     * @param movie - wo movie jiske similar movies chahiye
     * @return - recommended movies ki array
     */
    public String[] recommendMovies(String movie) {
        // Injected filter ka use karke recommendations get karte hai
        return filter.getRecommendations(movie);
    }
}
