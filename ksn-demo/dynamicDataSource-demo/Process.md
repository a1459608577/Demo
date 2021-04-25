#配置动态数据源流程
####1.在数据库新建master， slave1， slave2三个库，然后在application.yml中配置一下连接信息
####2.自定义一个注解@SwitchDataSource，用来定义每个方法是用哪个数据源，顺便把切面写好，详情见SwitchDataSource.java和SwitchDataSourceAsecpt.java
####3.配置threadLocal，用来存储数据源的key，在切面转好难过的前置方法获取key存进去，在后置方法中清除数据，详情见HandleDataSource.java
####4.然后在编写一个类继承AbstractRoutingDataSource，这是在创建数据源的时候做操作，实现这个方法，返回key，这个key就是数据源的名字
####5.配置数据源，把配置文件中的每一个连接信息都配置成数据源，然后使用@Primary注解使选择数据源的那个Bean最优先，再把数据源都配置到TargetDataSources中，这里设置进去的，跟实现AbstractRoutingDataSource方法的就相通了
####6.配置一下mybatis-plus，配置他得SqlSessionFactory即可食用
#遇到的坑
###1. 循环依赖
#####主要是MyBatisAutoConfiguration会自动注册一个dataSourceInitializerPostProcessor，然后引入动态数据源的时候找别的数据源，就形成了循环依赖，
####解决方法
#####详情见DataSourceBeanFactoryPostProcessor.java，或者在启动类的SpringBootApplication上排除掉DataSourceAutoConfiguration.class即可
###2. 配置mybatis-plus后， 继承baseMapper不能使用baseMapper自带的方法，如，insert等
#####这个问题是因为配置mybatis-plus的时候配置的SqlSessionFactoryBean，改成MybatisSqlSessionFactoryBean即可，具体原因未知，可能用的是mybatis-plus吧
