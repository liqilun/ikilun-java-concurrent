利用它可以实现类似计数器的功能。比如有一个任务A，它要等待其他4个任务执行完毕之后才能执行，
此时就可以利用CountDownLatch来实现这种功能了。