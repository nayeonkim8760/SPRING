package com.example.ny.domain;

import io.swagger.annotations.ApiParam;
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

	@ApiParam(value = "게시글 번호", required = true, example = "1")
	private long no;

	@ApiParam(value = "제목", required = true, example = "문의합니다.")
	private String title;

	@ApiParam(value = "내용", required = false, example = "내용입니다.")
	private String content;

	@ApiParam(value = "작성자", required = true, example = "홍길동")
	private String writer;

	@ApiParam(value = "작성일자", required = false, example = "2022-01-01")
	private String created;

	@ApiParam(value = "수정일자", required = false, example = "2022-01-01")
	private String lastModified;

}