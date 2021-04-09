import com.example.zhw.SpringMytatisApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringMytatisApplication.class)
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testString() {
        String redisKey = "test:count";

        redisTemplate.opsForValue().set(redisKey, 1);

        redisTemplate.opsForValue().set("name", "zhw1");
        redisTemplate.opsForValue().set("zhw", "zhw2");

        System.out.println(redisTemplate.opsForValue().get(redisKey));//1

        System.out.println(redisTemplate.opsForValue().get("name"));
        System.out.println(redisTemplate.opsForValue().get("zhw"));
        System.out.println();
    }

    @Test
    public void testHash() {
        String redisKey = "test:user";

        redisTemplate.opsForHash().put(redisKey, "id", 1);
        redisTemplate.opsForHash().put(redisKey, "name", "sjh");

        System.out.println(redisTemplate.opsForHash().get(redisKey, "id"));// 1
        System.out.println(redisTemplate.opsForHash().get(redisKey, "name"));// sjh
    }

    @Test
    public void testList() {
        String redisKey = "test:list";

        redisTemplate.opsForList().leftPush(redisKey, "小明");
        redisTemplate.opsForList().leftPush(redisKey, "小红");
        redisTemplate.opsForList().leftPush(redisKey, "小李");

        System.out.println(redisTemplate.opsForList().size(redisKey));// 3
        System.out.println(redisTemplate.opsForList().range(redisKey, 0, 2));// [小李, 小红, 小明]

        redisTemplate.opsForList().rightPop(redisKey);
        System.out.println(redisTemplate.opsForList().range(redisKey, 0, 2));// [小李, 小红]
    }

    @Test
    public void testSet() {
        String redisKey = "test:teachers";

        redisTemplate.opsForSet().add(redisKey, "刘备", "关羽", "张飞", "赵云");

        System.out.println(redisTemplate.opsForSet().size(redisKey));// 4
        System.out.println(redisTemplate.opsForSet().pop(redisKey));// 张飞
    }

    @Test
    public void testZset() {
        String redisKey = "test:students";

        redisTemplate.opsForZSet().add(redisKey, "刘备", 10);
        redisTemplate.opsForZSet().add(redisKey, "张飞", 20);
        redisTemplate.opsForZSet().add(redisKey, "关羽", 30);

        System.out.println(redisTemplate.opsForZSet().zCard(redisKey));// 3
        System.out.println(redisTemplate.opsForZSet().score(redisKey, "刘备"));// 10.0
        System.out.println(redisTemplate.opsForZSet().range(redisKey, 0, 2));// [刘备, 张飞, 关羽]
    }

    @Test
    public void testKeys() {
        redisTemplate.delete("test:user");

        System.out.println(redisTemplate.hasKey("test:user"));// 0

        // 设置10秒后过期
        redisTemplate.expire("test:students", 10, TimeUnit.SECONDS);
    }

    // 多次访问同一个 key
    @Test
    public void testBindKey() {
        String redisKey = "test:count";
        BoundValueOperations operations = redisTemplate.boundValueOps(redisKey);
        for (int i = 0; i < 5; i++) {
            operations.increment();
        }
        System.out.println(operations.get());// 6
    }

    @Test
    public void testTransaction() {
        Object obj = redisTemplate.execute(new SessionCallback() {
            @Override
            public Object execute(RedisOperations redisOperations) throws DataAccessException {
                String redisKey = "test:tx";
                // 启用事务
                redisOperations.multi();

                redisOperations.opsForSet().add(redisKey, "a");
                redisOperations.opsForSet().add(redisKey, "b");
                redisOperations.opsForSet().add(redisKey, "c");

                System.out.println(redisOperations.opsForSet().members(redisKey));// []，提交事务前不会生效，因此结果为空。

                // 提交事务
                return redisOperations.exec();
            }
        });
        System.out.println("事务执行结果:");
        System.out.println(obj);// [1, 1, 1, [c, b, a]]，三个 1 分别代表三次执行语句的执行结果（影响的行数）
    }
}