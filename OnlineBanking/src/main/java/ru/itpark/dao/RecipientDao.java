package ru.itpark.dao;

import org.springframework.data.repository.CrudRepository;
import ru.itpark.models.Recipient;

import java.util.List;

public interface RecipientDao extends CrudRepository<Recipient, Long> {

    List<Recipient> findAll();

    Recipient findByName(String recipientName);

    void deleteByName(String recipientName);

}
