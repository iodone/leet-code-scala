package LRUCache

/**
  * Created by iodone on {19-5-29}.
  */

import scala.collection.mutable.LinkedHashMap

/**
  * 解题报告
  * 
  * 说明：使用链表的数据结构，要求需要实现cache的O(1)的查询时间复杂度，
  * 链表加hash表组合完成，采用LinkedHashMap
  * 
  * 思路：1) get接口：
  *         根据key获取值，如果存在放到队尾，同时remove当前key，可以采用put方法完成
  *      2) put接口：
  *         remove当前的key
  *         队尾插入key
  *         判断是否超过cache容量大小，删除head,直到容量符合预设值
  * 
  */

class LRUCache(_capacity: Int) {

  val cacheRepo = new LinkedHashMap[Int, Int]()

  def get(key: Int): Int = {
    cacheRepo.get(key) match {
      case None => -1
      case Some(v) => {
        put(key, v)
        v
      }
    }
  }

  def put(key: Int, value: Int) {
    cacheRepo.remove(key)
    cacheRepo.put(key, value)
    while(cacheRepo.size > _capacity) {
      cacheRepo.remove(cacheRepo.head._1)
    }
  }
}

object Solution {
  def main(args: Array[String]) = {
    val cache = new LRUCache( 2 /* capacity */ );
    cache.put(1, 1)
    cache.put(2, 2)
    val a = cache.get(1)       // returns 1
    println(a)
    cache.put(3, 3);    // evicts key 2
    val b = cache.get(2);       // returns -1 (not found)
    println(b)
    cache.put(4, 4);    // evicts key 1
    val c = cache.get(1);       // returns -1 (not found)
    println(c)
    val d = cache.get(3);       // returns 3
    println(d)
    val e = cache.get(4);       // returns 4
    println(e)
  }
}

/**
  * Your LRUCache object will be instantiated and called as such:
  * var obj = new LRUCache(capacity)
  * var param_1 = obj.get(key)
  * obj.put(key,value)
  */
