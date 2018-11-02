package com.niuzj.provider.user;

import com.niuzj.user.ICacheService;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@Service("cacheService")
public class CacheServiceImpl implements ICacheService {

    private AtomicInteger atomicInteger = new AtomicInteger();

    @Override
    public String findCache(int id) {
        System.out.println(atomicInteger.incrementAndGet());
        return "request " + id + ", response " + " " + new Random().nextInt(500);
    }
}
