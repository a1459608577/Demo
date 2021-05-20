package com.ksn.service.impl;

import com.ksn.entity.User;
import com.ksn.event.UserEvent;
import com.ksn.service.UserService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/4/26 15:36
 */
@Service
public class UserServiceImpl implements UserService{ //方法1, ApplicationEventPublisherAware {

    @Resource
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public String test() {
        User user = new User();
        user.setUsername("zhangsan");
        UserEvent userEvent = new UserEvent(this, user);

        applicationEventPublisher.publishEvent(userEvent);
        return "success";
    }
//    方法1
//    @Override
//    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
//        this.applicationEventPublisher = applicationEventPublisher;
//    }
}
