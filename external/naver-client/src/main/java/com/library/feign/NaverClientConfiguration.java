package com.library.feign;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import feign.RequestInterceptor;

public class NaverClientConfiguration {
	@Bean
	public RequestInterceptor requestInterceptor(
		@Value("${external.naver.headers.client-id}") String clientId,
		@Value("${external.naver.headers.client-secret}") String clientSecret
	) {
		System.out.println("clientId = " + clientId);
		System.out.println("clientSecret = " + clientSecret);
		return requestTemplate -> requestTemplate.header("X-Naver-Client-Id", clientId)
			.header("X-Naver-Client-Secret", clientSecret);
	}
}
