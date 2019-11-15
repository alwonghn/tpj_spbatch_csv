package com.demo.batch;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.demo.entity.User;
import com.demo.repository.UserRepository;

@Component
public class Writer  implements ItemWriter<User>{

	@Autowired
	private UserRepository repo;
	
	@Override
	@Transactional
	public void write(List<? extends User> users) throws Exception{
		repo.saveAll(users);
	}
	
}

/*
#BatchConfiguration.java

    @Bean
    public JdbcBatchItemWriter<User> writer(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<User>()
            .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
            .sql("insert into USER (FIRST_NAME, LAST_NAME) values (:firstName, :lastName)")
            .dataSource(dataSource)
            .build();
    }
 */





