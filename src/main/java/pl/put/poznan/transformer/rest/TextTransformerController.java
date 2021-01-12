package pl.put.poznan.transformer.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.logic.*;

import java.util.Arrays;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/")
public class TextTransformerController {

    private static final Logger logger = LoggerFactory.getLogger(TextTransformerController.class);

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public String get(@RequestParam(value = "text", defaultValue = "test") String text,
                      @RequestParam(value = "transforms", defaultValue = "upper,escape") String[] transforms) {
        Abbriviations abbriviations = new Abbriviations();
        InputString inputString = new InputString(text);
        TextDecorator textDecorator = new TextDecorator(inputString);

        // log the parameters
        logger.info(text);
        logger.info(Arrays.toString(transforms));

        List<String> params = Arrays.asList(transforms);

        TextTransformer transformer = new TextTransformer(transforms);

        for(var transform : params) {
            if (transform.equals("capitalize"))
                textDecorator = new Capitalize(textDecorator);

            if (transform.equals("upper"))
                textDecorator = new ToCapital(textDecorator);

            if (transform.equals("lower"))
                textDecorator = new ToLower(textDecorator);

            if (transform.equals("reverse"))
                textDecorator = new Reverse(textDecorator);

            if (transform.equals("remove_dup"))
                textDecorator = new RemoveDuplicates(textDecorator);

            if (transform.equals("expand"))
                textDecorator = new ExpandAbbriviation(textDecorator, abbriviations);

            if (transform.equals("shrink"))
                textDecorator = new ShrinkAbbriviation(textDecorator, abbriviations);

            if (transform.equals("read_int"))
                textDecorator = new ReadInt(textDecorator);
        }
        inputString = new InputString(textDecorator.transform());
        return inputString.getText();
    }
}