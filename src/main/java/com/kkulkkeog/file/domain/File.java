package com.kkulkkeog.file.domain;

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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqFile")
    private Long no;

    private String name;

    private long size;

    private String path;

    private boolean createdFile;
}
