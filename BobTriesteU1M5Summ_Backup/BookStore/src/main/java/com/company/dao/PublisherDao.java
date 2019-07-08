package com.company.dao;


import com.company.model.Publisher;

import java.util.List;

public interface PublisherDao {
    Publisher getPublisher(int id);

    List<Publisher> getAllPublishers();

    Publisher addPublisher(Publisher publisher);

    void updatePublisher(Publisher publisher);

    void selectPublisher(int id);

    void deletePublisher(int id);





}
