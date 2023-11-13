package com.redis.connect.pipeline.producer.impl.load;

import org.apache.geode.cache.execute.Function;
import org.apache.geode.cache.execute.FunctionContext;
import org.apache.geode.cache.execute.FunctionException;
import org.apache.geode.cache.execute.RegionFunctionContext;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RedisConnectMultiGetFunction implements Function {

    @Override
    public String getId() {
        return "redis-connect-query";
    }

    @Override
    public void execute(FunctionContext functionContext) {
        try {
            RegionFunctionContext context = (RegionFunctionContext) functionContext;

            Set<Object> keySet = (Set<Object>) context.getFilter();
            if (keySet != null && !keySet.isEmpty()) {

                Map<Object, Object> resultMap = new HashMap(keySet.size());
                for (Object key : keySet)
                    resultMap.put(key, context.getDataSet().get(key));
                context.getResultSender().sendResult(resultMap);
            } else context.getResultSender().sendResult(null);

            context.getResultSender().lastResult(null);

        } catch (Exception e) {
            throw new FunctionException(e);
        }
    }

    @Override
    public boolean hasResult() {
        return true;
    }

    @Override
    public boolean isHA() {
        return false;
    }

    @Override
    public boolean optimizeForWrite() {
        return false;
    }

}