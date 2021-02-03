import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Convert;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ConverterLookupTest {

    @Test
    public void lookup() throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("src", "test", "resources", "examples", "lookup.json")));

        Object output = Converter.convertLookup(input);

        System.out.println(output);

        assertNotNull(output);

        Map person = (Map) ((Map)output).get("person");
        assertEquals("12345", person.get("id"));
        assertEquals("32", person.get("age"));
        assertEquals("John", person.get("firstName"));
        assertEquals("Doe", person.get("lastName"));
    }
}
