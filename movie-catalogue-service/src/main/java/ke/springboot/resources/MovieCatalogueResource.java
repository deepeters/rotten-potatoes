package ke.springboot.resources;

import ke.springboot.models.CatalogueItem;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;


@RestController
@RequestMapping("/catalogue")
public class MovieCatalogueResource {

    @RequestMapping("/{userId}")
    public List<CatalogueItem> getCatalogue(@PathVariable("userId") String userId){

        return Collections.singletonList(
                new CatalogueItem("Lord of the Rings", "A bunch of people taking a ring to a volcano", 5)
        );

    }

}
