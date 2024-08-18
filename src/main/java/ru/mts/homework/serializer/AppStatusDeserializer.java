package ru.mts.homework.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;
import ru.mts.homework.dto.ApplicationStatus;

public class AppStatusDeserializer implements Deserializer<ApplicationStatus> {
    @Override
    public ApplicationStatus deserialize(String s, byte[] bytes) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        ApplicationStatus applicationStatus = null;
        try {
            applicationStatus = mapper.readValue(bytes, ApplicationStatus.class);
        } catch (Exception e) {

            e.printStackTrace();
        }
        return applicationStatus;
    }
}
