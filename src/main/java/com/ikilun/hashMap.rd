Լ��

Լ��ǰ�������ṹ��ÿһ������ΪͰ 
Լ��Ͱ�����ŵ�ÿһ�����ݳ�Ϊbin 
bin�������������JDK 1.8��HashMapע�͡�

size

size��ʾHashMap�д��KV��������Ϊ��������е�KV���ܺͣ���

capacity

capacity��Ϊ������capacity����ָHashMap��Ͱ��������Ĭ��ֵΪ16��һ���һ������ʱ�����ݵ�64��֮�������2������֮����������2���ݡ�

    /**
     * The default initial capacity - MUST be a power of two.
     */
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16
1
2
3
4
loadFactor

loadFactor��Ϊװ�����ӡ�װ��������������HashMap���ĳ̶ȡ�loadFactor��Ĭ��ֵΪ0.75f������HashMap��ʵʱװ�����ӵķ���Ϊ��size/capacity��������ռ��Ͱ������ȥ����capacity��

    /**
     * The load factor used when none specified in constructor.
     */
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
1
2
3
4
threshold

threshold��ʾ��HashMap��size����thresholdʱ��ִ��resize������ 
threshold=capacity*loadFactor

    /**
     * The next size value at which to resize (capacity * load factor).
     */
    int threshold;