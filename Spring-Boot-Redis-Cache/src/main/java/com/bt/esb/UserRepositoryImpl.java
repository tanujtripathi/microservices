package com.bt.esb;

import com.bt.esb.model.Appointment;


import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class UserRepositoryImpl implements UserRepository {
	
	private RedisTemplate<String, Appointment> redisTemplate;
    private HashOperations hashOperations;
   
    public UserRepositoryImpl(RedisTemplate<String, Appointment> redisTemplate) {
        this.redisTemplate = redisTemplate;

        hashOperations = redisTemplate.opsForHash();
    }
	
	@Override
	public void save(Appointment appt) {
		// TODO Auto-generated method stub
		hashOperations.put("APPT", appt.getRefNum(), appt);
	}
	@Override
	public Appointment findByRefNo(String refNo) {
		// TODO Auto-generated method stub
		return (Appointment)hashOperations.get("APPT", refNo);
	}
	@Override
	public Map<String, Appointment> findAllAppt() {
		// TODO Auto-generated method stub
		return hashOperations.entries("APPT");
	}

}
