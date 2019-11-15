package com.demo.batch;

import java.util.Optional;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.demo.entity.User;
import com.demo.repository.UserRepository;

@Component
public class Processor implements ItemProcessor<User,User> {

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public User process(User user) throws Exception{
		Optional<User> userFromDb = userRepo.findById(user.getId());
		if(userFromDb.isPresent()) {
			user.setUserId(userFromDb.get().getUserId());
			//user.setAccount(user.getAccount().add(userFromDb.get().getAccount()));
		}
		return user;
	}
	
	
}



/*
#BatchConfiguration.java

    @Bean
    public UserItemProcessor processor() {
        return new UserItemProcessor();
    }


#UserItemProcessor.java

package com.demo.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.demo.entity.*;

public class UserItemProcessor implements ItemProcessor<User, User> {
	
    private static final Logger log = LoggerFactory.getLogger(UserItemProcessor.class);

    @Override
    public User process(final User person) throws Exception {
    	log.info("INTO PIP PROCESS");
    	final String firstName = person.getFirstName().toUpperCase();
    	final String lastName = person.getLastName().toUpperCase();
    	
    	final User transformedPerson = new User(firstName, lastName);
    	
    	log.info("Converting (" + person + ") into (" + transformedPerson + ")");

    	return transformedPerson;
    }

}
 */