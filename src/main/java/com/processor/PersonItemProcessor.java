package com.processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.builder.StudentDto;


public class PersonItemProcessor implements ItemProcessor<StudentDto, StudentDto> {

    private static final Logger log = LoggerFactory.getLogger(PersonItemProcessor.class);

    @Override
    public StudentDto process(final StudentDto studentdto) throws Exception {
        
        return studentdto;
    }

}