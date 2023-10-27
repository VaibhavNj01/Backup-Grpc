//package com.ca.patient.config;
//
//import org.springframework.core.convert.converter.Converter;
//import org.springframework.data.convert.WritingConverter;
//
//import java.sql.Date;
//import java.time.LocalDate;
//
//@WritingConverter
//public class LocalDateToDateConverter implements Converter<LocalDate, Date> {
//
//	@Override
//    public Date convert(LocalDate source) {
//        return java.sql.Date.valueOf(source);
//    }
//}
