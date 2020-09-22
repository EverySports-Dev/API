package com.everysports.user.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.List;

public interface ClassList {

     String getClassName();

     ETeacher getETeacher();

     Integer getClassPrice();

     List<EClassAttach> getEClassAttachList();

     //String getFileName();

     Integer getClassNum();

}
