import com.bazaarvoice.jolt.Chainr;
import com.bazaarvoice.jolt.JsonUtils;

public class Converter {

    private static final Chainr STATE = Chainr.fromSpec(JsonUtils.classpathToList("/jolt/state.json"));
    private static final Chainr STATE_WITH_DEFAULT = Chainr.fromSpec(JsonUtils.classpathToList("/jolt/state-with-default.json"));
    private static final Chainr LOCATION = Chainr.fromSpec(JsonUtils.classpathToList("/jolt/location.json"));
    private static final Chainr LOOKUP = Chainr.fromSpec(JsonUtils.classpathToList("/jolt/lookup.json"));

    public static Object convertState(String json){
        return convert(STATE, json);
    }

    public static Object convertStateWithDefault(String json){
        return convert(STATE_WITH_DEFAULT, json);
    }

    public static Object convertLocation(String json){
        return convert(LOCATION, json);
    }

    public static Object convertLookup(String json){
        return convert(LOOKUP, json);
    }

    private static Object convert(Chainr jsonTransformation, String json) {
        final Object object = JsonUtils.jsonToObject(json);
        return jsonTransformation.transform(object);
    }
}
