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
            text = transformer.capitalize(text);

        if(params.contains("upper"))
            text = transformer.upper(text);

        if(params.contains("lower"))
            text = transformer.lower(text);

        if(params.contains("reverse"))
            text = transformer.reverse(text);

        if(params.contains("remove_dup"))
            text = transformer.remove_dup(text);

        if(params.contains("expand"))
            text = transformer.expandAbbreviation(text);

        if(params.contains("shrink"))
            text = transformer.shrinkToAbbreviation(text);

        if(params.contains("read_int"))
            text = transformer.readInt(text);

        return text;
    }
}


