package com.goodee.practice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BoardDTO {

	private long no;
	private String writer;
	private String title;
	private String content;
	private String ip;
	private long hit;
	private String created;
	private String lastmodified;

}