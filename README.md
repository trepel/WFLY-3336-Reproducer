WFLY-3336-Reproducer
====================

It is buildable using http://repository.jboss.org/nexus/content/groups/public-jboss maven repository.


If you install Spring core jars as static module (spring -beans, -core, -context, -context-support, -web) and set their scope to provided, the SpringBean to EJB injection stops working.


