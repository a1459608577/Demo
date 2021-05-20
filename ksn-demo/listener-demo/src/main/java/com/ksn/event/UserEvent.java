package com.ksn.event;

import com.ksn.entity.User;
import org.springframework.context.ApplicationEvent;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/4/26 14:18
 */
//@Component
public class UserEvent extends ApplicationEvent {

    private User user;
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public UserEvent(Object source, User user) {
        super(source);

        this.user = user;
    }

    public User gteUser() {
        return this.user;
    }

}
