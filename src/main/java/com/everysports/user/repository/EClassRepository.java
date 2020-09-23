package com.everysports.user.repository;

import com.everysports.user.domain.ClassList;
import com.everysports.user.domain.EClass;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EClassRepository extends JpaRepository<EClass, Long>, CustomEClassRepository{

}
