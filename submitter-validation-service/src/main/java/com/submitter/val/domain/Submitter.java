package com.submitter.val.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Submitter {

	private String submitterID;
	private String correlationID;
	private List<String> errorCode = new ArrayList<String>();

}
