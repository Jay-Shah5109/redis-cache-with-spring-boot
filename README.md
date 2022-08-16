# redis-cache-with-spring-boot

Used redis as cache.

Summary of annotations used:

@EnableCaching - Use it on the class that will be using cache annotations
@Cacheable - Use it over the method, that needs to be cached
@CacheEvict - Use it over the method, usually over DeleteMapping class, so that the object is removed from the database as well as from cache
@CachePut - Use it when we want to put object into the cache along with the database
