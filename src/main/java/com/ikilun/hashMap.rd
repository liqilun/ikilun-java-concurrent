约定

约定前面的数组结构的每一个格格称为桶 
约定桶后面存放的每一个数据称为bin 
bin这个术语来自于JDK 1.8的HashMap注释。

size

size表示HashMap中存放KV的数量（为链表和树中的KV的总和）。

capacity

capacity译为容量。capacity就是指HashMap中桶的数量。默认值为16。一般第一次扩容时会扩容到64，之后好像是2倍。总之，容量都是2的幂。

    /**
     * The default initial capacity - MUST be a power of two.
     */
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16
1
2
3
4
loadFactor

loadFactor译为装载因子。装载因子用来衡量HashMap满的程度。loadFactor的默认值为0.75f。计算HashMap的实时装载因子的方法为：size/capacity，而不是占用桶的数量去除以capacity。

    /**
     * The load factor used when none specified in constructor.
     */
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
1
2
3
4
threshold

threshold表示当HashMap的size大于threshold时会执行resize操作。 
threshold=capacity*loadFactor

    /**
     * The next size value at which to resize (capacity * load factor).
     */
    int threshold;