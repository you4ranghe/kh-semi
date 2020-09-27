package com.semi.admin.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test {

	public static void main(String[] args) {
		Date today=new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String day=format.format(today);
		System.out.println(format.format(today));
		System.out.println(day);
	}

}
