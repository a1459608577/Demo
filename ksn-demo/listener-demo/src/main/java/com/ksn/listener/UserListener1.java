package com.ksn.listener;

import com.ksn.entity.User;
import com.ksn.event.UserEvent;
import com.ksn.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/4/26 15:33
 */
@Component
public class UserListener1 implements ApplicationListener<UserEvent> {

    @Async
    @Override
    public void onApplicationEvent(UserEvent event) {
        UserServiceImpl source = (UserServiceImpl)event.getSource();
        System.out.println("存入数据库" + source);
        User user = event.gteUser();
        System.out.println(user);
        // 处理业务
    }
//    使用这种方法就可以不用通过实现类来实现排序和显式的继承类了
//    @Order(8)
//    @EventListener(classes = UserEvent.class)
//    public void onApplicationEvent(UserEvent event) {
//        UserServiceImpl source = (UserServiceImpl)event.getSource();
//        System.out.println("存入数据库" + source);
//        User user = event.gteUser();
//        System.out.println(user);
//        // 处理业务
//    }
}
