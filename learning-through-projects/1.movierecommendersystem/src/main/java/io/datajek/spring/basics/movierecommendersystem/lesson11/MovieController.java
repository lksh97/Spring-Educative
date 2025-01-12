/*
 * MovieController class - ye hamara web controller hai
 * (This is our web controller)
 * 
 * Is class ke through hum web requests ko handle karenge
 * (We'll handle web requests through this class)
 */
package io.datajek.spring.basics.movierecommendersystem.lesson11;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller  // @Controller annotation batata hai ki ye class web requests handle karegi
public class MovieController {

    @Autowired
    private RecommenderImplementation recommender;  // Movie recommender ko inject kiya

    /*
     * Root URL ("/") ke liye mapping
     * Jab koi website pe aayega, tab ye method call hoga
     */
    @GetMapping("/")
    public String home(Model model) {
        // Default movie ke liye recommendations get karo
        String[] recommendations = recommender.recommendMovies("Finding Nemo");
        
        // Model mein recommendations add karo (template mein use karne ke liye)
        model.addAttribute("recommendations", recommendations);
        
        // templates/home.html template ko render karo

        // Isse humne template ko render kiya
        // Spring automatically templates/home.html ko dekhega aur uske andar recommendations
        // variable mein humne jo array add kiya use show karega
        return "home";
    }

    /*
     * /recommend URL ke liye mapping
     * Jab koi specific movie ke liye recommendations mangega, tab ye method call hoga
     */
    @GetMapping("/recommend")
    /*
     * /recommend URL ke liye mapping
     * Jab koi specific movie ke liye recommendations mangega, tab ye method call hoga
     * 
     * @param movie - User ki selected movie, agar kuch nahi aaya then "Finding Nemo" default hoga
     * 
     * @return - recommendations ki list ke saath ek web page (HTML) return karega
     */
    public String recommend(
        @RequestParam(name = "movie", required = false, defaultValue = "Finding Nemo")
        /* 
         * RequestParam annotation se humne ye bataya hai ki "movie" naam ki ek variable
         * input mein mangni hai, agar kuch nahi aaya then "Finding Nemo" default hoga
         * 
         * Example: /recommend?movie=The+Lion+King url mein movie variable mein "The Lion King" value aayega
         * 
         * required = false se humne bataya hai ki agar kuch nahi aaya then error nahi aayega
         * aur defaultValue = "Finding Nemo" se humne default value set kiya hai
         * 
         * Model mein data add karne se humne ye bataya hai ki views mein is data ko use kar sakte hain
         * (views mein humne movie aur recommendations ki list ko show karne ke liye use kiya hai)
         * 
         * Iss call ko Browser kar rha hai (User ki request par)
         */
                            /* User ki selected movie, agar kuch nahi aaya then "Finding Nemo" default hoga */
                            String movie, 
                          Model model) {
        // User ki selected movie ke liye recommendations get karo
        String[] recommendations = recommender.recommendMovies(movie);
        
        // Model mein data add karo
        model.addAttribute("movie", movie);
        model.addAttribute("recommendations", recommendations);
        
        // templates/recommendations.html template ko render karo
        return "recommendations";
    }
}
