/**
 * @author zhangwei
 * @date 2020/11/1 18:27
 **/
public class LazySimpleSingletonTest
{

	public static void main(String[] args)
	{

		Thread thread1 = new Thread(new ExectorThread());

		Thread thread2 = new Thread(new ExectorThread());

		thread1.start();

		thread2.start();

		System.out.println("end");
	}
}
