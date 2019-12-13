1. 将项目下载到eclipse，项目右键Maven-download sources，update project下载依赖项。

1. 项目依赖cloud-common项目，请在build path-Projects中添加依赖，后续将依赖maven库中的common项目。

1. 项目启动：run as springboot app启动项目，或者run as Java Application，可以通过访问swagger-ui.html测试是否启动成功。

1. 生成代码： 

       （1）在EclipseMarket Place下载mybatis generator生成代码插件。

       （2）修改generatorConfig.xml内容，包括mysql驱动地址，targetPackage，targetProject，表名等
   
       （3）xml文件右键run as mybatis generator生成代码。

       （4）由于项目中使用了tkmybatis插件，生成后的代码要做改动，请将mapper.xml中的sql语句删除，将dao层mapper文件的所有方法删除，dao层继承Mapper类，泛型为对应的domian，domain的类名添加注解@Table，主键添加注解@Id，自己完善service和 controller即可，mapper方法丰富，单表查询一般情况都可以满足。
 
       （5）示例代码请参考：SysUserPos各层实现。

1. 服务与服务之间调用使用feign框架，示例代码请见remote/UserRemoteService.java。

1. 单元测试示例代码请见CloudDemoApplicationTests.java。

1. 一些配置项：    

       （1）@MapperScan为扫描的dao层包名，该注解在入口Application类上，请修改为自己的 dao层包名。

       （2）application.yml为配置文件，可以修改端口，以及mybatis扫描的model,xml包名路径

1. 本地开发可以将注册功能注释掉，以免报找不到server的错误，请将pom文件的以下代码注释，并将入口Application类的@EnableEurekaClient注释。

    ```
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-eureka-server</artifactId>
            <version>1.4.5.RELEASE</version>
            <type>pom</type>
        </dependency>   
    ```

1. 分页和排序集成了PageHelper框架，在service层两行代码就可以完成
	
	```
        public List<SysOrg> selectSysOrg(SysOrg sysOrg,int pageNo,int pageSize) {
			PageHelper.startPage(pageNo,pageSize);
			PageHelper.orderBy("show_index asc");
			return sysOrgMapper.select(sysOrg);
	   }
    ```

1. 新模块的新服务，请先让马勇copy demo项目代码到新的git地址，并修改demo为对应服务名。

1. 通用代码一律提取到common项目，每个服务只写业务相关的代码，代码在service层进行耦合。



