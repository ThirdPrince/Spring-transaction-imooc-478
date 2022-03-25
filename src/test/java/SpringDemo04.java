
import cn.muke.spring.demo4.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * 转账案例的测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext04.xml")
public class SpringDemo04 {


    /**
     * 注入代理类
     */
    //@Resource(name = "accountService")
    @Resource(name = "accountService")
    private AccountService accountService;

    @Test
    public void demo01(){
       accountService.transfer("aaa","bbb",200d);
    }
}
