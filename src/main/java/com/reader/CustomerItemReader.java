package com.reader;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.core.io.ClassPathResource;

import com.builder.StudentDto;


public class CustomerItemReader {
	
	public FlatFileItemReader<StudentDto> reader() {
        FlatFileItemReader<StudentDto> reader = new FlatFileItemReader<StudentDto>();
        reader.setResource(new ClassPathResource("Student_data.csv"));
        reader.setLinesToSkip(1);
        LineMapper<StudentDto> studentLineMapper = createStudentLineMapper();
        reader.setLineMapper(studentLineMapper);
        return reader;
    }

	private LineMapper<StudentDto> createStudentLineMapper() {

		DefaultLineMapper<StudentDto> studentLineMapper = new DefaultLineMapper<>();
		LineTokenizer studentLineTokenizer = createStudentLineTokenizer();
		studentLineMapper.setLineTokenizer(studentLineTokenizer);
		FieldSetMapper<StudentDto> studentFieldMapper = createStudentInformationMapper();
		studentLineMapper.setFieldSetMapper(studentFieldMapper);
		return studentLineMapper; 
	}

	private FieldSetMapper<StudentDto> createStudentInformationMapper() {
		BeanWrapperFieldSetMapper<StudentDto> studentInformation = new BeanWrapperFieldSetMapper<>();
		studentInformation.setTargetType(StudentDto.class);
		return studentInformation;
	}

	private LineTokenizer createStudentLineTokenizer() {
		DelimitedLineTokenizer studentLineTokenizer = new DelimitedLineTokenizer();
		studentLineTokenizer.setDelimiter(",");
		studentLineTokenizer.setNames(new String[]{"Id","firstName","lastName","Address","City","phone",
				"Marks"});
		return studentLineTokenizer;
	}

}
