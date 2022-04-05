package ke.springboot.resources;

import ke.springboot.models.CatalogueItem;
import ke.springboot.models.Movie;
import ke.springboot.models.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/catalogue")
public class MovieCatalogueResource {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{userId}")
    public List<CatalogueItem> getCatalogue(@PathVariable("userId") String userId){
        
        //get all rated movie IDs
        List<Rating> ratings = Arrays.asList(
                new Rating( "1234",  4),
                new Rating( "5678",  5)
        );

        return ratings.stream().map(rating -> {
           Movie movie = restTemplate.getForObject("http://localhost:8082/movies/" + rating.getMovieId(), Movie.class);
           return new CatalogueItem(movie.getName(), "Description", rating.getRating());
        }).collect(Collectors.toList());

        //for each movie ID, call movie info service and get details

        //put them all together

    }

}
