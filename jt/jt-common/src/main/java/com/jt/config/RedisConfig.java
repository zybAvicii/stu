package com.jt.config;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisSentinelPool;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;


@Configuration
@PropertySource("classpath:/properties/redis.properties")
public class RedisConfig {
	@Value("${redis.nodes}")
	private String nodes;
	
	@Bean
	public JedisCluster jedisCluster() {
		Set<HostAndPort> set =new HashSet<>();
		 String[] nodeArray = nodes.split(",");
		 for (String node : nodeArray) {//获取各端口信息
			 String[] split = node.split(":");
			 String ip=split[0];
			 String portsString=split[1];
			 int port = Integer.parseInt(portsString);
			 set.add(new HostAndPort(ip, port));
		}
		JedisCluster jedisCluster = new JedisCluster(set);
		return jedisCluster;

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*单台redis配置
	@Value("${redis.host}")
	private String host;
	@Value("${redis.port}")
	private Integer port;
	
	@Bean
	public Jedis jedis() {
		return new Jedis(host,port);
	}
	*/
	
	/**
	 * 配置哨兵
	 * */
	/*@Value("${redis.masterName}")
	private String masterName;
	@Value("${redis.nodes}")
	private String nodes;
	
	@Bean("jedisSentinelPool")
	public JedisSentinelPool jedisSentinelPool() {
		Set<String> sentinels=new HashSet<>();
		sentinels.add(nodes);
		JedisSentinelPool pool = new JedisSentinelPool(masterName, sentinels);
		return pool;
	}
	
	@Bean
	public Jedis jedis(@Autowired JedisSentinelPool pool) {
		Jedis jedis = pool.getResource();
		
		return jedis;
		
	}
	
	*/
	
	
	/**
	 * 分片redis
	 * */
	/*
	@Value("${redis.nodes}")
	private String nodes;
	
	@Bean
	public ShardedJedis shardedJedis() {
		List<JedisShardInfo> shards=getShards();
		ShardedJedis shardedJedis=new ShardedJedis(shards);//ip+port
		return shardedJedis;	
	}

	private List<JedisShardInfo> getShards() {
		List<JedisShardInfo> list =new ArrayList<JedisShardInfo>();
		String[] split = nodes1.split(",");//192.168.1.1:123,192.168.1.1:123,192.168.1.1:123
				//-->{192.168.1.1:123 ,192.168.1.1:123,192.168.1.1:123 }
		for (String string : split) { //192.168.1.1:123
			String[] split2 = string.split(":");//{192.168.1.1  , 123}
			String ip=split2[0];
			String portstring = split2[1];
			int port = Integer.parseInt(portstring);
			JedisShardInfo info=new JedisShardInfo(ip,port);
			list.add(info);
		}
		return list;
	}
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}


























