package com.everysports.user.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@EqualsAndHashCode
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
