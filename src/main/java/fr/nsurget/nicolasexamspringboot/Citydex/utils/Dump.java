package fr.nsurget.nicolasexamspringboot.Citydex.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.UtilityClass;

import java.util.Optional;

@UtilityClass
public class Dump {

    public static void dump(Object object){
        System.out.println("Debug > Dump =)");
        Object jsonObject = object;
        ObjectMapper objectMapper = new ObjectMapper();
        if (object instanceof Optional<?> && ((Optional<?>) object).isPresent()){
            jsonObject = ((Optional<?>) object).get();
        }
        try {
            System.out.println(objectMapper.writerWithDefaultPrettyPrinter()
                    .writeValueAsString(jsonObject));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}