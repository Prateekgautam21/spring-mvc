package com.test.hplusapp.converters;

import com.test.hplusapp.Entity.Gender;
import org.springframework.core.convert.converter.Converter;

public class StringToGenderConverter implements Converter<String, Gender> {

    @Override
    public Gender convert(String source) {
        if(source.equals("Male")){
            return Gender.MALE;
        }else if(source.equals("Female")){
            return Gender.FEMALE;
        }else{
            return Gender.OTHER;
        }
    }

}
