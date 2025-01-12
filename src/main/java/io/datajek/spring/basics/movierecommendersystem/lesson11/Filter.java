/*
 * Ye ek interface hai jo movie recommendations ke liye filter ka blueprint define karta hai
 * (This is an interface that defines the blueprint for movie recommendation filters)
 * 
 * Interface ka use karne se hum different types ke filters easily add kar sakte hain
 * (Using interface allows us to easily add different types of filters)
 * 
 * Jaise: ContentBasedFilter, CollaborativeFilter, etc.
 * (For example: ContentBasedFilter, CollaborativeFilter, etc.)
 */

package io.datajek.spring.basics.movierecommendersystem.lesson11;

import org.springframework.stereotype.Component;

/*
 * @Component annotation Spring ko batata hai ki yeh ek bean hai
 * (This annotation tells Spring that this is a bean)
 * 
 * Spring beans are objects that are managed by the Spring container
 * (Spring beans are objects that are managed by the Spring container)
 * 
 * Jaise: ye ek component hai jo movies ki list return karega
 * (For example: this is a component that will return a list of movies)
 * 
 * @Component annotation ko use karne se hum is component ko Spring container mein register kar sakte hain
 * (By using @Component annotation, we can register this component in the Spring container)
 * 
 */
@Component
public interface Filter {
    
    /*
     * Ye method movies ki list return karega jo user ko recommend ki jayengi
     * (This method will return a list of movies that will be recommended to the user)
     * 
     * @return String[] - movies ke naam ki array
     *                  (array of movie names)
     */
    public String[] getRecommendations(String movie);
}
