package com.yueting.api.service;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.core.io.ClassPathResource;

import com.github.tomakehurst.wiremock.client.WireMock;

public class WireMockServer {

	public static void main(String[] args) throws Exception {
		WireMock.configureFor(8081);
		WireMock.removeAllMappings();
		
		mock("/user/1","mock/response/01.txt");
		mock("/user/2","mock/response/02.txt");
		
	}

	private static void mock(String url, String path) throws Exception {
		ClassPathResource resource = new ClassPathResource(path);
		String content = StringUtils.join(FileUtils.readLines(resource.getFile(), "UTF-8").toArray(),"\n");
		stubFor(get(urlPathEqualTo(url)).willReturn(aResponse().withBody(content)
				.withStatus(200)));
	}
	
}
