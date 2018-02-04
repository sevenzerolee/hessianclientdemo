package org.sevenzero.hessianclientdemo;

import java.net.MalformedURLException;

import com.caucho.hessian.client.HessianProxyFactory;

/**
 * Hello world!
 *
 */
public class AppWorld {

	public static void main(String[] args) {
		System.out.println("Hello World!");

		// 在服务器端的web.xml文件中配置的HessianServlet映射的访问URL地址
		String url = "http://localhost:8087/hessiandemo/world";
		HessianProxyFactory factory = new HessianProxyFactory();
		WorldSpi service = null;
		try {
			service = (WorldSpi) factory.create(WorldSpi.class, url);
		} 
		catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		// 创建IService接口的实例对象
		String world = service.call();
		// 调用Hessian服务器端的ServiceImpl类中的getUser方法来获取一个User对象
		System.out.println(world);
	}

}
