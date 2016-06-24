
package org.bclove.common.taskha;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * 默认的负载均衡策略，尽量使得负载在所有consumer之间平均分配，consumer之间分配的分区数差距不大于1
 * 
 * @author soryokurin
 * @date 2012-04-05
 * 
 */
public class DefaultLoadBalanceStrategy implements LoadBalanceStrategy {

    static final Log log = LogFactory.getLog(DefaultLoadBalanceStrategy.class);


    @Override
    public List<String> getPartitions(final String topic, final String consumerId, final List<String> curConsumers,
            final List<String> curPartitions) {
        // 每个订阅者平均挂载的partition数目
        final int nPartsPerConsumer = curPartitions.size() / curConsumers.size();
        // 挂载到额外partition的consumer数目
        final int nConsumersWithExtraPart = curPartitions.size() % curConsumers.size();

        log.info("Consumer " + consumerId + " rebalancing the following partitions: " + curPartitions + " for topic "
                + topic + " with consumers: " + curConsumers);
        final int myConsumerPosition = curConsumers.indexOf(consumerId);
        if (myConsumerPosition < 0) {
            log.warn("No broker partions consumed by consumer " + consumerId + " for topic " + topic);
            return Collections.emptyList();
        }
        assert myConsumerPosition >= 0;
        // 计算起点
        final int startPart =
                nPartsPerConsumer * myConsumerPosition + Math.min(myConsumerPosition, nConsumersWithExtraPart);
        final int nParts = nPartsPerConsumer + (myConsumerPosition + 1 > nConsumersWithExtraPart ? 0 : 1);

        if (nParts <= 0) {
            log.warn("No broker partions consumed by consumer " + consumerId + " for topic " + topic);
            return Collections.emptyList();
        }
        final List<String> rt = new ArrayList<String>();
        for (int i = startPart; i < startPart + nParts; i++) {
            final String partition = curPartitions.get(i);
            rt.add(partition);
        }
        return rt;
    }
    
 public static void main(String[] args){
    	
    	List<String> list = new ArrayList<String>();
    	
    	for(int i=0;i<10;i++){
    		list.add("a"+i);
    	}
    	
    	List<String> list1 = new ArrayList<String>();
    	for(int i=0;i<100;i++){
    		list1.add(""+i);
    	}
    	DefaultLoadBalanceStrategy con = new DefaultLoadBalanceStrategy();
    	List<String> list3 = con.getPartitions("news", "a0", list, list1);
    	for(String con1:list3){
    	
    	
    
    	System.out.println(con1);
    	}
    	
    	
    	
    }

}