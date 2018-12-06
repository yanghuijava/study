package com.yanghui.study.ribbon;

import com.netflix.ribbon.ClientOptions;
import com.netflix.ribbon.Ribbon;
import com.netflix.ribbon.http.HttpRequestTemplate;
import com.netflix.ribbon.http.HttpResourceGroup;

import io.netty.buffer.ByteBuf;
import rx.Observable;

public class RibbonTest {
	
	public static void main(String[] args) {
		HttpResourceGroup httpResourceGroup = Ribbon.createHttpResourceGroup("movieServiceClient",
	            ClientOptions.create()
	                    .withMaxAutoRetriesNextServer(3)
	                    .withConfigurationBasedServerList("localhost:2001,localhost:2002"));
	HttpRequestTemplate<ByteBuf> recommendationsByUserIdTemplate = httpResourceGroup.newTemplateBuilder("recommendationsByUserId", ByteBuf.class)
	            .withMethod("GET")
	            .withUriTemplate("/users/{userId}/recommendations")
//	            .withFallbackProvider(new RecommendationServiceFallbackHandler())
//	            .withResponseValidator(new RecommendationServiceResponseValidator())
	            .build();
	Observable<ByteBuf> result = recommendationsByUserIdTemplate.requestBuilder()
	                        .withRequestProperty("userId", "user1")
	                        .build()
	                        .observe();
	}

}
