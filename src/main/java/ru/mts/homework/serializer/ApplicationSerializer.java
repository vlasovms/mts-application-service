package ru.mts.homework.serializer;

import camundajar.impl.scala.App;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serializer;
import ru.mts.homework.entity.Application;

import java.util.Map;

public class ApplicationSerializer implements Serializer<Application> {
    @Override
    public byte[] serialize(String arg0, Application application) {
        byte[] retVal = null;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        try {
            retVal = objectMapper.writeValueAsString(application).getBytes();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retVal;
    }

}
