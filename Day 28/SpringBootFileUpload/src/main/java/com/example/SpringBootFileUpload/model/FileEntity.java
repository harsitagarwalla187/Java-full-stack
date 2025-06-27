package com.example.SpringBootFileUpload.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "files")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileName;
    private String filePath;
    private String uploadTime;
}
