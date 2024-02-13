package generictype_to_argument;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.micronaut.core.reflect.GenericTypeUtils;
import io.micronaut.core.type.Argument;
import io.micronaut.jackson.JacksonConfiguration;
import jakarta.ws.rs.core.GenericType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.UUID;

public class ConversionTests
{
    static ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testMapStringString() {
        var generic = new GenericType<Map<String,String>>() {};
        var derived = Argument.of(generic.getType());
        var jacksonType = JacksonConfiguration.constructType(derived, objectMapper.getTypeFactory());
        Assertions.assertTrue(jacksonType.isMapLikeType());
    }

    @Test
    public void testMapStringStringWithUtils() {
        var generic = new GenericType<Map<String,String>>() {};
        var derived = Argument.of(generic.getRawType(), GenericTypeUtils.resolveTypeArguments(generic.getType()));
        var jacksonType = JacksonConfiguration.constructType(derived, objectMapper.getTypeFactory());
        Assertions.assertTrue(jacksonType.isMapLikeType());
    }

    @Test
    public void testMapUUIDString() {
        var generic = new GenericType<Map<UUID,String>>() {};
        var derived = Argument.of(generic.getType());
        var jacksonType = JacksonConfiguration.constructType(derived, objectMapper.getTypeFactory());
        Assertions.assertTrue(jacksonType.isMapLikeType());
    }
}
