# springboot-thread

简化的每日积分任务（BlockingQueue、ExecutorService）
1.生产者线程把积分任务数据存入BlockingQueue
2.消费者线程把BlockingQueue中的积分任务数据取出入库

BlockingQueue(阻塞队列)
1.BlockingQueue 是一个先进先出的队列（Queue)
2.为什么说是阻塞（Blocking）的呢？
是因为当获取队列元素但是队列为空时，会阻塞等待队列中有元素再返回；
也支持添加元素时，如果队列已满，那么等到队列可以放入新元素时再放入;

