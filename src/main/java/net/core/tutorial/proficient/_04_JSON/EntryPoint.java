package net.core.tutorial.proficient._04_JSON;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * JSON.
 *
 * JavaScript Object Notation - описание объектов JavaScript.
 *
 */

public class EntryPoint {

    public static void main(String[] args) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

        Model1 model1 = new Model1();
        model1.setNumber(101);
        model1.setFloatNumber(10.123);
        model1.setFlag(true);
        model1.setMessage("Some message");

        String  resultJson1 = objectMapper.writeValueAsString(model1);
        System.out.println(resultJson1);

        System.out.println("--------------------");

        Model2 model2 = new Model2();
        model2.setArray(new int[]{1,2,3,4,5,6,7,8,9});

        String resultJson2 = objectMapper.writeValueAsString(model2);
        System.out.println(resultJson2);

        System.out.println("--------------------");

        Model3 model3 = new Model3();
        model3.setModel1(model1);
        model3.setModel2(model2);

        String resultJson3 = objectMapper.writeValueAsString(model3);
        System.out.println(resultJson3);

        System.out.println("--------------------");

        Model3 model3out = objectMapper.readValue(resultJson3, Model3.class);
        System.out.println(model3out);
    }
}
