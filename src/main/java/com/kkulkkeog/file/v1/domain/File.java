package com.kkulkkeog.file.v1.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "TB_FILE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    private String name;

    private Long size;

    private String path;

    private Boolean createdFile;
}
