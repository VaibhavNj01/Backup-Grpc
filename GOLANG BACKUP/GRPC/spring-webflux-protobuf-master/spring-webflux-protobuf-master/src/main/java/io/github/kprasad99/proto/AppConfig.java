package io.github.kprasad99.proto;

import java.io.IOException;

import io.github.kprasad99.proto.orm.dao.PersonDao;
import io.github.kprasad99.proto.orm.dao.PersonDaoI;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.google.protobuf.Message;
import com.google.protobuf.util.JsonFormat;

@Configuration
@EnableWebFlux
public class AppConfig implements WebFluxConfigurer {

	@Override
	public void configureHttpMessageCodecs(ServerCodecConfigurer configurer) {
		configurer.defaultCodecs().jackson2JsonEncoder(new Jackson2JsonEncoder(
				Jackson2ObjectMapperBuilder.json().serializerByType(Message.class, new JsonSerializer<Message>() {
					@Override
					public void serialize(Message value, JsonGenerator gen, SerializerProvider serializers)
							throws IOException {
						String str = JsonFormat.printer().omittingInsignificantWhitespace().print(value);
						gen.writeRawValue(str);
					}
				}).build()));
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	public PersonDaoI personDao() {
		return new PersonDaoI(); // You may need to configure the bean based on your application requirements.
	}

}
