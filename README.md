# redis-cache-with-spring-boot

Used redis as cache.

Summary of annotations used:

<b>@EnableCaching</b> - Use it on the class that will be using cache annotations <br>
<b>@Cacheable</b> - Use it over the method, that needs to be cached <br>
<b>@CacheEvict</b> - Use it over the method, usually over DeleteMapping class, so that the object is removed from the database as well as from cache <br>
<b>@CachePut</b> - Use it when we want to put object into the cache along with the database
