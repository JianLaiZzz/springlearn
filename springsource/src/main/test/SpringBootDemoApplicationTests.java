import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.example.zhw.springsource.bean.Dog;
import com.example.zhw.springsource.factory.FactoryBeanTest;

/**
 * @author zhangwei1
 * @date 2020/7/3 14:35
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { FactoryBeanTest.class })
@WebAppConfiguration
public class SpringBootDemoApplicationTests
{

	@Autowired
	private ApplicationContext applicationContext;

	@Test
	public void tesst()
	{
		FactoryBeanTest bean1 = applicationContext.getBean(FactoryBeanTest.class);
		try
		{
			Dog object = bean1.getObject();
			System.out.println(object == object);
			System.out.println(object);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test
	public void tesst1()
	{
		FactoryBeanTest bean1 = (FactoryBeanTest) applicationContext.getBean("factoryBeanTest");
		try
		{
			Dog object = bean1.getObject();
			System.out.println(object == object);
			System.out.println(object);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}