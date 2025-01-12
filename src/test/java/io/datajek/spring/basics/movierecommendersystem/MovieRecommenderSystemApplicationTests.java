package io.datajek.spring.basics.movierecommendersystem;

import io.datajek.spring.basics.movierecommendersystem.lesson11.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

// @SpringBootTest annotation ke sath main class specify karte hai
@SpringBootTest(classes = MovieRecommenderSystemApplication.class)
class MovieRecommenderSystemApplicationTests {

    // RecommenderImplementation ko inject karte hai
    @Autowired
    private RecommenderImplementation recommender;

    // Context loading test - checks if Spring context loads successfully
    @Test
    void contextLoads() {
        assertNotNull(recommender);
    }

    // Movie recommendations test
    @Test
    void testMovieRecommendations() {
        // Get recommendations for "Finding Nemo"
        String[] recommendations = recommender.recommendMovies("Finding Nemo");
        
        // Check if we get recommendations
        assertNotNull(recommendations);
        assertTrue(recommendations.length > 0);
        
        // Check if recommendations contain expected movies
        boolean containsExpectedMovie = false;
        for (String movie : recommendations) {
            if (movie.equals("Happy Feet") || movie.equals("Ice Age") || movie.equals("Shark Tale")) {
                containsExpectedMovie = true;
                break;
            }
        }
        assertTrue(containsExpectedMovie, "Recommendations should contain at least one expected movie");
    }
}
