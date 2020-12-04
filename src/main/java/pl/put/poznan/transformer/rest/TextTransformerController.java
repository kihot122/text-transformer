package pl.put.poznan.transformer.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.logic.TextTransformer;

import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/")
public class TextTransformerController {

    private static final Logger logger = LoggerFactory.getLogger(TextTransformerController.class);

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public String get(@RequestParam(value="text", defaultValue="test") String text,
                      @RequestParam(value="transforms", defaultValue="upper,escape") String[] transforms) {

        // log the parameters
        logger.debug(text);
        logger.debug(Arrays.toString(transforms));

        List<String> params = Arrays.asList(transforms);

        TextTransformer transformer = new TextTransformer(transforms);
        if(params.contains("capitalize"))
            text = transformer.Capitalize(text);

        if(params.contains("upper"))
            text = transformer.Upper(text);

        if(params.contains("lower"))
            text = transformer.Lower(text);

        if(params.contains("reverse"))
            text = transformer.Reverse(text);

        if(params.contains("remove_dup"))
            text = transformer.remove_dup(text);

        return text;
    }
}


