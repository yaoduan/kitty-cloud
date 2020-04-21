package com.cxytiandi.kittycloud.aggregation.invoker;

import com.alibaba.fastjson.JSONObject;
import com.cxytiandi.kittycloud.aggregation.request.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-04-14 23:06
 */
@Component
public class HttpApiInvokerImpl implements HttpApiInvoker {

    @Autowired
    @Qualifier("loadBalanceRestTemplate")
    private RestTemplate loadBalanceRestTemplate;

    @Autowired
    @Qualifier("restTemplate")
    private RestTemplate restTemplate;

    @Override
    public JSONObject invoke(HttpRequest httpRequest) {
        if (httpRequest.getMethod().equals(HttpMethod.GET.name())) {
            ResponseEntity<JSONObject> responseEntity = loadBalanceRestTemplate.getForEntity(httpRequest.getUri(), JSONObject.class);
            if (responseEntity.getStatusCode() == HttpStatus.OK) {
                return responseEntity.getBody();
            }
        }
        return null;
    }
}