/*
 * ContentBasedFilter class movies ko unke content ke basis par filter karti hai
 * 
 * Jaise: genre, actors, director, etc.
 * (For example: genre, actors, director, etc.)
 * 
 * Ye Filter interface ko implement karti hai aur @Component annotation se Spring container mein register hoti hai
 */
package io.datajek.spring.basics.movierecommendersystem.lesson11;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// @Component annotation batata hai Spring ko ki ise ek bean ke roop mein manage karna hai
// Bean ek special object hota hai jise Spring manage karta hai
@Component
// @Qualifier("CBF") annotation batata hai ki ye bean "CBF" naam se register hoga
// Isse hum Spring ko batate hain ki ye bean "CBF" naam se access karna hai
@Qualifier("CBF")
public class ContentBasedFilter implements Filter {

    // Logger object banaya hai taki hum runtime pe important information log kar sake
    // getClass() se current class ka naam automatically aa jata hai logs mein
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    /*
     * Constructor - jab bhi is class ka naya object banega, ye method call hoga
     */
    public ContentBasedFilter() {  
        super();
        logger.info("In ContentBasedFilter constructor method");
    }

    /*
     * @PostConstruct - ye method object banne ke turant baad call hoga
     * (This method will be called immediately after object creation)
     * 
     * Isme hum initialization ka kaam kar sakte hain
     * (We can do initialization work here)
     */
    @PostConstruct
    private void postConstruct() {
        logger.info("In ContentBasedFilter postConstruct method");
    }

    /*
     * @PreDestroy - ye method object destroy hone se pehle call hoga
     * (This method will be called just before object destruction)
     * 
     * Isme hum cleanup ka kaam kar sakte hain
     * (We can do cleanup work here)
     */
    @PreDestroy
    private void preDestroy() {
        logger.info("In ContentBasedFilter preDestroy method");
    }

    /*
     * getRecommendations method - ye actual movie recommendations return karta hai
     * (This method returns actual movie recommendations)
     * 
     * Abhi ke liye ye static movies return kar raha hai
     * (For now, it's returning static movies)
     * 
     * @param movie - input movie jiske liye recommendations chahiye
     * @return - similar movies ki array
     */
    @Override
    public String[] getRecommendations(String movie) {
        // Abhi ke liye static movies return kar rahe hain
        // (For now, returning static movies)
        return new String[] {"Finding Nemo", "Ice Age", "Toy Story"};
    }
}
