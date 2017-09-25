# liferay-spring-mvc-portlet
基于liferay 平台的spring mvc portlet简单示例

portal
	门户，是指正门、入口，现多用于互联网的门户（入口）网站和企业应用系统的门户系统。

portlet
	portlet 就是一个可插拔的用户界面组件，它提供了特定的内容，即它可以是一个服务或者是从已有系统中获取信息。 portlet通过访问特定的程序，系统或者数据源为portal产生用户界面，并且它还会产生原型去表现他的内容，提供给我们的portal用户。
	portlet 最大的职责就是去产生原型，例如html，xml等，这些都会在我们的portal页面中进行展示。
	一个portlet页面通常会展示多个portlet，每一个portlet都会有自己的风格和样式，portlet 是一个可插拔的用户界面组件，这就意味着portlet最大的职责是产生原型组件，不像是servlet，用户界面不是组件化的。所以portlet是怎么做到成为一个可插拔的组件的呢？
    portlet 是去产生原型代码片段，而不是去完成整个portal页面，那么展示portal页面的职责就交给了portal server，它会整合由portlet产生的原型代码片段，然后将其展示在portal page中。这就使得portlet自己更集中的产生自己的原型代码片段，而不必去理会其他的任何事情。

Spring Portlet MVC
	Spring框架通过Web MVC模块提供了自己的MVC实现，Spring框架的Portlet MVC模块则是基于Web MVC模块的Portlet实现。Portlet与Servlet的最大区别是请求的处理分为action阶段和render阶段。在一个请求中，action阶段只执行一次，但是render阶段可能由于用户的浏览器操作而被执行多次。

几种开源Portal
（1）Pluto
（2）Liferay
（3）eXo
（4）JetSpeed

Liferay
	Liferay（又称Liferay Portal）是一个开源门户项目，该项目包含了一个完整的J2EE应用。该项目使用了Web、EJB以及JMS等技术，特别是其前台界面部分使用Struts 框架技术，基于XML的portlet配置文件可以自由地动态扩展，使用了Web Services来支持一些远程信息的获取，使用 Apache Lucene实现全文检索功能。
	1、提供单一登陆接口，多认证模式（LDAP或SQL）;
	2、管理员能通过用户界面轻松管理用户，组，角色；
	3、用户可以根据需要定制个性化的portal layout;
	4、能够在主流的J2EE应用服务器上运行，如JBoss+Jetty/Tomcat,JOnAS；
	5、支持主流的数据库，如PostgreSQL,MySQL；
	6、使用了第三方的开源项目，如Hibernate, Lucene, Struts；
	7、支持包括中文在内的多种语言；
	8、采用最先进的技术 Java, EJB, JMS, SOAP, XML；

Liferay7环境搭建
软件环境：
liferay-portal-tomcat-7.0-ce-ga1-20160331161017956.zip
liferay-portal-src-7.0-ce-ga1-20160331161017956.zip
liferay-plugins-sdk-7.0-ce-ga1-20160331161017956.zip
liferay-ide-eclipse-windows-x64-3.0.0-ga1-201604280251.zip
注意1：Liferay 7.0的开发需要JDK8的环境。
注意2：Liferay 7.0运行需要的是JDK，而不仅仅是JRE（正常的J2EE软件的运行需要jre就足够）。
注意3：Liferay 7.0的开发SDK不是必须的，属于可选状态。

liferay 7.0采用OSGI的架构，开发模式基本支持两种，传统模式和OSGI的模块开发模式。

传统模式（基于ant或者maven）
第一步：进行SDK的目录。找到build.properties文件，将此文件复制一份并重命名为build.${username}.properties，其中的${username}为当前系统的用户名称。
第二步：到里面的app.server.parent.dir这个变量，将他的值修改为当前的Portal的路径，如
app.server.parent.dir=D:/liferay/liferay-ce-portal-7.0-ga4
第三步：启动liferay IDE，新建插件工程 New Liferay Plugin Project
第四步：在上面的向导中输入工程的名称，点击next，选择spring-mvc-portlet，点击下一步，在这里会让选择SDK的目录，SDK解压目录即可。
注意：在第一次创建工程的时候会下载大量的jar包，所以需要网络后，看着像卡差不动一样，一般根据网络情况，可能需要5-30分钟左右的时间。

OSGI模块模式(基于Gradle)
Liferay 7.0新增了基于Gradle构建系统的开发，这种是7.0推荐的模式。
第一步：创建liferay Workspace Project，输入工作区的名称。同一个Eclipse的工作区里面只能创建一个Workspace Project。
第二步：点击完成即可，此过程需要下载jar包，速度会比较慢，根据网络情况而定。下载的是gradle的zip包，具体是下载到当前用户目录下面的.gradle目录下面。
第三步：在菜单中点击New Liferay Module Project，在Project Template Name那里选择spring-mvc-portlet。
第四步：写完代码我们现在可以将页面视图切换到Liferay Workspace，默认就已经切换，如果没有进行些切换，在右边找到Gradle Tasks，如下图，找到我们创建的工程，然后点击下面的build，双击里面deploy，将会对我们当前的工程进行打包部署。
	注意：这里点击deploy正常就应该部署到Liferay tomcat里面，但是此时没有部署到Liferay tomcat里面。需要做如下修改，在上面的工作区里面找到gradle.properties文件，打开在里面添加如下的配置，后面的是liferay Tomcat所在的目录，不然只会将生成的jar包在上面工作区里面的module里面，需要手动的将jar包复制到deploy里面部署。
liferay.workspace.home.dir= D:/liferay/liferay-ce-portal-7.0-ga4
