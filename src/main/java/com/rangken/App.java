package com.rangken;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class App
{
  public static void main( String[] args )
  {
    JedisPool pool = new JedisPool(new JedisPoolConfig(), "localhost");

    Jedis jedis = pool.getResource();

    try
    {
        jedis.set("id1", "juju");
        jedis.set("id2", "jojo");

        System.out.println(jedis.get("id1"));
        System.out.println(jedis.get("id2"));

        System.out.println(jedis.dbSize());

    }
    finally
    {
        pool.returnResource(jedis);
    }
    pool.destroy();

  }
}
