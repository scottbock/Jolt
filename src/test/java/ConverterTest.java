import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ConverterTest {

    @Test
    public void state() throws Exception {
        String input = new String(Files.readAllBytes(Paths.get("src", "test", "resources", "examples", "state.json")));

        Object output = Converter.convertState(input);

        System.out.println(output);
        assertNotNull(output);

    }

    @Test
    public void stateWithDefault() throws Exception {
        String input = new String(Files.readAllBytes(Paths.get("src", "test", "resources", "examples", "state.json")));

        Object output = Converter.convertStateWithDefault(input);

        System.out.println(output);
        assertNotNull(output);
    }

    @Test
    public void blankState() throws Exception {
        String input = new String(Files.readAllBytes(Paths.get("src", "test", "resources", "examples", "blank.json")));

        Object output = Converter.convertState(input);

        System.out.println(output);
        assertNull(output);

    }

    @Test
    public void blankStateWithDefault() throws Exception {
        String input = new String(Files.readAllBytes(Paths.get("src", "test", "resources", "examples", "blank.json")));

        Object output = Converter.convertStateWithDefault(input);

        System.out.println(output);
        assertNotNull(output);
    }

    @Test
    public void location() throws Exception {
        String input = new String(Files.readAllBytes(Paths.get("src", "test", "resources", "examples", "location.json")));

        Object output = Converter.convertLocation(input);

        System.out.println(output);
        assertNotNull(output);

    }

    @Test
    public void lat() throws Exception {
        String input = new String(Files.readAllBytes(Paths.get("src", "test", "resources", "examples", "lat.json")));

        Object output = Converter.convertLocation(input);

        System.out.println(output);
        assertNull(output);

    }

    @Test
    public void lon() throws Exception {
        String input = new String(Files.readAllBytes(Paths.get("src", "test", "resources", "examples", "lon.json")));

        Object output = Converter.convertLocation(input);

        System.out.println(output);
        assertNull(output);

    }

}