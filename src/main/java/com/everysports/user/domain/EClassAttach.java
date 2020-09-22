package com.everysports.user.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@EqualsAndHashCode
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "class_Uuid")
@Table(name = "eClassAttach")
public class EClassAttach {

    @Id
    @Column(name = "class_Uuid")
    private String classUuid;

    @Column(name="uploadPath")
    private String uploadPath;

    @Column(name="fileName")
    private String fileName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="class_ID")
    private EClass eClass;

}
