package com.example.GreetingCRUD;

import org.springframework.data.repository.CrudRepository;

public interface MessageTypeRepository extends CrudRepository<MessageType, Long> {
}
