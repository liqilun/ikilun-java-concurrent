1）lock(), 拿不到lock就不罢休，不然线程就一直block。 比较无赖的做法。
2）tryLock()，马上返回，拿到lock就返回true，不然返回false。 比较潇洒的做法。
带时间限制的tryLock()，拿不到lock，就等一段时间，超时返回false。比较聪明的做法。