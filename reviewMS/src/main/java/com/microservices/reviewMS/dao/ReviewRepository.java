package com.microservices.reviewMS.dao;


import com.microservices.reviewMS.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>
{
    List<Review> findByCompanyId(Long companyID);
}
