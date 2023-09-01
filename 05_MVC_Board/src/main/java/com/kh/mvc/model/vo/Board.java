package com.kh.mvc.model.vo;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Board {
		private int num;
		private int no;
		private String title;
		private String content;
		private String writer;
		private Date regdate;
		
		private MultipartFile uploadFile; //컨트롤러에서 다룰애
		private String url; //데이터베이스 때문에 추가
}

