package com.everysports.user.repository;

import com.everysports.user.domain.EClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EClassRepository extends JpaRepository<EClass, Long> {

    @Query("select class_Name,teacher_Name, class_Price, uploadPath, fileName, class_Num " +
            "from eClass inner join eTeacher on eClass.teacher_ID = eTeacher.teacher_ID inner" +
            " join eClassAttach on ")

}
