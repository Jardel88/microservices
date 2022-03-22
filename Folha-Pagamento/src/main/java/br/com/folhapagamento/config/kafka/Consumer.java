package br.com.folhapagamento.config.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import br.com.folhapagamento.domain.dto.FuncionarioDTO;

@Component
public class Consumer {
	
	private static final Logger log =LoggerFactory.getLogger(Consumer.class);
	
	 @Value(value = "${topic.name}")
	    private String topic;
	 
	 @Value(value = "${spring.kafka.consumer.group-id}")
	   private String groupId;
	 
	 @KafkaListener(topics = "${topic.name}", groupId = "${spring.kafka.consumer.group-id}", containerFactory = "kafkaListenerContainerFactory")
	public void listenerTopic(ConsumerRecord<String, FuncionarioDTO> record) {
		 
		 log.info("Received Message: " + record.partition());
		 log.info("Received Message: " + record.value());
		
	}
	

}
