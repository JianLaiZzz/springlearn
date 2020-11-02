import com.example.zhw.springsource.springdesign.singleton.lazy.LazySimpleSingleton;

/**
 * @author zhangwei
 * @date 2020/11/1 18:25
 **/
public class ExectorThread implements Runnable
{
	@Override
	public void run()
	{

		LazySimpleSingleton lazySimpleSingleton = LazySimpleSingleton.getLazySimpleSingleton();

		System.out.println(Thread.currentThread().getName() + ":" + lazySimpleSingleton);
	}
}
