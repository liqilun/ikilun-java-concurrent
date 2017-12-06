semaphore.tryAcquire()，尝试获取，不阻塞
semaphore.acquire()，没信号量可用时，将进行阻塞等

有参方法tryAcquire（long timeout, TimeUnit unit）的作用是在指定的时间内尝试地获取1个许可，如果获取不到就返回false。