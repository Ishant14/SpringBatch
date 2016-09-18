package com.writer;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.builder.StudentDto;
import com.entity.Student;



public class CustomItemWriter {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public JdbcBatchItemWriter<com.builder.StudentDto> writer(DataSource dataSource) {
        
		JdbcBatchItemWriter<StudentDto> writer = new JdbcBatchItemWriter<StudentDto>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<StudentDto>());
      //  writer.setSql("INSERT INTO people (first_name,last_name) VALUES (:firstName,:lastName)");
        writer.setSql("INSERT INTO student (P_Id,LastName,FirstName,Address,City,phone,Marks) VALUES"
        		+ "(:Id,:lastName,:firstName,:Address,:City,:phone,:Marks)");
        writer.setDataSource(dataSource);
        
			
		StudentDto studentDto = new com.builder.StudentDto();
		Student student = new Student();
		student.setAddress(studentDto.getAddress());
		student.setP_Id(studentDto.getId());
		student.setCity(studentDto.getCity());
		student.setFirstName(studentDto.getFirstName());
		student.setLastName(studentDto.getLastName());
		student.setPhone(studentDto.getPhone());
		student.setMarks(studentDto.getMarks());
		System.out.println("Marks ishant : "+studentDto.getMarks());
		sessionFactory.getCurrentSession().save(student);
		
		return writer;
    }

}
