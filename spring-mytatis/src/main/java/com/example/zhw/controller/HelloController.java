package com.example.zhw.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.example.zhw.entry.User;
import com.example.zhw.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import mobileCodeWS.MobileCodeWSSoap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

/**
 * @author: zhw
 * @createDate: 2020/4/19
 */
@RestController
@Api("hello基础文档")
public class HelloController
{
	@Value("${value}")
	private String value;

	@Autowired
	private UserService userService;

	@GetMapping("/hello")
	@ApiOperation(value = "hello方法")
	public String hello() throws MalformedURLException {
		Wrapper<User> wrapper = new EntityWrapper();
		Map<String, Object> map = userService.selectMap(wrapper);
		map.forEach((k, v) ->
		{
			System.out.println(k + ":" + v);
		});

		//创建WSDL文件的URL
		URL wsdlDocumentLocation = new URL("http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx?wsdl");
		//创建服务名称
		//1.namespaceURI - 命名空间地址
		//2.localPart - 服务视图名
		QName serviceName = new QName("http://WebXml.com.cn/", "MobileCodeWS");
		Service service = Service.create(wsdlDocumentLocation, serviceName);

		//获取服务实现类
		MobileCodeWSSoap mobileCodeWSSoap = service.getPort(MobileCodeWSSoap.class);
		//调用方法
		String message = mobileCodeWSSoap.getMobileCodeInfo("18779147214", null);
		System.out.println(message);

		return value;
	}
}
