package transform;

import com.bazaarvoice.jolt.SpecDriven;
import com.bazaarvoice.jolt.Transform;

import javax.inject.Inject;
import java.util.Map;

public class LookupTransform implements SpecDriven, Transform {

    private final Object spec;


    @Inject
    public LookupTransform(Object spec) {
        this.spec = spec;
    }

    @Override
    public Object transform(Object input) {
        Map inputMap = (Map) input;
        Map specMap = (Map) spec;

        for (Object key : specMap.keySet()) {
            if (inputMap.containsKey(key)) {
                Map lookupDef = (Map) specMap.get(key);
                String lookupDefUrl = (String) lookupDef.get("url");
                String lookupDefKey = (String) lookupDef.get("key");

                String inputValue = (String) inputMap.get(key);

                Object lookedUpValue = lookup(lookupDefUrl, inputValue);
                inputMap.put(lookupDefKey, lookedUpValue);

            }
        }

        return input;
    }

    public Object lookup(String url, String value) {
        //Just return a map here, but in a real example make a http call to the url to get the object
        return Map.of(
                "id", "12345",
                "firstName", "John",
                "lastName", "Doe",
                "age", "32"
        );
    }
}
