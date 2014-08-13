WFLY-3336-Reproducer
====================

It is buildable using http://repository.jboss.org/nexus/content/groups/public-jboss maven repository.


If you install Spring core jars as static module (spring -beans, -core, -context, -context-support, -web) and set their scope to provided, the SpringBean to EJB injection stops working.

SOLUTION:

If you have Spring installed as static module, you need to do following to make the Spring Bean injection into EJB work:

* Add annotations="true" to jboss-deployment-structure.xml
 * this tells the EJB container to scan for EJB annotations inside the static module (Spring static module in this case)
* The scanning process needs jandex index
* The SpringBeanAutowiringInterceptor uses EJB annotations, it is located in spring-context.jar
 * you need to create jandex index at least for this jar
* There are two ways to do it:
 * first: add jandex.idx into spring-context.jar/META-INF directory
 * second: create separate jandex.idx.jar file with content: /META-INF/jandex.idx and modify the module.xml accordingly (add line <resource-root path="jandex.idx.jar"/>)
* You can generate jandex.idx file using $WILDFLY_HOME/modules/system/layers/base/org/jboss/jandex/main/jandex-<version>.jar




