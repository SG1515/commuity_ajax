package com.ll.exam.article.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDto {

    private long id;

    private String title;

    private String body;
}
//롬복을 사용하여서
//생성자 Setter Getter ToString 어노테이션으로 하면 자동으로 생성해준다.
