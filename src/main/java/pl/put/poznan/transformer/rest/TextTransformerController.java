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
        if (params.contains("capitalize"))
            textDecorator = new Capitalize(textDecorator);

        if (params.contains("upper")) {
            textDecorator = new ToCapital(textDecorator);

        }
        if (params.contains("lower"))
            textDecorator = new ToLower(textDecorator);

        if (params.contains("reverse"))
            textDecorator = new Reverse(textDecorator);

        if (params.contains("remove_dup"))
            textDecorator = new RemoveDuplicates(textDecorator);

        if (params.contains("expand"))
            textDecorator = new ExpandAbbriviation(textDecorator, abbriviations);

        if (params.contains("shrink"))
            textDecorator = new ShrinkAbbriviation(textDecorator, abbriviations);

        if (params.contains("read_int"))
            textDecorator = new ReadInt(textDecorator);


        inputString = new InputString(textDecorator.transform());
        return inputString.getText();
    }
}